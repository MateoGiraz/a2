import java.util.Scanner;
import tads.*;

public class Ejercicio2 {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int numOfElements = myScanner.nextInt();

    int[] newArr = new int[numOfElements+1];

    for(int i = 1; i < numOfElements+1; i++){
      newArr[i] = myScanner.nextInt();
    }

    Heap myHeap = new MaxHeap(newArr.length+1);
    myHeap.heapify(newArr);
    myHeap.heapSort();

    for(int i = 1; i < numOfElements+1; i++){
      System.out.println(newArr[i]);
    }

    myScanner.close();
  }
}
