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

    static AvmGiris avmGiris;
    static Thread avmGirisThread;
    
    static AvmCikis avmCikis;
    static Thread avmCikisThread;

    static Asansor asansor1;
    static Thread asansor1Thread;
    
    static Asansor asansor2, asansor3, asansor4, asansor5;
    static Thread asansor2Thread, asansor3Thread, asansor4Thread, asansor5Thread;
    
    static Kontrol kontrol;
    static Thread kontrolThread;
    
    static TestArayuz testArayuz;
    static Thread testArayuzThread;

    public AsansorSistemi() {
        avm = new Avm();

        avmGiris = new AvmGiris();
        avmGirisThread = new Thread(avmGiris);
        
        avmCikis = new AvmCikis();
        avmCikisThread = new Thread(avmCikis);

        asansor1 = new Asansor(1);
        asansor1Thread = new Thread(asansor1);
        
        asansor2 = new Asansor(2);
        asansor2Thread = new Thread(asansor2);
        
        asansor3 = new Asansor(3);
        asansor3Thread = new Thread(asansor3);
        
        asansor4 = new Asansor(4);
        asansor4Thread = new Thread(asansor4);
        
        asansor5 = new Asansor(5);
        asansor5Thread = new Thread(asansor5);
        
        kontrol = new Kontrol();
        kontrolThread = new Thread(kontrol);
        
        
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
        avmCikisThread.setPriority(2);
        kontrolThread.setPriority(3);
        asansor1Thread.setPriority(4);
        asansor2Thread.setPriority(5);
        asansor3Thread.setPriority(6);
        asansor4Thread.setPriority(7);
        asansor5Thread.setPriority(8);
        
        testArayuzThread.setPriority(10);
        

        testArayuzThread.start();
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
    
     

}
