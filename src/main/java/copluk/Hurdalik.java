/*
boolean calis = true;
        while (true && calis == true) {

            while (this.aktif == true) {
                //Başlangıçta içindekilere göre bir hedef belirleyecek

                asansoreYolcuAl();
                this.hedefKat = asansorHedefBelirle(); // Artık hedef kata gideceğiz ve yolcu indireceğiz

                if (this.yon == "yukari") {
                    for (int i = this.mevcutKat; i < this.hedefKat; i++) {
                        this.mevcutKat++;
                        //Yolcu Indirme
                        try{
                            asansordenYolcuIndir();
                        }catch(Exception e){
                            System.out.println("yolcu inemedi");
                        }
                        
                        asansoreYolcuAl();
                        this.hedefKat = asansorHedefBelirle(); // Artık hedef kata gideceğiz ve yolcu indireceğiz
                        try {
                            Thread.sleep(KAT_ARASI_GECIS * AsansorSistemi.ZAMAN_CARPANI);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                    //Artık Hedef Kattayiz
                } else if (this.yon == "asagi") {
                    for (int i = this.mevcutKat; i > this.hedefKat; i--) {
                        this.mevcutKat--;
                        //YolcuIndirme
                        try{
                            asansordenYolcuIndir();
                        }catch(Exception e){
                            System.out.println("yolcu inemedi");
                        }
                        asansoreYolcuAl();
                        this.hedefKat = asansorHedefBelirle(); // Artık hedef kata gideceğiz ve yolcu indireceğiz
                        try {
                            Thread.sleep(KAT_ARASI_GECIS * AsansorSistemi.ZAMAN_CARPANI);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Asansor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    //Artık Hedef Kattayiz
                }

            }

        }


    public synchronized void asansordenYolcuIndir(List<Grup> liste, Asansor asansor) {
        //Her katta tetiklensin asansörün içinde o katta inecek birisi var ise onu indirsin
        if (asansor.iceridekiler.size() > 0) {
            Iterator<Grup> it = asansor.iceridekiler.iterator();
            while(it.hasNext()){
                Grup g = it.next();
                if (g.hedefKat == asansor.mevcutKat) {
                    if (g.hedefKat == 0) {
                        Avm.cikisYapanlar += g.kisiSayisi;
                        asansor.mevcutKisiSayisi -= g.kisiSayisi;
                        asansor.iceridekiler.remove(g);

                    } else {
                        if (liste != null) {
                            liste.add(g);
                        }
                        asansor.mevcutKisiSayisi -= g.kisiSayisi;
                        asansor.iceridekiler.remove(g);

                    }

                }
                
            }
        }


    public synchronized void asansordenYolcuIndir() {
        if (this.mevcutKat == 0) {
            asansordenYolcuIndir(null, this);
        } else if (this.mevcutKat == 1) {
            asansordenYolcuIndir(Avm.birinciKatListe, this);
        } else if (this.mevcutKat == 2) {
            asansordenYolcuIndir(Avm.ikinciKatListe, this);
        } else if (this.mevcutKat == 3) {
            asansordenYolcuIndir(Avm.ucuncuKatListe, this);
        } else if (this.mevcutKat == 4) {
            asansordenYolcuIndir(Avm.dorduncuKatListe, this);
        }
    }

        if (this.mevcutKat == 0) {
            asansordenYolcuIndir(null, this);
        } else if (this.mevcutKat == 1) {
            asansordenYolcuIndir(Avm.birinciKatListe, this);
        } else if (this.mevcutKat == 2) {
            asansordenYolcuIndir(Avm.ikinciKatListe, this);
        } else if (this.mevcutKat == 3) {
            asansordenYolcuIndir(Avm.ucuncuKatListe, this);
        } else if (this.mevcutKat == 4) {
            asansordenYolcuIndir(Avm.dorduncuKatListe, this);
        }


    public synchronized int yukariHedefBelirle() {
        int enKucuk = this.iceridekiler.get(0).hedefKat;
        for (Grup g : this.iceridekiler) {
            if (enKucuk >= g.hedefKat) {
                enKucuk = g.hedefKat;
            }
        }

        if (mevcutKat < enKucuk) { //Yukari dogru enKucuk Kata gidicem
            System.out.println("Yukari dogru hedef belirlendi");
            this.yon = "yukari";
            return enKucuk;
        }

        return this.mevcutKat;
    }

    public synchronized int asagiHedefBelirle() {
        System.out.println("Asagi dogru kontrol oldu");
        int enBuyuk = this.iceridekiler.get(0).hedefKat;
        for (Grup g : this.iceridekiler) {
            if (enBuyuk <= g.hedefKat) {
                enBuyuk = g.hedefKat;
            }
        }

        if (mevcutKat >= enBuyuk) {
            System.out.println("asagi dogru hedef belirlendi");
            this.yon = "asagi";
            return enBuyuk;
        }

        return this.mevcutKat;
    }
    }

/*
    HURDALIK
    
           if (this.yon == "yukari" && this.iceridekiler.size() > 1) {
            //iceridekilerden en kucuk olan bir sonraki hedefim
            int enKucuk = this.iceridekiler.get(0).hedefKat;
            for (Grup g : this.iceridekiler) {
                if (enKucuk >= g.hedefKat) {
                    enKucuk = g.hedefKat;
                }
            }
            //Burdan sonra enKucukIcerdeki bulundu.
            if(mevcutKat <= enKucuk){ //Yukari dogru enKucuk Kata gidicem
                System.out.println("Yukari dogru hedef belirlendi");
                this.yon = "yukari";
                return enKucuk;
                
            }else{
                this.yon = "asagi";
                asansorHedefBelirle();
            }
        } else if (this.yon == "asagi" && this.iceridekiler.size() > 1) {
            //iceridekilerden en buyuk olan bir sonraki hedefim
            int enBuyuk = this.iceridekiler.get(0).hedefKat;
            for (Grup g : this.iceridekiler) {
                if (enBuyuk <= g.hedefKat) {
                    enBuyuk = g.hedefKat;
                }
            }
            //Burdan sonra enBuyuk Kat bulundu
            if(mevcutKat >= enBuyuk){
                 System.out.println("asagi dogru hedef belirlendi");
                 this.yon = "asagi";
                return enBuyuk;
            }else{
                this.yon = "yukari";
                asansorHedefBelirle();
            }
        }
        
        return this.mevcutKat;
       
        /*
        int hedef = yukariHedefBelirle();
        
        if(hedef == this.mevcutKat) asagiHedefBelirle();
        
        return hedef;
        */
        /*
        int hedef = -1;
        
        if(this.iceridekiler != null && this.iceridekiler.size() > 0){
             hedef = this.iceridekiler.get(0).hedefKat;
        }   
        return hedef;


     */

/*




*/

















