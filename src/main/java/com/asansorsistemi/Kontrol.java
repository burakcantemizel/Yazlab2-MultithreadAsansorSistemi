package com.asansorsistemi;

import java.util.logging.Level;
import java.util.logging.Logger;

//Asansörleri aktif deaktif hale getiren thread
//Kuyruktaki toplam kişi sayısı 20 den fazla olunca bir asansörü açıyor
//Kuyruktaki toplam kişi sayısı 10 dan az olunca bir asansörü kapatıyor
//Kişi sayısını sürekli kontrol ettiği için referans olarak giriş threadinin
//bir çalışma zamanını baz alıyor yani bir asansör açtıktan sonra tekrar doluluk
//durumuna bakmak için yeni bir müşteri gelmesini değerlendiriyor.
public class Kontrol implements Runnable {

    public static final int OLU_ZAMAN = AvmGiris.ZAMAN_ARALIGI * AsansorSistemi.ZAMAN_CARPANI;

    
    //Kontrol threadi ana döngüsü
    @Override
    public void run() {
        //Sürekli çalışarak asansörlerin aktifliğini ayarlıyor.
        
        //Aktif asansör sayısı 1'den başlıyor.
        int aktifAsansorler = 1;
        
        
        while (true) {
            //Kontrol hep çalışıyor
            int toplamKuyruk = 0;

            //Toplam kuyruk sayısını hesaplıyoruz.
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.zeminKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.birinciKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.ikinciKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.ucuncuKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.dorduncuKatKuyruk);

            //Kuyruktaki toplam kişi sayısı artık elimizde
            
            //20den fazla ise bir asansörü açıyoruz
            if (toplamKuyruk > 20) {
                aktifAsansorler++;
            }

            //10'dan az ise bir asansörü kapatıyoruz.
            if (toplamKuyruk < 10) {
                aktifAsansorler--;
            }

            //Aktif asansör en az 1 olmalı
            if (aktifAsansorler <= 1) {
                aktifAsansorler = 1;
            }

            //Aktif asansör en çok 5 olmalı
            if (aktifAsansorler >= 5) {
                aktifAsansorler = 5;
            }

            
            //Aktif asansör numarasına göre asansörlerin aktiflik durumlarını ayarlıyoruz.
            if (aktifAsansorler == 1) {
                AsansorSistemi.asansor2.aktif = false;
                AsansorSistemi.asansor3.aktif = false;
                AsansorSistemi.asansor4.aktif = false;
                AsansorSistemi.asansor5.aktif = false;

                try {
                    Thread.sleep(OLU_ZAMAN);
                } catch (InterruptedException ex) {
                    System.out.println("Aktif asansor 1 thread hatasi!");
                }
            } else if (aktifAsansorler == 2) {
                AsansorSistemi.asansor2.aktif = true;
                AsansorSistemi.asansor3.aktif = false;
                AsansorSistemi.asansor4.aktif = false;
                AsansorSistemi.asansor5.aktif = false;

                try {
                    Thread.sleep(OLU_ZAMAN);
                } catch (InterruptedException ex) {
                     System.out.println("Aktif asansor 2 thread hatasi!");
                }

            } else if (aktifAsansorler == 3) {
                AsansorSistemi.asansor2.aktif = true;
                AsansorSistemi.asansor3.aktif = true;
                AsansorSistemi.asansor4.aktif = false;
                AsansorSistemi.asansor5.aktif = false;

                try {
                    Thread.sleep(OLU_ZAMAN);
                } catch (InterruptedException ex) {
                     System.out.println("Aktif asansor 3 thread hatasi!");
                }
            } else if (aktifAsansorler == 4) {
                AsansorSistemi.asansor2.aktif = true;
                AsansorSistemi.asansor3.aktif = true;
                AsansorSistemi.asansor4.aktif = true;
                AsansorSistemi.asansor5.aktif = false;

                try {
                    Thread.sleep(OLU_ZAMAN);
                } catch (InterruptedException ex) {
                     System.out.println("Aktif asansor 4 thread hatasi!");
                }

            } else if (aktifAsansorler == 5) {
                AsansorSistemi.asansor2.aktif = true;
                AsansorSistemi.asansor3.aktif = true;
                AsansorSistemi.asansor4.aktif = true;
                AsansorSistemi.asansor5.aktif = true;

                try {
                    Thread.sleep(OLU_ZAMAN);
                } catch (InterruptedException ex) {
                     System.out.println("Aktif asansor 5 thread hatasi!");
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.out.println("Kontrol thread hatasi!");
            }

        }
    }

}
