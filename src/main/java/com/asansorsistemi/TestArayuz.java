package com.asansorsistemi;


import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

//Bu sınıf netbeansin form editörü tarafından oto generate edilmiş bazı kısımlar
//içermektedir.
//Arayuzde bir thread olarak çalışmakta ve belli zaman aralıklarında sistemin çalışmasını
//bize göstermektedir.
public class TestArayuz extends javax.swing.JPanel implements Runnable {


    public TestArayuz() {
        initComponents();

        //testArayuzThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kat0Kuyruk = new javax.swing.JTextField();
        kat1Toplam = new javax.swing.JTextField();
        kat2Toplam = new javax.swing.JTextField();
        kat3Toplam = new javax.swing.JTextField();
        kat4Toplam = new javax.swing.JTextField();
        kat1Kuyruk = new javax.swing.JTextField();
        kat2Kuyruk = new javax.swing.JTextField();
        kat3Kuyruk = new javax.swing.JTextField();
        kat4Kuyruk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        kuyruk4bilgi = new javax.swing.JTextField();
        kuyruk0bilgi = new javax.swing.JTextField();
        kuyruk1bilgi = new javax.swing.JTextField();
        kuyruk2bilgi = new javax.swing.JTextField();
        kuyruk3bilgi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        asansor5Iceridekiler = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cikisYapanlar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        asansor1 = new javax.swing.JTextArea();
        baslat = new javax.swing.JButton();
        asansor1Iceridekiler = new javax.swing.JTextField();
        asansor2Iceridekiler = new javax.swing.JTextField();
        asansor3Iceridekiler = new javax.swing.JTextField();
        asansor4Iceridekiler = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        asansor2 = new javax.swing.JTextArea();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        asansor3 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        asansor4 = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        asansor5 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setMaximumSize(new java.awt.Dimension(1200, 720));
        setMinimumSize(new java.awt.Dimension(1200, 720));
        setPreferredSize(new java.awt.Dimension(1200, 720));
        setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("0.kat");
        add(jLabel1);
        jLabel1.setBounds(10, 40, 50, 16);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("1.kat");
        add(jLabel2);
        jLabel2.setBounds(10, 70, 50, 16);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("2.kat");
        add(jLabel3);
        jLabel3.setBounds(10, 100, 50, 16);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("3.kat");
        add(jLabel4);
        jLabel4.setBounds(10, 130, 50, 16);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("4.kat");
        add(jLabel5);
        jLabel5.setBounds(10, 160, 50, 16);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Toplam");
        add(jLabel6);
        jLabel6.setBounds(70, 20, 80, 16);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Kuyruk");
        add(jLabel7);
        jLabel7.setBounds(160, 20, 70, 16);

        kat0Kuyruk.setText("jTextField1");
        add(kat0Kuyruk);
        kat0Kuyruk.setBounds(160, 40, 73, 24);

        kat1Toplam.setText("jTextField2");
        kat1Toplam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kat1ToplamActionPerformed(evt);
            }
        });
        add(kat1Toplam);
        kat1Toplam.setBounds(70, 70, 73, 24);

        kat2Toplam.setText("jTextField3");
        add(kat2Toplam);
        kat2Toplam.setBounds(70, 100, 73, 24);

        kat3Toplam.setText("jTextField4");
        add(kat3Toplam);
        kat3Toplam.setBounds(70, 130, 73, 24);

        kat4Toplam.setText("jTextField5");
        add(kat4Toplam);
        kat4Toplam.setBounds(70, 160, 73, 24);

        kat1Kuyruk.setText("jTextField6");
        add(kat1Kuyruk);
        kat1Kuyruk.setBounds(160, 70, 73, 24);

        kat2Kuyruk.setText("jTextField7");
        add(kat2Kuyruk);
        kat2Kuyruk.setBounds(160, 100, 73, 24);

        kat3Kuyruk.setText("jTextField8");
        add(kat3Kuyruk);
        kat3Kuyruk.setBounds(160, 130, 73, 24);

        kat4Kuyruk.setText("jTextField9");
        add(kat4Kuyruk);
        kat4Kuyruk.setBounds(160, 160, 73, 24);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("0.kat");
        add(jLabel8);
        jLabel8.setBounds(30, 400, 30, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("1.kat");
        add(jLabel9);
        jLabel9.setBounds(20, 430, 40, 20);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("2.kat");
        add(jLabel10);
        jLabel10.setBounds(20, 460, 40, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("3.kat");
        add(jLabel11);
        jLabel11.setBounds(20, 490, 40, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("4.kat");
        add(jLabel12);
        jLabel12.setBounds(20, 520, 40, 20);

        kuyruk4bilgi.setText("jTextField10");
        add(kuyruk4bilgi);
        kuyruk4bilgi.setBounds(70, 520, 1110, 24);

        kuyruk0bilgi.setText("jTextField10");
        add(kuyruk0bilgi);
        kuyruk0bilgi.setBounds(70, 400, 1110, 24);

        kuyruk1bilgi.setText("jTextField10");
        add(kuyruk1bilgi);
        kuyruk1bilgi.setBounds(70, 430, 1110, 24);

        kuyruk2bilgi.setText("jTextField10");
        add(kuyruk2bilgi);
        kuyruk2bilgi.setBounds(70, 460, 1110, 24);

        kuyruk3bilgi.setText("jTextField10");
        add(kuyruk3bilgi);
        kuyruk3bilgi.setBounds(70, 490, 1110, 24);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Asansor 1");
        add(jLabel13);
        jLabel13.setBounds(250, 20, 170, 16);

        asansor5Iceridekiler.setText("jTextField16");
        asansor5Iceridekiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asansor5IceridekilerActionPerformed(evt);
            }
        });
        add(asansor5Iceridekiler);
        asansor5Iceridekiler.setBounds(70, 360, 1110, 24);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Çıkanlar");
        add(jLabel14);
        jLabel14.setBounds(10, 190, 50, 20);

        cikisYapanlar.setText("jTextField1");
        add(cikisYapanlar);
        cikisYapanlar.setBounds(70, 190, 73, 24);

        asansor1.setColumns(20);
        asansor1.setLineWrap(true);
        asansor1.setRows(5);
        jScrollPane2.setViewportView(asansor1);

        add(jScrollPane2);
        jScrollPane2.setBounds(250, 40, 170, 170);

        baslat.setText("Asansör Sistemini Başlat");
        baslat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baslatActionPerformed(evt);
            }
        });
        add(baslat);
        baslat.setBounds(1000, 560, 180, 110);

        asansor1Iceridekiler.setText("jTextField16");
        add(asansor1Iceridekiler);
        asansor1Iceridekiler.setBounds(70, 240, 1110, 24);

        asansor2Iceridekiler.setText("jTextField16");
        asansor2Iceridekiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asansor2IceridekilerActionPerformed(evt);
            }
        });
        add(asansor2Iceridekiler);
        asansor2Iceridekiler.setBounds(70, 270, 1110, 24);

        asansor3Iceridekiler.setText("jTextField16");
        asansor3Iceridekiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asansor3IceridekilerActionPerformed(evt);
            }
        });
        add(asansor3Iceridekiler);
        asansor3Iceridekiler.setBounds(70, 300, 1110, 24);

        asansor4Iceridekiler.setText("jTextField16");
        asansor4Iceridekiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asansor4IceridekilerActionPerformed(evt);
            }
        });
        add(asansor4Iceridekiler);
        asansor4Iceridekiler.setBounds(70, 330, 1110, 24);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Asansor 5");
        add(jLabel15);
        jLabel15.setBounds(0, 360, 60, 30);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Asansor 1");
        add(jLabel16);
        jLabel16.setBounds(0, 240, 60, 30);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Asansor 2");
        add(jLabel17);
        jLabel17.setBounds(0, 270, 60, 30);

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Asansor 3");
        add(jLabel18);
        jLabel18.setBounds(0, 300, 60, 30);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Asansor 4");
        add(jLabel19);
        jLabel19.setBounds(0, 330, 60, 30);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Asansor 2");
        add(jLabel20);
        jLabel20.setBounds(440, 20, 170, 16);

        asansor2.setColumns(20);
        asansor2.setLineWrap(true);
        asansor2.setRows(5);
        jScrollPane3.setViewportView(asansor2);

        add(jScrollPane3);
        jScrollPane3.setBounds(440, 40, 170, 170);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Asansor 3");
        add(jLabel21);
        jLabel21.setBounds(630, 20, 170, 16);

        asansor3.setColumns(20);
        asansor3.setLineWrap(true);
        asansor3.setRows(5);
        jScrollPane4.setViewportView(asansor3);

        add(jScrollPane4);
        jScrollPane4.setBounds(630, 40, 170, 170);

        asansor4.setColumns(20);
        asansor4.setLineWrap(true);
        asansor4.setRows(5);
        jScrollPane5.setViewportView(asansor4);

        add(jScrollPane5);
        jScrollPane5.setBounds(820, 40, 170, 170);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Asansor 4");
        add(jLabel22);
        jLabel22.setBounds(820, 20, 170, 16);

        asansor5.setColumns(20);
        asansor5.setLineWrap(true);
        asansor5.setRows(5);
        jScrollPane6.setViewportView(asansor5);

        add(jScrollPane6);
        jScrollPane6.setBounds(1010, 40, 170, 170);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Asansor 5");
        add(jLabel23);
        jLabel23.setBounds(1010, 20, 170, 16);

        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 102, 102));
        jTextArea1.setRows(5);
        jTextArea1.setText("Multithread Asansor Sistemi\n*Giriş threadi Her 500 ms'de bir 1-10 kişiyi 0.kat kuyruğuna ekler.\n*Çıkış threadi Her 1000 ms'de bir 1-5 kişiyi rastgele bir kattan o katın çıkış kuyruğuna ekler.\n*Asansörler katlar arasında 200 ms süreyle hareket ederler.\n*Kontrol threadi kuyruklardaki toplam kişi sayısı 10'dan az olunca bir asansörü kapatır. 20'den fazla olunca bir asansörü açar. Birinci asansör sürekli çalışır.\n****Kontrol threadi eğer bir asansörü deaktif hale getirirse asansör içerisindeki yolcuları bıraktıktan sonra deaktif olur.");
        jScrollPane1.setViewportView(jTextArea1);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 563, 960, 110);
    }// </editor-fold>//GEN-END:initComponents

    private void kat1ToplamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kat1ToplamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kat1ToplamActionPerformed

    private void baslatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baslatActionPerformed
        // TODO add your handling code here:
        
        
        AsansorSistemi.avmGirisThread.start();
        AsansorSistemi.avmCikisThread.start();
        AsansorSistemi.asansor1Thread.start();
        AsansorSistemi.asansor2Thread.start();
        AsansorSistemi.asansor3Thread.start();
        AsansorSistemi.asansor4Thread.start();
        AsansorSistemi.asansor5Thread.start();
        AsansorSistemi.kontrolThread.start();
    }//GEN-LAST:event_baslatActionPerformed

    private void asansor5IceridekilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asansor5IceridekilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asansor5IceridekilerActionPerformed

    private void asansor2IceridekilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asansor2IceridekilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asansor2IceridekilerActionPerformed

    private void asansor3IceridekilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asansor3IceridekilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asansor3IceridekilerActionPerformed

    private void asansor4IceridekilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asansor4IceridekilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_asansor4IceridekilerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea asansor1;
    private javax.swing.JTextField asansor1Iceridekiler;
    private javax.swing.JTextArea asansor2;
    private javax.swing.JTextField asansor2Iceridekiler;
    private javax.swing.JTextArea asansor3;
    private javax.swing.JTextField asansor3Iceridekiler;
    private javax.swing.JTextArea asansor4;
    private javax.swing.JTextField asansor4Iceridekiler;
    private javax.swing.JTextArea asansor5;
    private javax.swing.JTextField asansor5Iceridekiler;
    private javax.swing.JButton baslat;
    private javax.swing.JTextField cikisYapanlar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField kat0Kuyruk;
    private javax.swing.JTextField kat1Kuyruk;
    private javax.swing.JTextField kat1Toplam;
    private javax.swing.JTextField kat2Kuyruk;
    private javax.swing.JTextField kat2Toplam;
    private javax.swing.JTextField kat3Kuyruk;
    private javax.swing.JTextField kat3Toplam;
    private javax.swing.JTextField kat4Kuyruk;
    private javax.swing.JTextField kat4Toplam;
    private javax.swing.JTextField kuyruk0bilgi;
    private javax.swing.JTextField kuyruk1bilgi;
    private javax.swing.JTextField kuyruk2bilgi;
    private javax.swing.JTextField kuyruk3bilgi;
    private javax.swing.JTextField kuyruk4bilgi;
    // End of variables declaration//GEN-END:variables

    
    //Thread ana döngüsü
    @Override
    public void run() {
        //Burasi artık arayuzu guncelliyor
        while (true) {
            ekraniGuncelle();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Arayuz Thread Hatasi!");
            }
        }
    }

    
    //Arayüzü güncelleyen fonksiyon
    synchronized void ekraniGuncelle() {
        kat0Kuyruk.setText(Integer.toString(AsansorSistemi.kuyruktakiKisiSayisi(Avm.zeminKatKuyruk)));
        kat1Kuyruk.setText(Integer.toString(AsansorSistemi.kuyruktakiKisiSayisi(Avm.birinciKatKuyruk)));
        kat2Kuyruk.setText(Integer.toString(AsansorSistemi.kuyruktakiKisiSayisi(Avm.ikinciKatKuyruk)));
        kat3Kuyruk.setText(Integer.toString(AsansorSistemi.kuyruktakiKisiSayisi(Avm.ucuncuKatKuyruk)));
        kat4Kuyruk.setText(Integer.toString(AsansorSistemi.kuyruktakiKisiSayisi(Avm.dorduncuKatKuyruk)));
        cikisYapanlar.setText(Integer.toString(Avm.cikisYapanlar));

        kat1Toplam.setText(Integer.toString(AsansorSistemi.ListedekiKisiSayisi(Avm.birinciKatListe)));
        kat2Toplam.setText(Integer.toString(AsansorSistemi.ListedekiKisiSayisi(Avm.ikinciKatListe)));
        kat3Toplam.setText(Integer.toString(AsansorSistemi.ListedekiKisiSayisi(Avm.ucuncuKatListe)));
        kat4Toplam.setText(Integer.toString(AsansorSistemi.ListedekiKisiSayisi(Avm.dorduncuKatListe)));

        asansor1.setText(arayuzAsansorYazdir(AsansorSistemi.asansor1));
        asansor1Iceridekiler.setText(arayuzAsansorIcindekiler(AsansorSistemi.asansor1.iceridekiler));

        asansor2.setText(arayuzAsansorYazdir(AsansorSistemi.asansor2));
        asansor2Iceridekiler.setText(arayuzAsansorIcindekiler(AsansorSistemi.asansor2.iceridekiler));

        asansor3.setText(arayuzAsansorYazdir(AsansorSistemi.asansor3));
        asansor3Iceridekiler.setText(arayuzAsansorIcindekiler(AsansorSistemi.asansor3.iceridekiler));

        asansor4.setText(arayuzAsansorYazdir(AsansorSistemi.asansor4));
        asansor4Iceridekiler.setText(arayuzAsansorIcindekiler(AsansorSistemi.asansor4.iceridekiler));

        asansor5.setText(arayuzAsansorYazdir(AsansorSistemi.asansor5));
        asansor5Iceridekiler.setText(arayuzAsansorIcindekiler(AsansorSistemi.asansor5.iceridekiler));

        kuyruk0bilgi.setText(arayuzkuyrukBilgisi(Avm.zeminKatKuyruk));
        kuyruk1bilgi.setText(arayuzkuyrukBilgisi(Avm.birinciKatKuyruk));
        kuyruk2bilgi.setText(arayuzkuyrukBilgisi(Avm.ikinciKatKuyruk));
        kuyruk3bilgi.setText(arayuzkuyrukBilgisi(Avm.ucuncuKatKuyruk));
        kuyruk4bilgi.setText(arayuzkuyrukBilgisi(Avm.dorduncuKatKuyruk));

    }

    
    //Arayüz çıktı fonksiyonları
    public static synchronized String arayuzAsansorIcindekiler(List<Grup> iceridekiler) {
        int i = 0;
        String cikti = "";
        cikti += "[ ";
        for (Grup g : iceridekiler) {
            if (i != 0) {
                cikti += " , ";
            }
            i++;
            cikti += "[" + g.kisiSayisi + "," + g.hedefKat + "]";
        }
        cikti += " ]\n";

        return cikti;
    }

    public static synchronized String arayuzAsansorYazdir(Asansor asansor) {
        String cikti = "";
        cikti += "Aktiflik : " + asansor.aktif + "\n";
        cikti += "Mod: " + asansor.mod + "\n";
        cikti += "Mevcut Kat: " + asansor.mevcutKat + "\n";
        cikti += "Hedef Kat: " + asansor.hedefKat + "\n";
        cikti += "Yön: " + asansor.yon + "\n";
        cikti += "Kapasite: " + Asansor.MAKSIMUM_KAPASITE + "\n";
        cikti += "Mevcut Kişi Sayısı :" + asansor.mevcutKisiSayisi + "\n";
        //cikti += "İçeridekiler : " + "\n";
        return cikti;
    }

    public static synchronized String arayuzkuyrukBilgisi(LinkedBlockingQueue<Grup> kuyruk) {
        int i = 0;
        String cikti = "[ ";
        for (Grup g : kuyruk) {
            if (i != 0) {
                cikti += " , ";
            }
            i++;
            cikti += "[" + g.kisiSayisi + "," + g.hedefKat + "]";
        }
        cikti += " ]\n";

        return cikti;
    }
}
