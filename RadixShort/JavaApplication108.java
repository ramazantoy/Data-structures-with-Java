
package javaapplication108;



import java.util.Arrays;

class RadixSort {
  void countingSort(int array[], int size, int place) {
    int[] output = new int[size + 1];
    int max = array[0];
    for (int i = 1; i < size; i++) {
      if (array[i] > max)
        max = array[i];
    }
    int[] count = new int[max + 1];
    for (int i = 0; i < max; ++i)
      count[i] = 0;
    for (int i = 0; i < size; i++)
      count[(array[i] / place) % 10]++;
    for (int i = 1; i < 10; i++)
      count[i] += count[i - 1];
    for (int i = size - 1; i >= 0; i--) {
      output[count[(array[i] / place) % 10] - 1] = array[i];
      count[(array[i] / place) % 10]--;}
    for (int i = 0; i < size; i++)
      array[i] = output[i];}
  int getMax(int array[], int n) {
    int max = array[0];
    for (int i = 1; i < n; i++)
      if (array[i] > max)
        max = array[i];
    return max; }
  void radixSort(int array[], int size) {
    int max = getMax(array, size);
    for (int place = 1; max / place > 0; place *= 10)
      countingSort(array, size, place);}
}
public class JavaApplication108 {
  public static void main(String args[]) {
          String s[]={"ANKARA","MALATYA","ELAZIĞ","ISTANBUL"};
          int max=s[0].length();
      for (int i = 0; i <s.length; i++) {
       if(max<s[i].length()){
          max=s[i].length();
       }   
      }
      for (int i = 0; i <s.length; i++) {
          if(s[i].length()<max){
              while(s[i].length()<max){
                  s[i]+=" ";
              }
          }     
      }
      System.out.println(Arrays.toString(s));
      int[] d=new int[s.length];
     for (int i = 0; i < 4; i++) {
         d[i]=s[i].charAt(0);
      }
    int size = d.length;
    RadixSort rs = new RadixSort();
    rs.radixSort(d, size);
 String temp;
     for (int i = 0; i <s.length; i++) {
          for (int j = 0; j <s.length; j++) {
           if(d[i]==s[j].charAt(0)){
              temp=s[i];
              s[i]=s[j];
              s[j]=temp;
          }
          }
      }
     int k=0;
      for (int i = 0; i <s.length; i++) {
          for (int j =i+1; j <s.length; j++) {
              if(s[i].charAt(k)==s[j].charAt(k)){
                  while(s[i].charAt(k)==s[j].charAt(k) && k<max){
                      k++;
                  }
                  if(s[i].charAt(k)>s[j].charAt(k)){
                      temp=s[i];
                      s[i]=s[j];
                      s[j]=temp;
                  }
              }
          }
          k=0;
      }
     System.out.println(Arrays.toString(s));
   
  }
}
