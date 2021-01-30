
package javaapplication110;

import java.awt.BorderLayout;
import java.util.Scanner;

class insan{
     int tc_no;
    String isimsoyisim;
    boolean bagisci;
    boolean kanalici;
    String kangrubu;
    String RH;
    boolean hiv;
    boolean hepatitB;
    boolean oncelikdurumu;        
    insan ileri;
    insan(String isimsoyisim,boolean bagisci, boolean kanalici, String kangrubu, String RH, boolean hiv, boolean hepatitB, boolean oncelikdurumu,int tc_no) {
        this.isimsoyisim=isimsoyisim;
        this.tc_no=tc_no;
        this.kanalici = kanalici;
        this.kangrubu = kangrubu;
        this.RH = RH;
        this.hiv = hiv;
        this.hepatitB = hepatitB;
        this.oncelikdurumu = oncelikdurumu;
        ileri=null;
        if(bagisci){
        this.bagisci = !(this.hiv || this.hepatitB); 
        }
       
    }
}
class giris{
    kangrubu eksi;
    kangrubu arti;
    giris(){
    eksi=new kangrubu();
    arti=new kangrubu();
    }
    public  void girisYap(insan i){
        if(i.RH.equals("+")){
            if(i.kangrubu.equals("A")){
                if(i.bagisci){
                    verici yeni=new verici(i);
                    arti.A.VericiEkle(yeni);
                }
                if(i.kanalici){
                          alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    arti.A.AliciOncelikliEkle(yeni);
                }
                else{
                    arti.A.AliciEkle(yeni);
                } 
                }
                
            }
            else       if(i.kangrubu.equals("B")){
                if(i.bagisci){
                    verici yeni=new verici(i);
                    arti.B.VericiEkle(yeni);
                }
                if(i.kanalici){
                            alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    arti.B.AliciOncelikliEkle(yeni);
                }
                else{
                    arti.B.AliciEkle(yeni);
                }   
                }
            
            }
             else  if(i.kangrubu.equals("AB")){
                if(i.bagisci){
                    verici yeni=new verici(i);
                    arti.AB.VericiEkle(yeni);
                }
                if(i.kanalici){
                             alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    arti.AB.AliciOncelikliEkle(yeni);
                }
                else{
                    arti.AB.AliciEkle(yeni);
                } 
                }
             
            }
             else{
                    if(i.bagisci){
                    verici yeni=new verici(i);
                    arti.O.VericiEkle(yeni);
                }
                    if(i.kanalici){
                               alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    arti.O.AliciOncelikliEkle(yeni);
                }
                else{
                    arti.O.AliciEkle(yeni);
                }
                    }
             
             }
        }
        else{
             if(i.kangrubu.equals("A")){
                if(i.bagisci){
                    verici yeni=new verici(i);
                    eksi.A.VericiEkle(yeni);
                }
                if(i.kanalici){
                            alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    eksi.A.AliciOncelikliEkle(yeni);
                }
                else{
                    eksi.A.AliciEkle(yeni);
                }  
                }
             
            }
            else       if(i.kangrubu.equals("B")){
                if(i.bagisci){
                    verici yeni=new verici(i);
                    eksi.B.VericiEkle(yeni);
                }
                if(i.kanalici){
                           alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    eksi.B.AliciOncelikliEkle(yeni);
                }
                else{
                    eksi.B.AliciEkle(yeni);
                } 
                }
               
            }
             else  if(i.kangrubu.equals("AB")){
                if(i.bagisci){
                    verici yeni=new verici(i);
                    eksi.AB.VericiEkle(yeni);
                }
                if(i.kanalici){
                            alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    eksi.AB.AliciOncelikliEkle(yeni);
                }
                else{
                    eksi.AB.AliciEkle(yeni);
                }  
                }
             
            }
             else{
                    if(i.bagisci){
                    verici yeni=new verici(i);
                    eksi.O.VericiEkle(yeni);
                }
                    if(i.kanalici){
                                 alici yeni=new alici(i);
                if(i.oncelikdurumu){
                    eksi.O.AliciOncelikliEkle(yeni);
                }
                else{
                    eksi.O.AliciEkle(yeni);
                }
                    }
           
             }
            
            
        }
    }
   public void HaritayıListele(){
       arti.A.Vericilistele();
       arti.A.Alicilistele();
       eksi.A.Vericilistele();
       eksi.A.Alicilistele();
       arti.AB.Vericilistele();
       arti.AB.Alicilistele();
       eksi.AB.Vericilistele();
       eksi.AB.Alicilistele();
       arti.B.Vericilistele();
       arti.B.Alicilistele();
       eksi.B.Vericilistele();
       eksi.B.Alicilistele();
       arti.O.Vericilistele();
       arti.O.Alicilistele();
       eksi.O.Vericilistele();
       eksi.O.Alicilistele();
   
   }
   public void AliciHaritasiListele(){
       arti.A.AliciİliskiListele();
       arti.B.AliciİliskiListele();
       arti.AB.AliciİliskiListele();
       arti.O.AliciİliskiListele();
       eksi.A.AliciİliskiListele();
       eksi.B.AliciİliskiListele();
       eksi.AB.AliciİliskiListele();
       eksi.O.AliciİliskiListele();
   }
}
class kangrubu{
   kan A;
   kan B;
   kan AB;
   kan O;

