package com.asansorsistemi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class Avm {
    
    public static final int KAT_SAYISI = 5;
    public static final int ASANSOR_SAYISI = 5;
    
    
    //Zemin Katta sadece kuyruk var.
    static LinkedBlockingQueue<Grup> zeminKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> birinciKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> ikinciKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> ucuncuKatKuyruk = new LinkedBlockingQueue<Grup>();
    static LinkedBlockingQueue<Grup> dorduncuKatKuyruk = new LinkedBlockingQueue<Grup>();
    
    static ArrayList<Grup> birinciKatListe = new ArrayList<Grup>();
    static ArrayList<Grup> ikinciKatListe = new ArrayList<Grup>();
    static ArrayList<Grup> ucuncuKatListe = new ArrayList<Grup>();
    static ArrayList<Grup> dorduncuKatListe = new ArrayList<Grup>();
    
    static int cikisYapanlar = 0;
    
    public Avm(){
        
    }
    
    
    
}
