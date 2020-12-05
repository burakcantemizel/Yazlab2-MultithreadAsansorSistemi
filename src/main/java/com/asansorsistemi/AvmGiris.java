package com.asansorsistemi;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AvmGiris implements Runnable {
    Random random;
    
    private static final int ZAMAN_ARALIGI = 500;  
    
    public AvmGiris(){
        random = new Random();
    }
    
    @Override
    synchronized public void run() {
        //Threadin giriş noktası
        while(true){
            try {
                yeniInsanEkle(Avm.zeminKatKuyruk);
                
                
                
                Thread.sleep(ZAMAN_ARALIGI * AsansorSistemi.ZAMAN_CARPANI);
            } catch (InterruptedException ex) {
                System.out.println("AvmGiris Thread Hatası!");
            }
        }
    }
    
    
    public synchronized void yeniInsanEkle(LinkedBlockingQueue<Grup> kuyruk){
        int yeniKisiSayisi = 1 + random.nextInt(10); // 1 ile 10 arası
        int hedefKat =  1 + random.nextInt(Avm.KAT_SAYISI-1); // 1 ile 4 arası
        
        Grup yeniGrup = new Grup(yeniKisiSayisi, hedefKat);
        
        kuyruk.add(yeniGrup);
    }

}
