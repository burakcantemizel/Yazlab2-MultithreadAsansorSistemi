package com.asansorsistemi;


import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;



//Avm Giris Threadi zemin kat kuyruguna rastgele insanlar ekliyor.
public class AvmGiris implements Runnable {
    Random random;
    
    public static final int ZAMAN_ARALIGI = 500;  
    
    public AvmGiris(){
        random = new Random();
    }
    
    //Threadin Ana Fonksiyonu
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
    
    // 1 ile 10 arasında rastgele kişiyi zemin kat kuyruğuna ekliyor.
    public synchronized void yeniInsanEkle(LinkedBlockingQueue<Grup> kuyruk){
        int yeniKisiSayisi = 1 + random.nextInt(10); // 1 ile 10 arası
        int hedefKat =  1 + random.nextInt(Avm.KAT_SAYISI-1); // 1 ile 4 arası
        
        //Yeni bir grup oluşturduk
        Grup yeniGrup = new Grup(yeniKisiSayisi, hedefKat);
        
        //Kuyruğa ekledik.
        kuyruk.add(yeniGrup);
    }

}
