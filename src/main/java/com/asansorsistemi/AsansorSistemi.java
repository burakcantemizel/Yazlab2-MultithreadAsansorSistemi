package com.asansorsistemi;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JFrame;

public class AsansorSistemi {
    static int ZAMAN_CARPANI = 4;
    
    
    static Avm avm;

    static CiktiYazdirici ciktiYazdirici;
    static Thread ciktiYazdiriciThread;

    static AvmGiris avmGiris;
    static Thread avmGirisThread;

    static Asansor asansor1;
    static Thread asansor1Thread;
    
    static TestArayuz testArayuz;
    static Thread testArayuzThread;

    public AsansorSistemi() {
        avm = new Avm();

        avmGiris = new AvmGiris();
        avmGirisThread = new Thread(avmGiris);

        asansor1 = new Asansor(1);
        asansor1Thread = new Thread(asansor1);

        ciktiYazdirici = new CiktiYazdirici(300 * AsansorSistemi.ZAMAN_CARPANI);
        ciktiYazdiriciThread = new Thread(ciktiYazdirici);
        
        
        testArayuz = new TestArayuz();
        testArayuzThread = new Thread(testArayuz);
        
        JFrame pencere = new JFrame();
        pencere.setVisible(true);
        pencere.add(testArayuz);
        pencere.setSize(1280, 900);  
        pencere.setLocationRelativeTo(null);  
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        

        //EntryPoint ==>>>
        avmGirisThread.setPriority(1);
        asansor1Thread.setPriority(2);
        ciktiYazdiriciThread.setPriority(10);
        

        testArayuzThread.start();
        
        //ciktiYazdiriciThread.start();
        
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                System.exit(0);
            }
        };
        //timer.schedule(task, 3000, 3000);
        
    }

    public static void main(String[] args) {
        AsansorSistemi asansorSistemi = new AsansorSistemi();
    }

    public static synchronized int kuyruktakiKisiSayisi(LinkedBlockingQueue<Grup> kuyruk) {
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
    
    public static synchronized int ListedekiKisiSayisi(List<Grup> liste) {
        if (liste.size() > 0) {
            int toplamKisi = 0;
            for (Grup g : liste) {
                toplamKisi += g.kisiSayisi;
            }
            return toplamKisi;
        } else {
            return 0;
        }

    }
    
     public static synchronized String arayuzAsansorIcindekiler(List<Grup> iceridekiler) {
        int i = 0;
        String cikti = "";
        cikti += "[ ";
        for (Grup g : iceridekiler) {
            if (i != 0) {
                cikti += " , ";
            }
            i++;
            cikti += "[" + g.kisiSayisi + "," + g.hedefKat + "]";
        }
        cikti += " ]\n";
        
        return cikti;
    }

    public static synchronized String arayuzAsansorYazdir(Asansor asansor) {
        String cikti = "";
        cikti += "Aktiflik : " + asansor.aktif + "\n";
        cikti += "\tMod: " + asansor.mod + "\n";
        cikti += "\tMevcut Kat: " + asansor.mevcutKat + "\n";
        cikti += "\tHedef Kat: " + asansor.hedefKat + "\n";
        cikti += "\tYön: " + asansor.yon + "\n";
        cikti += "\tKapasite: " + Asansor.MAKSIMUM_KAPASITE + "\n";
        cikti += "\tMevcut Kişi Sayısı :" + asansor.mevcutKisiSayisi + "\n";
        cikti += "\tİçeridekiler : " + "\n";
        //cikti += arayuzAsansorIcindekiler(asansor.iceridekiler);
        return cikti;
    }
    
    public static synchronized String arayuzkuyrukBilgisi(LinkedBlockingQueue<Grup> kuyruk) {
        int i = 0;
        String cikti = "[ ";
        for (Grup g : kuyruk) {
            if (i != 0) {
                cikti += " , ";
            }
            i++;
            cikti +=  "[" + g.kisiSayisi + "," + g.hedefKat + "]";
        }
        cikti += " ]\n";
        
        return cikti;
    }

}