     kangrubu() {
         A=new kan();
         B=new kan();
         AB=new kan();
         O=new kan();
    }   
}
class kan{
  verici vericiBas;
  verici vericiSon;
  alici aliciBas;
  alici aliciSon;
 kan() {
        this.vericiBas =null;
        this.vericiSon = null;
        this.aliciBas = null;
        this.aliciSon = null;
    }
 public void VericiEkle(verici yeni){
     if(yeni.i.bagisci==true){
         if(vericiBas==null){
         vericiBas=yeni;
         vericiSon=yeni;
         }
     else{
        vericiSon.ileri=yeni;
        vericiSon=yeni;   
     }
     }
  
}
  public void AliciEkle(alici yeni){
     if(aliciBas==null){
         aliciBas=yeni;
         aliciSon=yeni;
     }
     else{
         aliciSon.ileri=yeni;
        aliciSon=yeni;   
     }
}
  public void AliciOncelikliEkle(alici yeni){
      if(aliciBas==null){
          aliciBas=yeni;
          aliciSon=yeni;
      }
      else{
          yeni.ileri=aliciBas;
          aliciBas=yeni;
      }
  }
     public void Alicilistele(){
         if(aliciBas!=null){
                  alici tmp=aliciBas;
         System.out.println(tmp.i.kangrubu+tmp.i.RH+" Kan grubu alıcılar listesi");
         while(tmp!=null){
                System.out.println(tmp.i.isimsoyisim+" TC no : "+tmp.i.tc_no); 
             tmp=tmp.ileri;
         }  
         }
     
    }
          public void Vericilistele(){
              if(vericiBas!=null){
                        verici tmp=vericiBas;
            System.out.println(tmp.i.kangrubu+tmp.i.RH+"Kan grubu vericiler listesi");
         while(tmp!=null){
       System.out.println(tmp.i.isimsoyisim+" - TC no : "+tmp.i.tc_no);
             tmp=tmp.ileri;
         }  
              }
   
    }
  public void AliciİliskiListele(){
      verici ver=vericiBas;
      alici tmp=aliciBas;
      System.out.println("Alıcı ilişki listesi");
      while(ver!=null){
             while(tmp!=null){
          if(tmp.i.tc_no!=ver.i.tc_no){
              System.out.println(ver.i.isimsoyisim+" verebilir -> "+tmp.i.isimsoyisim);
          }
          tmp=tmp.ileri;
      }
        ver=ver.ileri;
        tmp=aliciBas;
      }
  }
}
class verici{
    verici ileri;
    insan i;
    verici(insan i){
        ileri=null;
        this.i=i;
    }
}
class alici{
      alici ileri;
    insan i;
    alici(insan i){
        ileri=null;
        this.i=i;
    }
 
}
public class JavaApplication110 {
public static boolean VerebilirMi(insan i,insan i2){
    if(i.hiv || i2.hiv || i.hepatitB || i2.hepatitB){
        return false;
    }
    else if(!i.RH.equals(i2.RH) || !i.kangrubu.equals(i2.kangrubu)){
        return false;
    }
    else{
        return true;
    }
}
    public static void main(String[] args) {
             int tc_no;
    String isimsoyisim=null;
    int durum=0;
    boolean bagisci=false;
    boolean kanalici=false;
    String kangrubu="";
    String RH="";
    boolean hiv=false;
    boolean hepatitB=false;
    boolean oncelikdurumu=false;  
 giris g=new giris();
 insan i;
 insan i2;
 System.out.println("Hoşgeldiniz");
 Scanner k=new Scanner(System.in);
 int input;
 while(true){
     System.out.println("---------------------------");
 System.out.println("İnsan Eklemek için 1'e basınız");
 System.out.println("2 İnsan Eklemek için 2'e basınız");
 System.out.println("Bağışçıların verebildiği alıcıları görmek için 3'e basınız");
 System.out.println("Bütün alıcı ve vericileri listelemek için 4'e basınız");
 System.out.println("Çıkış yapmak için diğer rakamlara basınız");
 System.out.println("------------------------------");
  input=k.nextInt();
  if(input==1){
       System.out.println("Tc no giriniz : ");
      tc_no=k.nextInt();
      System.out.println("isim giriniz : ");
      isimsoyisim=k.next();
      System.out.println("Bağışçı iseniz 1 değilseniz 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         bagisci=true;
     }
     else{
         bagisci=false;
     }
       System.out.println("Kan alıcı iseniz 1 değilseniz 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         kanalici=true;
     }
     else{
         kanalici=false;
     }
      System.out.println("Kan gurubunuzu giriniz : (A,AB,B,O metin olarak)");
      kangrubu=k.next();
      System.out.println("RH giriniz : ( - veya + )");
      RH=k.next();
    System.out.println("Hiv durumu var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         hiv=true;
     }
     else{
         hiv=false;
     }
        System.out.println("HepatitB durumu var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         hepatitB=true;
     }
     else{
         hepatitB=false;
     }
             System.out.println("Öncelik durumunuz var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         oncelikdurumu=true;
     }
     else{
         oncelikdurumu=false;
     }
     i=new insan(isimsoyisim,bagisci,kanalici,kangrubu,RH,hiv,hepatitB,oncelikdurumu,tc_no);
     g.girisYap(i);
  }
  else if(input==2){
        System.out.println("1. Tc no giriniz : ");
      tc_no=k.nextInt();
      System.out.println("1. isim giriniz : ");
      isimsoyisim=k.next();
      System.out.println("1. Bağışçı iseniz 1 değilseniz 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         bagisci=true;
     }
     else{
         bagisci=false;
     }
       System.out.println("1. Kan alıcı iseniz 1 değilseniz 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         kanalici=true;
     }
     else{
         kanalici=false;
     }
      System.out.println("1. Kan gurubunuzu giriniz : (A,AB,B,O metin olarak)");
      kangrubu=k.next();
      System.out.println("1. RH giriniz : ( - veya + )");
      RH=k.next();
    System.out.println("1. Hiv durumu var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         hiv=true;
     }
     else{
         hiv=false;
     }
        System.out.println("1. HepatitB durumu var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         hepatitB=true;
     }
     else{
         hepatitB=false;
     }
             System.out.println("1. Öncelik durumunuz var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         oncelikdurumu=true;
     }
     else{
         oncelikdurumu=false;
     }
     i=new insan(isimsoyisim,bagisci,kanalici,kangrubu,RH,hiv,hepatitB,oncelikdurumu,tc_no);
       System.out.println("2. Tc no giriniz : ");
      tc_no=k.nextInt();
      System.out.println("2. isim giriniz : ");
      isimsoyisim=k.next();
      System.out.println("2. Bağışçı iseniz 1 değilseniz 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         bagisci=true;
     }
     else{
         bagisci=false;
     }
       System.out.println("2. Kan alıcı iseniz 1 değilseniz 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         kanalici=true;
     }
     else{
         kanalici=false;
     }
      System.out.println("2. Kan gurubunuzu giriniz : (A,AB,B,O metin olarak)");
      kangrubu=k.next();
      System.out.println("2. RH giriniz : ( - veya + )");
      RH=k.next();
      System.out.println("2. Hiv durumu var ise 1 yok ise 0 giriniz");
      durum=k.nextInt();
     if(durum==1){
         hiv=true;
     }
     else{
         hiv=false;
     }
         System.out.println("2. HepatitB durumu var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         hepatitB=true;
     }
     else{
         hepatitB=false;
     }
     System.out.println("2. Öncelik durumunuz var ise 1 yok ise 0 giriniz");
     durum=k.nextInt();
     if(durum==1){
         oncelikdurumu=true;
     }
     else{
         oncelikdurumu=false;
     }
     i2=new insan(isimsoyisim,bagisci,kanalici,kangrubu,RH,hiv,hepatitB,oncelikdurumu,tc_no);
      System.out.println("Kişiler arası kan verme durumu "+VerebilirMi(i, i2));   
  }
  else if(input==3){
      g.AliciHaritasiListele();
  }
  else if(input==4){
      g.HaritayıListele();
  }
  else {
      System.out.println("Çıkıs Yapılıyor ....");
      break;
  }
        }
    }   
}
