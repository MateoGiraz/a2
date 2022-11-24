import java.util.Scanner;

import tads.Pair;
public class Ejercicio5{
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int numOfV = Integer.parseInt(myScanner.nextLine());
    int numOfE = Integer.parseInt(myScanner.nextLine());
    Pair[] arr = new Pair[numOfV+1];
    for(int i = 0; i < arr.length; i++) arr[i] = new Pair(i, 0);

    for(int i = 0; i < numOfE; i++){
      String[] input = myScanner.nextLine().split(" ");
      int w = Integer.parseInt(input[1]);
      arr[w].totalIncidence++;
    }
    
    myScanner.close();
    mergeSort(arr, 1, arr.length-1);

    for(int i = 1; i < arr.length; i++){
      System.out.println(arr[i].nodeNum+ " " +arr[i].totalIncidence);
    }
  }

public static void mergeSort(Pair[] arr, int start, int end){
  if(start == end) return;
  int mid=(start+end)/2;
  mergeSort(arr,start,mid);
  mergeSort(arr,mid+1,end);
  
  int size1 = mid - start + 1;
  int size2 = end - mid;

  Pair[] left = new Pair[size1];
  Pair[] right = new Pair[size2];
  
  for(int i = 0; i < size1; i++) left[i] = arr[i + start]; 
  for(int i = 0; i < size2; i++) right[i] = arr[mid + i + 1];

  merge(arr,start,left,right); //merge 2 sorted arrs into arr
}

public static void merge(Pair[]arr,int start,Pair[] left,Pair[] right){
  
  int leftIndex = 0, rightIndex = 0, index = start;

  while(leftIndex < left.length && rightIndex < right.length){
      if(left[leftIndex].totalIncidence > right[rightIndex].totalIncidence){
          arr[index] = left[leftIndex];
          leftIndex++;
          index++;
          continue;
      }
      arr[index] = right[rightIndex];
      rightIndex++;
      index++;
  }

  //items left if there where
  while (leftIndex < left.length) {
    arr[index] = left[leftIndex];
    index++;
    leftIndex++;
  }
 
  //items left if there where
  while (rightIndex < right.length) {
    arr[index] = right[rightIndex];
    index++;
    rightIndex++;
  } 

}
}