package com.asansorsistemi;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Kontrol implements Runnable {

    public static final int OLU_ZAMAN = 500 * AsansorSistemi.ZAMAN_CARPANI;

    @Override
    public void run() {
        int aktifAsansorler = 1;
        while (true) {
            //Kontrol hep çalışıyor
            int toplamKuyruk = 0;

            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.zeminKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.birinciKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.ikinciKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.ucuncuKatKuyruk);
            toplamKuyruk += AsansorSistemi.kuyruktakiKisiSayisi(Avm.dorduncuKatKuyruk);

            //Kuyruktaki toplam kişi sayısı artık elimizde
            if (toplamKuyruk > 20) {
                aktifAsansorler++;
            }

            if (toplamKuyruk < 10) {
                aktifAsansorler--;
            }

            if (aktifAsansorler <= 1) {
                aktifAsansorler = 1;
            }

            if (aktifAsansorler >= 5) {
                aktifAsansorler = 5;
            }

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
