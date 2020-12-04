package com.asansorsistemi;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JFrame;

public class AsansorSistemi {

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

        ciktiYazdirici = new CiktiYazdirici(300);
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
        
        avmGirisThread.start();
        asansor1Thread.start();
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
    
    public static synchronized int ListedekiKisiSayisi(ArrayList<Grup> liste) {
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
