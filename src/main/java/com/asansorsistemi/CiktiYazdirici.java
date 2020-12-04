package com.asansorsistemi;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CiktiYazdirici implements Runnable {

    public int zamanAraligi;

    public CiktiYazdirici(int zamanAraligi) {
        this.zamanAraligi = zamanAraligi;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Burda oluşan hatalar önemsiz sadece yazdırmayı etkiliyor.
                
                //Yazdirma işlemleri yapılacaks
                System.out.println("0. kat : kuyruk : " + kuyruktakiKisiSayisi(Avm.zeminKatKuyruk));

                System.out.print("0. kat : ");
                kuyrukBilgisi(Avm.zeminKatKuyruk);

                Thread.sleep(zamanAraligi);
            } catch (Exception ex) {
                //System.out.println("CiktiYazdirici Thread Hatası!");
            }
        }
    }

    public synchronized int kuyruktakiKisiSayisi(Queue<Grup> kuyruk) {
        if (kuyruk.size() > 0) {
            int toplamKisi = 0;
            for (Grup g : kuyruk) {
                toplamKisi += g.kisiSayisi;
            }
            return toplamKisi;
        } else {
            return 0;
        }

    }

    public synchronized void kuyrukBilgisi(Queue<Grup> kuyruk) {
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

}
