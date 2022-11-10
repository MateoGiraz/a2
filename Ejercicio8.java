import java.util.*;
public class Ejercicio8{
    public static void main(String[] args) {
      Scanner myScanner = new Scanner(System.in);
      int totalElems = Integer.parseInt(myScanner.nextLine());
      
      int[] arr = new int[totalElems];
      for(int i = 0; i < totalElems; i++){
        arr[i] = myScanner.nextInt();
      }
  
      int cota = myScanner.nextInt();
      int testCases = myScanner.nextInt();
      int maximo=0;
      int[] testCasesArr = new int[testCases];
      for(int i = 0; i < testCases; i++){
        testCasesArr[i] = myScanner.nextInt();
        int a=testCasesArr[i];
        if(a>maximo){
          maximo=a;
        }
      }
      int [] historial=new int [maximo+1];
  
      for(int elem : testCasesArr){
        if(historial[elem]==0){
        boolean esSubSet=subSet(historial,arr, totalElems-1, elem);
        historial[elem]= esSubSet ? 1 : -1;
        }
        int res = historial[elem]==1 ? 1:0;
        System.out.println(res);
      }
      System.out.println("Historial:");
      for (int i = 0; i < historial.length; i++) {
        System.out.println(historial[i]);
      }
  
    }
    
    public static boolean subSet(int[]historial,int[] arr, int elements, int sum){
      if(sum == 0)
        return true;
      if(elements < 0 || sum < 0) return false;
      boolean opA = subSet(historial,arr, elements, sum - arr[elements]);
      boolean opB = subSet(historial,arr, elements-1, sum);
      return opA || opB;
  }
  }
  /*
   * -Tiene que haber un int[] historial
   * -Tiene que tener tres estados posibles
   * -Por ejemplo, 1=true,-1=false, 0=not processed
   * 
   */
