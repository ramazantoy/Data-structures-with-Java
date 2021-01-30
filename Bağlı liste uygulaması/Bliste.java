
package bliste;

class eleman{
    int not;
    String ad;
   eleman ileri;
   eleman(int not,String ad){
       this.not=not;
       this.ad=ad;
   }
}
public class Bliste {
eleman bas,son;
public void Ekle(eleman yeni){
    if(bas==null){
        bas=yeni;
        son=yeni;
    }
    else{
        son.ileri=yeni;
        son=yeni;
    }
}
public void BastanEkle(eleman yeni){
    if(bas==null){
        bas=yeni;
        son=yeni;
    }
    else{
        yeni.ileri=bas;
        bas=yeni;
    }
}
public void Goster(){
    eleman tmp=bas;
    System.out.println("");
    while(tmp!=null){
        System.out.print(tmp.ad+" "+tmp.not+" ");
        tmp=tmp.ileri;
    }
}
public eleman İstenileniSil(eleman silinecek){
    eleman tmp=bas;
    eleman tmp2;
    if(silinecek.ad.equals(bas.ad)){
        bas=bas.ileri;
        return silinecek;
    }
    else if(silinecek.ad.equals(son.ad)){
        while(tmp.ileri!=son){
            tmp=tmp.ileri;
        }
        tmp2=son;
        tmp.ileri=null;
        son=tmp;
        return silinecek;
        
    }
    else{
        while(tmp.ileri.ad!=silinecek.ad){
            tmp=tmp.ileri;
        }
        tmp.ileri=silinecek.ileri;
        silinecek.ileri=null;
        return silinecek;
    }
}
public void Sırala(){
    eleman tmp=bas;
    eleman tmp2=bas;
    eleman enb=null;
    int sayac=0;
 while(tmp!=null){
     while(tmp2!=null){
         if(tmp.not<tmp2.not){
             enb=tmp2;
         }
         tmp2=tmp2.ileri;
     }
     İstenileniSil(enb);
     BastanEkle(enb);
     tmp=tmp.ileri;
     tmp2=tmp;
     
 }
  
  
  
}
   
    public static void main(String[] args) {
        Bliste b=new Bliste();
        eleman e=new eleman(20,"Ramo");
        b.Ekle(e);
        e=new eleman (10,"mustafa");
        b.Ekle(e);
        e=new eleman(39,"reşit");
        b.Ekle(e);
        e=new eleman(28,"hayat");
        b.Ekle(e);
        b.Goster();
        b.Sırala();
        b.Goster();
    }
    
}
