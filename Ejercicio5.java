import java.util.Scanner;
import tads.*;

public class Ejercicio5{
  static class Pair{
    private int nodeNum;
    private int totalIncidence;
    public Pair(int v){
      nodeNum = v;
      totalIncidence = 0;
    }
  }

  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int numOfV = Integer.parseInt(myScanner.nextLine());
    int numOfE = Integer.parseInt(myScanner.nextLine());
    Pair[] arr = new Pair[numOfV+1];
    for(int i = 0; i < arr.length; i++){
      arr[i] = new Pair(i);
    }
  
    for(int i = 0; i < numOfE; i++){
      String[] input = myScanner.nextLine().split(" ");
      int v = Integer.parseInt(input[0]);
      int w = Integer.parseInt(input[1]);
      arr[w].totalIncidence++;
    }

    mergeSort(arr, 0, arr.length-1);

    for(Pair elem : arr){
      System.out.println(elem.nodeNum+" "+elem.totalIncidence);
    }
  }


public static void mergeSort(Pair[] arr, int start, int end){
  if(start == end) return;
  int mid=(start+end)/2;
  mergeSort(arr,start,mid);
  mergeSort(arr,mid+1,end);
  merge(arr,start,mid,end);
}

public static void merge(Pair[]arr,int start,int mid,int end){
  int size1 = mid - start + 1;
  int size2 = end - mid;

  Pair[] left = new Pair[size1];
  Pair[] right = new Pair[size2];
  
  for(int i = 0; i < size1; i++)left[i] = arr[i + start]; 
  for(int i = 0; i < size2; i++) right[i] = arr[mid + i + 1];

  int i = 0, j = 0;
  int index = start;

  while(i < size1 && j < size2){
      if(left[i].totalIncidence <= right[j].totalIncidence){
          arr[index] = left[i];
          i++;
      }else{
          arr[index] = right[j];
          j++;
      }
      index++;
  }
}
}


