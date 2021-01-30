
package labirent;

class dugum{
int satır,sütun;
int maliyetsayac=0;

dugum ileri;
 dugum(int satır,int sütun){
 this.satır=satır;
 this.sütun=sütun;
 ileri=null;
}



}
public class Labirent {
dugum bas,son;
public void ekle(dugum yeni){
    if (bas==null) {
        bas=yeni;
        son=yeni;
    }
    else{
    son.ileri=yeni;
    son=yeni;
    
    
    }



}
public dugum sil(){
       
return bas=bas.ileri;

}
 public void enkısayol(int[][]labirent,int hsatır,int hsütun ){
 int satır=0,sütun=0; //başlangıç
 dugum tmp;
 int ziyaret[][]=new int[labirent.length][labirent[0].length];
    tmp=new dugum(satır,sütun); 
 ekle(tmp);
 ziyaret[0][0]=1;
 while (true){
      if (bas.sütun==hsütun && bas.satır==hsatır) {
          System.out.println(bas.maliyetsayac);
         break;
     }
      if(satır<labirent.length-1){//aşağı
       if (ziyaret[satır+1][sütun]==0 && labirent[satır+1][sütun]!=0) {
       tmp=new dugum(satır+1,sütun); 
       tmp.maliyetsayac=bas.maliyetsayac+tmp.maliyetsayac+1;
       ekle(tmp);
       ziyaret[satır+1][sütun]=1;
         }
      }
      if(sütun<labirent[0].length-1){//sağ
       if (ziyaret[satır][sütun+1] ==0 && labirent[satır][sütun+1]!=0) {
       tmp=new dugum(satır,sütun+1); 
       tmp.maliyetsayac=bas.maliyetsayac+tmp.maliyetsayac+1;
       ekle(tmp);
       ziyaret[satır][sütun+1]=1;
         }  }
      
      if(sütun>=1){//sol
      if (ziyaret[satır][sütun-1] ==0 && labirent[satır][sütun-1]!=0) {
       tmp=new dugum(satır,sütun-1); 
        tmp.maliyetsayac=bas.maliyetsayac+tmp.maliyetsayac+1;
       ekle(tmp);
       ziyaret[satır][sütun+1]=1;
         } }  
     if(satır>=1){//yukarı
             
      if (ziyaret[satır-1][sütun]==0 && labirent[satır-1][sütun]!=0) {
       tmp=new dugum(satır-1,sütun); 
       tmp.maliyetsayac=bas.maliyetsayac+1;
       ekle(tmp);
       ziyaret[satır-1][sütun]=1;
     }
    }   
     sil();
      satır=bas.satır;
     sütun=bas.sütun;
    
     
 
 
 }}
 
          
          
    public static void main(String[] args) {
     int[][] dizi
            = {
                {1, 1, 0, 1, 1, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 1, 0, 0, 1}  };
     Labirent l=new Labirent();
     l.enkısayol(dizi, 1,3);
      
      
    }
    
}
