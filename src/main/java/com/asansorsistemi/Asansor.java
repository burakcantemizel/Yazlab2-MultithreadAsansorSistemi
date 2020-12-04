package com.asansorsistemi;

import java.util.ArrayList;
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
    ArrayList<Grup> iceridekiler;

    public Asansor(int id) {
        //Standart Asansor Ozellikleri
        this.id = id;
        this.aktif = false;
        this.mod = "beklemede";
        this.mevcutKat = 0;
        this.hedefKat = 1;
        this.yon = "yukari";
        this.mevcutKisiSayisi = 0;
        this.iceridekiler = new ArrayList<Grup>();

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
            
        }

    }

    //Kuyrugun en basindaki tek bir grubu alıp asansöre ekler.
    public synchronized void asansoreYolcuAl(LinkedBlockingQueue kuyruk, Asansor asansor) {
        //Kuyrukta Kişi varsa asansöre yolcu alabiliriz.
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

    public synchronized boolean asansordenYolcuIndir(ArrayList<Grup> liste, Asansor asansor) {
        //Her katta tetiklensin asansörün içinde o katta inecek birisi var ise onu indirsin
        for (Grup g : asansor.iceridekiler) {
            if (g.hedefKat == asansor.mevcutKat) {
                if (g.hedefKat == 0) {
                    Avm.cikisYapanlar += g.kisiSayisi;
                    asansor.mevcutKisiSayisi -= g.kisiSayisi;
                    asansor.iceridekiler.remove(g);
                    return true;
                } else {
                    if (liste != null) {
                        liste.add(g);
                    }
                    asansor.mevcutKisiSayisi -= g.kisiSayisi;
                    asansor.iceridekiler.remove(g);
                    return true;
                }

            }
        }
        return false;
    }
    
    public int hedefBelirle(){
        
    }

    /*HURDALIK
                      //calisiyor dursun bi

                    //MevcutKat şu an 0
                    //Yon yukari
                    this.yon = "yukari";
                    asansordenYolcuIndir(null, this); //Zeminden direkt çıkış
                    asansoreYolcuAl(Avm.zeminKatKuyruk, this);
                    this.hedefKat = 1;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 1;
                    asansordenYolcuIndir(Avm.birinciKatListe, this);
                    asansoreYolcuAl(Avm.birinciKatKuyruk, this);
                    this.hedefKat = 2;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 2;
                    asansordenYolcuIndir(Avm.ikinciKatListe, this);
                    asansoreYolcuAl(Avm.ikinciKatKuyruk, this);
                    this.hedefKat = 3;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 3;
                    asansordenYolcuIndir(Avm.ucuncuKatListe, this);
                    asansoreYolcuAl(Avm.ucuncuKatKuyruk, this);
                    this.hedefKat = 4;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 4;
                    this.yon = "asagi";
                    asansordenYolcuIndir(Avm.dorduncuKatListe, this);
                    asansoreYolcuAl(Avm.dorduncuKatKuyruk, this);
                    this.hedefKat = 3;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 3;
                    asansordenYolcuIndir(Avm.ucuncuKatListe, this);
                    asansoreYolcuAl(Avm.ucuncuKatKuyruk, this);
                    this.hedefKat = 2;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 2;
                    asansordenYolcuIndir(Avm.ikinciKatListe, this);
                    asansoreYolcuAl(Avm.ikinciKatKuyruk, this);
                    this.hedefKat = 1;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 1;
                    asansordenYolcuIndir(Avm.birinciKatListe, this);
                    asansoreYolcuAl(Avm.birinciKatKuyruk, this);
                    this.hedefKat = 0;
                    Thread.sleep(KAT_ARASI_GECIS);

                    this.mevcutKat = 0;
    
     */
}
