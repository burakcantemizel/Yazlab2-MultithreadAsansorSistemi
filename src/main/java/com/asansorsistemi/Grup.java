package com.asansorsistemi;

//İnsanları Thread çalışma anında ortak grup halinde bir veri yapısında tutuyoruz.
//Rastgele oluşan gruplar ortak katlara gitmek istediği için.
//Bazı durumlarda grup threadler tarafından 2 gruba ayrılabilir
//Örneğin inmek için 8 kişi beklerken asansörde 4 kişilik yer var ise vs.
//Bu gibi işlemler harici olarak thread içerisinde gerçekleştiriliyor.
//Bu sınıf sadece bir veri yapısı
public class Grup {
    int kisiSayisi = 0;
    int hedefKat = 0;
    
    public Grup(int kisiSayisi, int hedefKat){
        this.kisiSayisi = kisiSayisi;
        this.hedefKat = hedefKat;
    }
}


