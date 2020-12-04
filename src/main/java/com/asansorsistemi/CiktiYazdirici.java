package com.asansorsistemi;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CiktiYazdirici implements Runnable {

    public int zamanAraligi;

    public CiktiYazdirici(int zamanAraligi) {
        this.zamanAraligi = zamanAraligi;
    }

    @Override
    public void run() {
        //Yazdırma Önceliğini İleriye Atıyoruz.
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {

        }
        while (true) {
            try {
                ciktiYazdir();
                Thread.sleep(zamanAraligi);
            } catch (Exception ex) {
                System.out.println("CiktiYazdirici Thread Hatası!");
            }
        }
    }

    public synchronized void ciktiYazdir() {
        System.out.println("----------------------------------------------------------");
        System.out.println("0. kat : kuyruk : " + AsansorSistemi.kuyruktakiKisiSayisi(Avm.zeminKatKuyruk));
        System.out.println("1. kat : Kattaki: " + AsansorSistemi.ListedekiKisiSayisi(Avm.birinciKatListe) + " kuyruk : " + AsansorSistemi.kuyruktakiKisiSayisi(Avm.birinciKatKuyruk));
        System.out.println("2. kat : Kattaki: " + AsansorSistemi.ListedekiKisiSayisi(Avm.ikinciKatListe) + " kuyruk : " + AsansorSistemi.kuyruktakiKisiSayisi(Avm.ikinciKatKuyruk));
        System.out.println("3. kat : Kattaki: " + AsansorSistemi.ListedekiKisiSayisi(Avm.ucuncuKatListe) + " kuyruk : " + AsansorSistemi.kuyruktakiKisiSayisi(Avm.ucuncuKatKuyruk));
        System.out.println("4. kat : Kattaki: " + AsansorSistemi.ListedekiKisiSayisi(Avm.dorduncuKatListe) + " kuyruk : " + AsansorSistemi.kuyruktakiKisiSayisi(Avm.dorduncuKatKuyruk));
        System.out.println("Cikis yapanlar : " + Avm.cikisYapanlar);

        System.out.println();
        AsansorYazdir(AsansorSistemi.asansor1);

        System.out.print("0. kat : ");
        kuyrukBilgisi(Avm.zeminKatKuyruk);
        System.out.print("1. kat : ");
        kuyrukBilgisi(Avm.birinciKatKuyruk);
        System.out.print("2. kat : ");
        kuyrukBilgisi(Avm.ikinciKatKuyruk);
        System.out.print("3. kat : ");
        kuyrukBilgisi(Avm.ucuncuKatKuyruk);
        System.out.print("4. kat : ");
        kuyrukBilgisi(Avm.dorduncuKatKuyruk);

    }

    public synchronized void AsansorYazdir(Asansor asansor) {
        System.out.println("Aktiflik : " + asansor.aktif);
        System.out.println("\tMod: " + asansor.mod);
        System.out.println("\tMevcut Kat: " + asansor.mevcutKat);
        System.out.println("\tYön: " + asansor.yon);
        System.out.println("\tKapasite: " + Asansor.MAKSIMUM_KAPASITE);
        System.out.println("\tMevcut Kişi Sayısı :" + asansor.mevcutKisiSayisi);
        System.out.print("\tİçeridekiler : ");
        AsansorIcindekiler(asansor.iceridekiler);
    }

    public synchronized void kuyrukBilgisi(LinkedBlockingQueue<Grup> kuyruk) {
        int i = 0;
        System.out.print("[ ");
        for (Grup g : kuyruk) {
            if (i != 0) {
                System.out.print(" , ");
            }
            i++;
            System.out.print("[" + g.kisiSayisi + "," + g.hedefKat + "]");
        }
        System.out.print(" ]\n");
    }

    public synchronized void AsansorIcindekiler(ArrayList<Grup> iceridekiler) {
        int i = 0;
        System.out.print("[ ");
        for (Grup g : iceridekiler) {
            if (i != 0) {
                System.out.print(" , ");
            }
            i++;
            System.out.print("[" + g.kisiSayisi + "," + g.hedefKat + "]");
        }
        System.out.print(" ]\n");
    }

}
