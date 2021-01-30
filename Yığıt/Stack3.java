
package stack3;
/**
Bir grafiksel arayüz ile Word programındaki undo ve redo işlemlerinin gerçekleştirildiği 
bir kelime işlem programı yapmanız istenmektedir.
 Bu amaçla  string bilgileri tutan bir yığıt yapısı ekleme(), silme(), bosmu(), tepe(), vb. metotları ile) 
 * oluşturulmalıdır. 
Text alanına girilen kelimeler word’te olduğu gibi ileri ve geri alınabilmelidir. 
Arayüz bir adet textarea, redo (ileri alma), undo(geri alma) ve kaydet butonlarından oluşmalıdır.
 Bu amaçla iki yığıt kullanılabilir. 1. yığıt yeni kelimeleri alırken eğer herhangi
, bir geri alma işlemi var ise işlemler 1. Yığıttan 2. Yığıta eklenmelidir. 
İleri alma işleminde ise işlemler 2. Yığıttan alınıp tekrar 1. Yığıta eklenmelidir.
 Kaydet butonuna tıklandığında ise artık veri kaydedildiği için bu kısma kadar yazılanlar ileri veya geri alınamayacaktır.
Gerekli veri yapılarını ve arayüzü oluşturarak kodlamaları yapınız?
 */

class dugum{
    String metin;
    dugum next;
    dugum(String metin){
        next=null;
        this.metin=metin;
    }
}
public class Stack3 {
dugum ileriüst;
dugum geriüst;
public void Pushİleri(dugum yeni){
    if(ileriüst==null){
        ileriüst=yeni;
    }
    else{
        yeni.next=ileriüst;
        ileriüst=yeni;
    }
}
public void PushGeri(dugum yeni){
    if(geriüst==null){
        geriüst=yeni;
    }
    else{
        yeni.next=geriüst;
        geriüst=yeni;
    }
}
public dugum Popİleri(){
    if(ileriüst.next==null){
     ileriüst=ileriüst.next;
       return null;
    }
    else{
    dugum tmp=ileriüst;//koruma kopyalama geri döndürmek için
    ileriüst=ileriüst.next;//tepe'yi bir alta kaydırma
    return tmp;
    }
}
public dugum PopGeri(){
      if(geriüst.next==null){
     geriüst=geriüst.next;
       return null;
    }
    else{
    dugum tmp=geriüst;//koruma kopyalama geri döndürmek için
    geriüst=geriüst.next;//tepe'yi bir alta kaydırma
    return tmp;
      }
}
public void Kaydet(){
    dugum tmp;
    while(ileriüst!=null){//stack üstü boşsa stack boştur
        tmp=Popİleri();
    }
        while(geriüst!=null){
        tmp=PopGeri();
    }
}

    public static void main(String[] args) {

     
    }
    
}
