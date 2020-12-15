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
        this.hedefKat = 0;
        this.yon = "yukari";
        this.mevcutKisiSayisi = 0;
        this.iceridekiler = Collections.synchronizedList(new ArrayList<Grup>());

        //Ozel Sartlar
        if (this.id == 1) {
            //Sürekli Çalışan
            this.aktif = true;
            this.mod = "beklemede";
        }
    }

    //Asansörün ana çalışma döngüsü
    @Override
    public void run() {
        while (true) {

            if (this.aktif == true || this.mevcutKisiSayisi > 0) {
                this.mod = "calisiyor";
                //System.out.println(this.id);
                asansorHedefBelirle();

                //Yolcu İndirme İşlemi
                try {
                    asansordenYolcuIndir();
                } catch (Exception e) {
                    System.out.println("Yolcu inmesinde problem!");
                }

                //Yolcu alma işlemi
                try {
                    asansoreYolcuAl(); //Asansöre binildi.
                } catch (Exception e) {
                    System.out.println("Yolcu binmesinde problem!");
                }

                //Hedef belirleme
                asansorHedefBelirle();

                //Hedefe ilerleme
                if (yon == "yukari" && mevcutKat < hedefKat) {
                    mevcutKat++;
                }
                if (yon == "asagi" && mevcutKat > hedefKat) {
                    mevcutKat--;
                }

                //Katlar arasında bekleme
                try {
                    Thread.sleep(200 * AsansorSistemi.ZAMAN_CARPANI);
                } catch (InterruptedException ex) {
                    System.out.println("Kat atasi gecis thread hatasi!");
                }
            } else {
                //Asansör hareket etmiyor
                this.mod = "beklemede";
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    System.out.println("Asansor dongu thread hatasi!");
                }
            }
        }
    }

    //Kuyrugun en basindaki gruptan asansör içerisindeki boş yer kadar kişiyi alıp asansöre ekler.
    public synchronized void asansoreYolcuAl(LinkedBlockingQueue kuyruk, Asansor asansor) {
        //Kuyrukta Kişi varsa asansöre yolcu alabiliriz.
        if (kuyruk.size() <= 0) {
            return;

        }

        while (asansor.mevcutKisiSayisi < Asansor.MAKSIMUM_KAPASITE) {
            if (kuyruk.size() <= 0) {
                return;

            }
            //Asansör dolana kadar yolcu alabiliriz ama kuyrukta kişi biterse duruyoruz

            if (AsansorSistemi.kuyruktakiKisiSayisi(kuyruk) > 0) {
                //Baştaki grubu aldık
                Grup kuyrugunBasindaki = (Grup) kuyruk.peek();

                //Boşyeri hesapladık
                int bosYer = Asansor.MAKSIMUM_KAPASITE - asansor.mevcutKisiSayisi;

                //Eğer gruptan fazla boş yer varsa direkt ekleme yapıcaz.
                if (bosYer >= kuyrugunBasindaki.kisiSayisi) {
                    asansor.iceridekiler.add(kuyrugunBasindaki); //Burda direkt olarak grup alındı.
                    kuyruk.poll();
                    asansor.mevcutKisiSayisi += kuyrugunBasindaki.kisiSayisi;
                } else {
                    //Eğer tüm grubu alamıyorsak grubu bölerek alabildiğimizi alıyoruz
                    Grup eklenecek = new Grup(bosYer, kuyrugunBasindaki.hedefKat);
                    asansor.iceridekiler.add(eklenecek);
                    asansor.mevcutKisiSayisi += eklenecek.kisiSayisi;
                    kuyrugunBasindaki.kisiSayisi -= bosYer;

                }
            }
        }

    }

    //Asansördeki yolcuları katlara indiriyoruz.
    public synchronized void asansordenYolcuIndir(List<Grup> liste, Asansor asansor) {
        //Katlardaki inme olacak
        if (this.iceridekiler.size() > 0) {
            Iterator<Grup> it = this.iceridekiler.iterator();
            //Iterator objesiyle içerdeki kişileri geziyoruz thread exceptiondan kaçınmak için

            while (it.hasNext()) {
                Grup g = it.next();
                if (g.hedefKat == mevcutKat) {
                    //Eğer içerideki herhangi bir grubun hedefkatı şu an olan bir katsa
                    //O grubu o katta indiriyoruz.
                    liste.add(g);
                    this.mevcutKisiSayisi -= g.kisiSayisi;
                    //this.iceridekiler.remove(g);
                    it.remove();

                }

            }
        }

    }

    //Yolcu Indirme fonksiyonunu tüm listeler üzerinde uygulayan bir üst method
    public synchronized void asansordenYolcuIndir() {
        if (this.mevcutKat == 0) {
            //Özel Çıkış Komple Çıkış
            //Eğer kat 0 ise direkt olarak sistemden çıkıyor insanlar
            //Yine iteratör ile gezip gerekli olanları sistemden çıkarıyoruz.
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
            //Diğer durumlarda ilgili katın listesiyle asansörden indirme yapıyoruz.
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
        //if (this.mevcutKisiSayisi > 0) {


        //****************************************
        //Asansör hedef belirleme mantığı gerçek avm asansörlerindeki gibidir.
        //Örnek olarak açıklanması gerekirse
        //Sistem önce içerdeki yolculara bakar ve en küçükten başlayarak onları katlara bırakır.
        //İçerdei yolcular bırakıldıktan sonra yön yukarı doğru olduğu için üst katlarda inmek isteyen var mı diye bakar
        //Eğer inmek isteyen insan var ise yukarı doğru devam eder ve onları da alır yok ise alttaki katlara bakmaya başlar
        //Yön aşağı olduğu için aşağı doğru yolcu alarak hedef kata devam eder
        //Bu çalışma mantığıyla çalışır.
        //****************************************
        //kattanBuyukEnKucuk();
        //kattanKucukEnBuyuk();

        //System.out.println("Hedef :::::::: +" + hedef);
        //} else {
        //    this.hedefKat = 0;
        //    this.yon = "asagi";
        //}
        
        
        
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
                
            }else{
                if (this.yon == "yukari" && this.mevcutKat < 4 && Avm.dorduncuKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 4;
                } else if (this.yon == "yukari" && this.mevcutKat < 3 && Avm.ucuncuKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 3;
                } else if (this.yon == "yukari" && this.mevcutKat < 2 && Avm.ikinciKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 2;
                } else if (this.yon == "yukari" && this.mevcutKat < 1 && Avm.birinciKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 1;
                } else {
                    this.yon = "asagi";
                    this.hedefKat = 0;
                }
            }
        }else{
            if (this.yon == "yukari" && this.mevcutKat < 4 && Avm.dorduncuKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 4;
                } else if (this.yon == "yukari" && this.mevcutKat < 3 && Avm.ucuncuKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 3;
                } else if (this.yon == "yukari" && this.mevcutKat < 2 && Avm.ikinciKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 2;
                } else if (this.yon == "yukari" && this.mevcutKat < 1 && Avm.birinciKatKuyruk.size() > 0) {
                    this.yon = "yukari";
                    this.hedefKat = 1;
                } else {
                    this.yon = "asagi";
                    this.hedefKat = 0;
                }
        }
        
        
        
        
        
        
        
        
        
        
    }

    
    
    //Asansöre yolcu alan üst metod asansöre yolcu al metoduna ilgili kuyruk
    //nesnelerini gönderiyor.
    public synchronized void asansoreYolcuAl() {
        if (this.mevcutKat == 0) {
            asansoreYolcuAl(Avm.zeminKatKuyruk, this);
        } else if (this.mevcutKat == 1 && yon == "asagi") {
            asansoreYolcuAl(Avm.birinciKatKuyruk, this);
        } else if (this.mevcutKat == 2 && yon == "asagi") {
            asansoreYolcuAl(Avm.ikinciKatKuyruk, this);
        } else if (this.mevcutKat == 3 && yon == "asagi") {
            asansoreYolcuAl(Avm.ucuncuKatKuyruk, this);
        } else if (this.mevcutKat == 4) {
            asansoreYolcuAl(Avm.dorduncuKatKuyruk, this);
        }
    }

}
