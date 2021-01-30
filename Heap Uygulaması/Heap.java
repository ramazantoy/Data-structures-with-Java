
package heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author FallenFool
 */
public class Heap {
     int[] hdizi; 
    int hboyut; 
    int htumboyut; 

	private static final int FRONT = 1; 

          Heap(int htumboyut) 
	{ 
		this.htumboyut = htumboyut; 
		this.hboyut = 0; 
		this.hdizi = new int[this.htumboyut]; 
                this.hdizi=hdizi;
	} 
	private int Atabul(int indis) 
	{ 
		return (indis-1)/2;
	} 

	private int SolCocuk(int indis) 
	{ 
		return (2 * indis)+1; 
	} 
	private int SagCocuk(int indis) 
	{ 
		return (2 * indis) + 2; 
	} 
	private boolean YaprakMı(int indis) 
	{ 
		if (indis >= (hboyut-1 / 2) && indis <= hboyut-1) { 
			return true; 
		} 
		return false; 
	} 
	private void degistir(int bindis, int iindis) 
	{ 
		int tmp; 
		tmp = hdizi[bindis]; 
		hdizi[bindis] = hdizi[iindis]; 
		hdizi[iindis] = tmp; 
	} 
	private void minHeapify(int indis) 
	{ 
		if (!YaprakMı(indis)) { 
			if (hdizi[indis] > hdizi[SolCocuk(indis)] 
				|| hdizi[indis] > hdizi[SagCocuk(indis)]) {
				if (hdizi[SolCocuk(indis)] < hdizi[SagCocuk(indis)]) { 
					degistir(indis, SolCocuk(indis)); 
					minHeapify(SolCocuk(indis)); 
				} 

				
				else { 
					degistir(indis, SagCocuk(indis)); 
					minHeapify(SagCocuk(indis)); 
				} 
			} 
		} 
	} 
	public void Ekleme(int eleman) 
	{ 
		if (hboyut >= htumboyut) { 
			return; 
		} 
		hdizi[++hboyut] = eleman; 
		int son = hboyut; 

		while (hdizi[son] < hdizi[Atabul(son)]) { 
			degistir(son, Atabul(son)); 
			son = Atabul(son); 
		} 
	} 
	public void Goster() 
	{ 
		for (int i = 0; i <=hboyut; i++) { 
			System.out.print(hdizi[i]+" ");
		} 
	} 
	public void Minlestir() 
	{ 
		for (int pos=0;pos<hboyut;pos++) {
                    for (int i =pos; i >= 0; i--) {
                        minHeapify(i);
                    }

		} 
	} 
	public int remove() 
	{ 
		int popped = hdizi[FRONT]; 
		hdizi[FRONT] = hdizi[hboyut--]; 
		minHeapify(FRONT); 
		return popped; 
	} 
        public boolean minHeapMi(int dizi[]){
            int sayac=0;
            for (int i = 0; i <(dizi.length/2); i++) {
                if(dizi[i]>dizi[(2 * i)+1] || dizi[i]>dizi[(2 * i) + 2] ){
                    sayac++;
                    break;
                }
            }
            if(sayac==0){
                return true;
            }
            else{
                return false;
            }
  
        }
	public void Birlestir(Heap []h){//o(n^2)
            for (int i = 0; i < h.length; i++) {
                for (int j = 0; j<h[i].hdizi.length; j++) {
                    Ekleme(h[i].hdizi[j]);
                }
            }
            Minlestir();
        }

private void Maxheapify()
{
for(int i = hboyut; i >= 0; i--) 
    MaxHeap(i); // her heap sorgusu => O (log(n))
}
private void MaxHeap(int i)
{
int left = SolCocuk(i); // şuanki indisin sol çocuğu
int right= SagCocuk(i);// şuanki indisin sağ çocuğunun indisi
int largest = i; // kendisini büyükmüş gibi görüyoruz

if((left <= hboyut) && (hdizi[left] > hdizi[largest]) ) // sol çocuğu büyükse en büyük sol oluyor
largest = left;

if((right <= hboyut) && (hdizi[right] > hdizi[largest]) ) // sağ ile büyüğü karşılaştırıyoruz
largest = right; // büyükse en büyük sağ çocuk oluyor

if(largest != i) // iki indis aynı olana kadar
{
// indisler arası değiştirme, swap işlemi yapıyoruz
int temp = hdizi[i];
hdizi[i] = hdizi[largest];
hdizi[largest] = temp;

MaxHeap(largest); // değiştirilen indisleri kontrol ediyoruz
}
}


    public static void main(String[] args) {
    Heap h=new Heap(8);
    /*
    min heap kontrol
    int [] dizi={1,2,3,4,5,2,7};
        System.out.println(h.minHeapMi(dizi));
    */
    /*
    Birlestirme
    Heap []h1=new Heap[2];
    h1[0]=new Heap(6);
    h1[0].Ekleme(5);
     h1[0].Ekleme(3);
       h1[0].Ekleme(6);
     h1[0].Ekleme(4);
    h1[1]=new Heap(6);
    h1[1].Ekleme(7);
    h1[1].Ekleme(3);
    h.Birlestir(h1);
    h.Minlestir();
    h.Goster();
    */
   
    /*
    Min heap max heap yapma
    h.Ekleme(4);
    h.Ekleme(2);
    h.Ekleme(6);
    h.Ekleme(5);
    h.Ekleme(1);
    h.Ekleme(3);
   h.Goster();
        System.out.println("");
    h.Maxheapify();
    h.Goster();*/
    
    }
    
}
