/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liste2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

class ders{
String derskodu;
int sinifi;
ders ileri;
ders(String derskodu,int sinifi){
this.derskodu=derskodu;
this.sinifi=sinifi;
ileri=null;
}}
class ogrenci{
String adı;
String soyadı;
int no;
int sinifi;
ogrenci ileri;
ders bas,son;
ogrenci(String adı,String soyadı,int no,int sinifi){
this.adı=adı;
this.soyadı=soyadı;
this.no=no;
this.sinifi=sinifi;
 ileri=null;
 bas=null;
 son=null;
}
public void dersekle(ders yeni){
    if (bas==null) {
        bas=yeni;
        son=yeni;
        }
    else{
        son.ileri=yeni;
        son=yeni;
    }
}
public void derssil(ders silinecekders){
    if (silinecekders.derskodu.equals(bas.derskodu)) {
        bas=bas.ileri;
    }
    else if (silinecekders.equals(son.derskodu)) {
        ders tmp=bas;
        while(tmp.ileri!=son){
          tmp=tmp.ileri;
          
        
        }
        tmp.ileri=null;
        son=tmp;
        
    }
    else{
        ders tmp=bas;
        while(tmp.ileri!=silinecekders){
          tmp=tmp.ileri;
          
        
        }
        tmp.ileri=silinecekders.ileri;
    
        
    }
    
    
    
    }
    public void dersgoster(){
ders tmp=bas;
while(tmp!=null){
    System.out.println(tmp.derskodu+" "+tmp.sinifi+" ");

    tmp=tmp.ileri;

}



}

    
}




public class Liste2 {
ogrenci bas=null;
ogrenci son=null;
public void ogrenciekle(ogrenci yeni){
    if (bas==null) {
        bas=yeni;
        son=yeni;
        
    }
    else{
    son.ileri=yeni;
    son=yeni;
    
    }


}
 public void ogrokuekle(File f) {
    try {
        ogrenci tmp;
        String s="";String okunan;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
         int numara1;
        String adı1;
        String soyadı1;
        int sinifi;
        String [] bilgiler=new String[4];
        int sayac=0;
        while(br.ready()){
          okunan=br.readLine();
            for (int i = 0; i < okunan.length(); i++) {
                if (okunan.charAt(i)!=' ') {
                    s=s+okunan.charAt(i);
                }
                else{
                    bilgiler[sayac]=s;
                    sayac++;
                    s="";
                    
                }
                
                
            }
            bilgiler[sayac]=s;
            adı1=bilgiler[0];
            soyadı1=bilgiler[1];
            numara1=Integer.parseInt(bilgiler[2]);
            sinifi=Integer.parseInt(bilgiler[3]);
            tmp=new ogrenci(adı1,soyadı1,numara1,sinifi);
            ogrenciekle(tmp);
            sayac=0;
            s="";
           
} 
      
       
    } catch (Exception ex) {
  
    }
 }
 public void ogrencidersekle(File f){
 ders tmp;
 String okunan;
 String s="";
 String c[]=new String[2];
 int sayac=0;
    try {
        FileReader fr = new FileReader(f);
               BufferedReader br = new BufferedReader(fr);
                 while(br.ready()){
                       okunan=br.readLine();
                       for (int i = 0; i < okunan.length(); i++) {
                           if (okunan.charAt(i)!=' ') {
                               s+=okunan.charAt(i);
                               
                           }
                           else{
                           c[sayac]=s;
                           sayac++;
                           s="";  
                           }
                     }
                 c[sayac]=s;
                 sayac=0;
                 s="";
                 int sinifi=Integer.parseInt(c[1]);
                 String derskodu=c[0];
                 tmp=new ders(derskodu,sinifi);
                 ogrenci tmp2=bas;
                 while(tmp2!=null){
                     if (tmp2.sinifi==tmp.sinifi) {
                         tmp2.dersekle(tmp);
                     
                     }
                     tmp2=tmp2.ileri;
                 
                 }
                 
                 
                 
                 }
                  fr.close();
        br.close();
       
    } catch (Exception  ex) {

    }
 
 
 
 }
 public void ogrenciderslist(){
   ogrenci tmp=bas;
   while(tmp!=null){
       System.out.println(tmp.adı+" "+tmp.soyadı+" "+tmp.no+" "+tmp.sinifi+" ");
       tmp.dersgoster();
       tmp=tmp.ileri;
   }
 
 
 
 
 }
 public void encokdersalangonder(){
     ogrenci tmp=bas;
     ogrenci enb=tmp;
     ders d;
     int enbsayac=0;
     int sayac=0;
     while(tmp!=null){
         d=tmp.bas;
                 while(d!=null){
                     sayac++;
                     d=d.ileri;
                 }
         if(sayac>enbsayac){
             enb=tmp;
             enbsayac=sayac;
         }
         tmp=tmp.ileri;
         sayac=0;
         
     }
     System.out.println(enb.adı);
     enb.dersgoster();
 }
 public void ogrkontrol(ogrenci aranan){
 ogrenci tmp=bas;
 while(tmp!=null){
     if (tmp.adı.equals(aranan.adı)) {
  System.out.println(tmp.adı+" "+tmp.soyadı+" "+tmp.no+" "+tmp.sinifi+" ");
         tmp.dersgoster();
         break;
     }
     tmp=tmp.ileri;
 }
     if (tmp==null) {
         System.out.println("öğrenci bulunamadı");
     }
 
 }
     public static void main(String[] args) {
         File f=new File("ogrenciler.txt");
         File fr=new File("dersler.txt");
         Liste2 l=new Liste2();
            l.ogrokuekle(f);
         l.ogrencidersekle(fr);
         l.ogrenciderslist();
         l.encokdersalangonder();
 

        
    //     l.ogrkontrol(o);
      //   l.ogrenciderslist();
        // ders d=new ders("BMÜ322",3);
     //    l.bas.derssil(d);
     //    l.ogrkontrol(l.bas);
         
      
    
      
                 

    }
    
}
