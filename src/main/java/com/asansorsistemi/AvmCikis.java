package com.asansorsistemi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvmCikis implements Runnable {

    private static final int ZAMAN_ARALIGI = 1000;
    Random random;

    public AvmCikis() {
        random = new Random();
    }

    @Override
    public void run() {

        while (true) {
            katlardanCikisYaptirt();

            try {
                Thread.sleep(ZAMAN_ARALIGI * AsansorSistemi.ZAMAN_CARPANI);
            } catch (InterruptedException ex) {

            }
        }

    }

    public synchronized void katlardanCikisYaptirt() {
        //Kuyruk olan rastgele bir kat seç
        //1 den 5e kadar bir rakam seç ve kattan çıkart
        List<Integer> cikisYapilabilirKatlar = new CopyOnWriteArrayList<Integer>();

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

        int kat = -1;
        List<Grup> katReferansi = null;
        LinkedBlockingQueue<Grup> kuyrukReferansi = null;

        //Random bir kat seçelim
        if (cikisYapilabilirKatlar.size() > 0) {
            Collections.shuffle(cikisYapilabilirKatlar);
            kat = cikisYapilabilirKatlar.get(0);
        }

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

        System.out.println("Testt");

        //Katı seçtik
        int cikacakKisi = 1 + random.nextInt(5); // 1 ve 5 arası kisi cikacak

        int cikanKisi = 0;

        if (katReferansi != null) {
            if (katReferansi.get(0).kisiSayisi <= 5) {
                //Burda direkt çıkartma işlemi yapabiliriz
                Grup g = katReferansi.get(0);
                g.hedefKat = 0;
                kuyrukReferansi.add(g);
                katReferansi.remove(g);
            } else {
                //Burda bölümleme yapicaz 5ten büyük kisi var cikacakKisiye gore
                Grup g = katReferansi.get(0);
                Grup yenig = new Grup(cikacakKisi, 0);
                g.kisiSayisi -= cikacakKisi;
                kuyrukReferansi.add(yenig);

            }
        }

    }

}
