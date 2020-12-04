package com.asansorsistemi;

import java.util.ArrayList;


public class Asansor implements Runnable {
    private final static int MAKSIMUM_KAPASITE = 10;
    private final static int KAT_ARASI_GECIS = 200;
    
    int id;
    boolean aktif;
    String mod;
    int mevcutKat;
    int hedefKat;
    String yon;
    int mevcutKisiSayisi;
    ArrayList<Grup> iceridekiler;
    
    public Asansor(int id){
        this.id = id;
        this.aktif = false;
        this.mod = "beklemede";
        this.mevcutKat = 0;
        this.hedefKat = 0;
        this.yon = "yukari";
        this.mevcutKisiSayisi = 0;
        this.iceridekiler = new ArrayList<Grup>(); 
    }
    
    @Override
    public void run() {
       while(true){
       
       }
    }

}
