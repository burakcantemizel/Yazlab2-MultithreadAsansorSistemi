package com.asansorsistemi;


import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;


//Belli bir sürede rastgele bir kattan rastgele kişiyi o katın çıkış kuyruğuna ekliyor.
public class AvmCikis implements Runnable {

    private static final int ZAMAN_ARALIGI = 1000;
    Random random;

    public AvmCikis() {
        random = new Random();
    }

    //Threadin ana döngüsü
    @Override
    public void run() {

        while (true) {
            katlardanCikisYaptirt();

            try {
                Thread.sleep(ZAMAN_ARALIGI * AsansorSistemi.ZAMAN_CARPANI);
            } catch (InterruptedException ex) {
                System.out.println("Avm Çıkış Thread hatası!");
            }
        }

    }

    //Katlardan çıkışı yaptıran fonksiyon
    public synchronized void katlardanCikisYaptirt() {
        //Kuyruk olan rastgele bir kat seç
        //1 den 5e kadar bir rakam seç ve kattan çıkart
        
        
        //Yeni bir integer listesi oluşturduk.
        List<Integer> cikisYapilabilirKatlar = new CopyOnWriteArrayList<Integer>();

        //İfler ile katlardaki kişilere bakıyoruz birinin çıkabilmesi için
        //katlarda insan bulunması gerek. tek tek insan olan katları saptıyoruz.
        if (Avm.birinciKatListe.size() > 0) {
            cikisYapilabilirKatlar.add(1);
        }
        if (Avm.ikinciKatListe.size() > 0) {
            cikisYapilabilirKatlar.add(2);
        }
        if (Avm.ucuncuKatListe.size() > 0) {
            cikisYapilabilirKatlar.add(3);
        }
        if (Avm.dorduncuKatListe.size() > 0) {
            cikisYapilabilirKatlar.add(4);
        }

        //Diğer işlemlerde kullanacağımız değişkenleri default değerleriyle tanımladık.
        int kat = -1;
        List<Grup> katReferansi = null;
        LinkedBlockingQueue<Grup> kuyrukReferansi = null;

        //Daha önce oluşturduğumuz uygun kat listesinden
        //Random bir kat seçelim
        if (cikisYapilabilirKatlar.size() > 0) {
            Collections.shuffle(cikisYapilabilirKatlar);
            kat = cikisYapilabilirKatlar.get(0);
        }

        //Bu kata göre kullancağımız değişkenlere ilgili kuyruk ve listenin referansını atıyoruz.
        if (kat == 1) {
            katReferansi = Avm.birinciKatListe;
            kuyrukReferansi = Avm.birinciKatKuyruk;
        } else if (kat == 2) {
            katReferansi = Avm.ikinciKatListe;
            kuyrukReferansi = Avm.ikinciKatKuyruk;
        } else if (kat == 3) {
            katReferansi = Avm.ucuncuKatListe;
            kuyrukReferansi = Avm.ucuncuKatKuyruk;
        } else if (kat == 4) {
            katReferansi = Avm.dorduncuKatListe;
            kuyrukReferansi = Avm.dorduncuKatKuyruk;
        }

        //System.out.println("Testt");

        //Katı seçtik
        int cikacakKisi = 1 + random.nextInt(5); // 1 ve 5 arası kisi cikacak

        int cikanKisi = 0;
        
        
        //Artık elimizde kaç kişinin çıkacağı, liste ve kuyruk bilgileri var
        //bu noktadan sonra çıkarma işlemini yapabiliriz.

        //Çıkış için katreferansının null olmaması gerek
        if (katReferansi != null) {
            if (katReferansi.get(0).kisiSayisi <= 5) {
                //Kişi sayısı 5ten küçükse
                //Burda direkt çıkartma işlemi yapabiliriz
                Grup g = katReferansi.get(0);
                g.hedefKat = 0;
                kuyrukReferansi.add(g);
                katReferansi.remove(g);
            } else {
                //Burda bölümleme yapicaz 5ten büyük kisi var cikacakKisiye gore
                //Grubu parçalıyoruz çıkabilenler çıkıyor asansöre sığmayanlr
                //kuyruğun başında beklemeye devam ediyor.
                Grup g = katReferansi.get(0);
                Grup yenig = new Grup(cikacakKisi, 0);
                g.kisiSayisi -= cikacakKisi;
                kuyrukReferansi.add(yenig);

            }
        }

    }

}
