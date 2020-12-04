package com.asansorsistemi;

public class AsansorSistemi {
    Avm avm;
    
    static CiktiYazdirici ciktiYazdirici;
    static Thread ciktiYazdiriciThread;

    static AvmGiris avmGiris;
    static Thread avmGirisThread;

    Asansor asansor1;
    Thread asansor1Thread;

    

    public AsansorSistemi() {
        avm = new Avm();

        ciktiYazdirici = new CiktiYazdirici(600);
        ciktiYazdiriciThread = new Thread(ciktiYazdirici);

        avmGiris = new AvmGiris();
        avmGirisThread = new Thread(avmGiris);

        asansor1 = new Asansor(1);
        asansor1Thread = new Thread(asansor1);

        //EntryPoint ==>>>
        avmGirisThread.start();
        ciktiYazdiriciThread.start();
    }

    public static void main(String[] args) {
        AsansorSistemi asansorSistemi = new AsansorSistemi();
    }

}
