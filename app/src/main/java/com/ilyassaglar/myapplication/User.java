package com.ilyassaglar.myapplication;

import java.security.PublicKey;

/**
 * Created by ilyas on 26.11.2017.
 */

public class User {
    public String urunMarka;
 public String urunAdet;
 public String urunAdi;
    public String aFiyati;
    public String aciklama;


 public User(){

 }
 public User(String urunMarka,String urunAdi,String urunAdet,String aFiyati,String aciklama){
     this.urunAdi=urunAdi;
     this.urunMarka=urunMarka;
     this.urunAdet=urunAdet;
     this.aFiyati=aFiyati;
     this.aciklama=aciklama;

 }

}
