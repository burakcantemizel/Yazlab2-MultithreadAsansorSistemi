package com.asansorsistemi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Asansor implements Runnable {

    public final static int MAKSIMUM_KAPASITE = 10;
    private final static int KAT_ARASI_GECIS = 200;

    int id;
    boolean aktif;
    String mod;
    int mevcutKat;
    int hedefKat;
    String yon;
    int mevcutKisiSayisi;
    List<Grup> iceridekiler;

    public Asansor(int id) {
        //Standart Asansor Ozellikleri
        this.id = id;
        this.aktif = false;
        this.mod = "beklemede";
        this.mevcutKat = 0;
        this.hedefKat = -1;
        this.yon = "yukari";
        this.mevcutKisiSayisi = 0;
        this.iceridekiler = Collections.synchronizedList(new ArrayList<Grup>());

        //Ozel Sartlar
        if (this.id == 1) {
            //Sürekli Çalışan
            this.aktif = true;
            this.mod = "calisiyor";
        }
    }

    @Override
    public void run() {
        while (true) {
            asansorHedefBelirle();
            
            try{
                asansordenYolcuIndir();
            }catch(Exception e){
                System.out.println("Yolcu inmesinde problem!");
            }
          
            try{
                asansoreYolcuAl(); //Asansöre binildi.
            }catch(Exception e){
                System.out.println("Yolcu binmesinde problem!");
            }
            
            asansorHedefBelirle();

            if (yon == "yukari" && mevcutKat < hedefKat) {
                mevcutKat++;
            }
            if (yon == "asagi" && mevcutKat > hedefKat) {
                mevcutKat--;
            }
            
            try {
                   Thread.sleep(200 * AsansorSistemi.ZAMAN_CARPANI);
            } catch (InterruptedException ex) {
                Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 }

    //Kuyrugun en basindaki tek bir grubu alıp asansöre ekler.
    public synchronized void asansoreYolcuAl(LinkedBlockingQueue kuyruk, Asansor asansor) {
        //Kuyrukta Kişi varsa asansöre yolcu alabiliriz.
        if(kuyruk.size() <= 0){
                return;
            
        }
        while (asansor.mevcutKisiSayisi < Asansor.MAKSIMUM_KAPASITE) {   
          
            
            if (AsansorSistemi.kuyruktakiKisiSayisi(kuyruk) > 0) {
                Grup kuyrugunBasindaki = (Grup) kuyruk.peek();
                int bosYer = Asansor.MAKSIMUM_KAPASITE - asansor.mevcutKisiSayisi;
                if (bosYer >= kuyrugunBasindaki.kisiSayisi) {
                    asansor.iceridekiler.add(kuyrugunBasindaki); //Burda direkt olarak grup alındı.
                    kuyruk.poll();
                    asansor.mevcutKisiSayisi += kuyrugunBasindaki.kisiSayisi;
                } else {
                    //Eğer tüm grubu alamıyorsa
                    Grup eklenecek = new Grup(bosYer, kuyrugunBasindaki.hedefKat);
                    asansor.iceridekiler.add(eklenecek);
                    asansor.mevcutKisiSayisi += eklenecek.kisiSayisi;
                    kuyrugunBasindaki.kisiSayisi -= bosYer;

                }
            }
        }
    }

    public synchronized void asansordenYolcuIndir(List<Grup> liste, Asansor asansor) {
        //Katlardaki inme olacak
        if (this.iceridekiler.size() > 0) {
            Iterator<Grup> it = this.iceridekiler.iterator();

            while (it.hasNext()) {
                Grup g = it.next();
                if (g.hedefKat == mevcutKat) {
                    liste.add(g);
                    this.mevcutKisiSayisi -= g.kisiSayisi;
                    //this.iceridekiler.remove(g);
                    it.remove();
                }

            }
        }

    }

    public synchronized void asansordenYolcuIndir() {
        if (this.mevcutKat == 0) {
            //Özel Çıkış Komple Çıkış
            if (this.iceridekiler.size() > 0) {
                Iterator<Grup> it = this.iceridekiler.iterator();

                while (it.hasNext()) {
                    Grup g = it.next();
                    if (g.hedefKat == 0) {
                        Avm.cikisYapanlar += g.kisiSayisi;
                        this.mevcutKisiSayisi -= g.kisiSayisi;
                        //this.iceridekiler.remove(g);
                        it.remove();
                    }
                }

            }
        } else if (this.mevcutKat == 1) {
            asansordenYolcuIndir(Avm.birinciKatListe, this);
        } else if (this.mevcutKat == 2) {
            asansordenYolcuIndir(Avm.ikinciKatListe, this);
        } else if (this.mevcutKat == 3) {
            asansordenYolcuIndir(Avm.ucuncuKatListe, this);
        } else if (this.mevcutKat == 4) {
            asansordenYolcuIndir(Avm.dorduncuKatListe, this);
        }
    }

    //Bir seferlik sonraki hedefi belirledi.
    public synchronized void asansorHedefBelirle() {
        if(this.mevcutKisiSayisi > 0){
            int hedef = this.hedefKat;
            
            
            kattanBuyukEnKucuk();
            kattanKucukEnBuyuk();
            
            System.out.println("Hedef :::::::: +" + hedef);
        }else{
            this.hedefKat = 0;
            this.yon = "asagi";
        }
    }

    public synchronized void kattanBuyukEnKucuk() {
        if (this.iceridekiler.size() > 0) {
            int enKucuk = this.iceridekiler.get(0).hedefKat;
            for (Grup g : this.iceridekiler) {
                if (enKucuk >= g.hedefKat) {
                    enKucuk = g.hedefKat;
                }
            }

            if (enKucuk > mevcutKat) {
                this.yon = "yukari";
                this.hedefKat = enKucuk;
                return;
            } else {
                //Asagi dogru gitmesi gerek yukarda bir hedef yok
                this.yon = "asagi";
            }
        }else{
            this.yon = "asagi";
            this.hedefKat = 0;
            return;
        }
    }

    public synchronized void kattanKucukEnBuyuk() {
        if (this.iceridekiler.size() > 0) {
            int enBuyuk = this.iceridekiler.get(0).hedefKat;
            for (Grup g : this.iceridekiler) {
                if (enBuyuk <= g.hedefKat) {
                    enBuyuk = g.hedefKat;
                }
            }

            if (enBuyuk < mevcutKat) {
                //Yukarıda bir hedef
                //Yukari dogru hedef belirlicem
                this.yon = "asagi";
                this.hedefKat = enBuyuk;
                return;
            } else {
                //Asagi dogru gitmesi gerek yukarda bir hedef yok
                this.yon = "yukari";
            }
        }else{
            this.yon = "asagi";
            this.hedefKat = 0;
            return;
        }
    }

    public synchronized void asansoreYolcuAl() {
        if (this.mevcutKat == 0) {
            asansoreYolcuAl(Avm.zeminKatKuyruk, this);
        } else if (this.mevcutKat == 1) {
            asansoreYolcuAl(Avm.birinciKatKuyruk, this);
        } else if (this.mevcutKat == 2) {
            asansoreYolcuAl(Avm.ikinciKatKuyruk, this);
        } else if (this.mevcutKat == 3) {
            asansoreYolcuAl(Avm.ucuncuKatKuyruk, this);
        } else if (this.mevcutKat == 4) {
            asansoreYolcuAl(Avm.dorduncuKatKuyruk, this);
        }
    }

}
