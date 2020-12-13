package com.asansorsistemi;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

//Avm sınıfı genel olarak veri yapılarını tutuyor ve threadler bu yapılar
//üzerinde işlemlerini gerçekleştiriyor.
public class Avm {
    
    //Bazı sabitler
    public static final int KAT_SAYISI = 5;
    public static final int ASANSOR_SAYISI = 5;
   
    
    //Zemin Katta sadece kuyruk var.
    //Katlardaki kuyruklar.
    //Thread-safe kuyruklar kullanılıyor.
    static LinkedBlockingQueue<Grup> zeminKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> birinciKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> ikinciKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> ucuncuKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> dorduncuKatKuyruk = new LinkedBlockingQueue<Grup>();
  
    
    //Katlardaki listeler
    //Thread safe listeler kullanılıyor.
    static CopyOnWriteArrayList<Grup> birinciKatListe = new CopyOnWriteArrayList<Grup>();
    static CopyOnWriteArrayList<Grup> ikinciKatListe = new CopyOnWriteArrayList<Grup>();
    static CopyOnWriteArrayList<Grup> ucuncuKatListe = new CopyOnWriteArrayList<Grup>();
    static CopyOnWriteArrayList<Grup> dorduncuKatListe = new CopyOnWriteArrayList<Grup>();
    
    //Cikis yapan insan adeti
    static int cikisYapanlar = 0;
    
    public Avm(){
        
    }
    
    
}
