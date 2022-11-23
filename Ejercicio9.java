import java.util.*;

public class Ejercicio9 {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int totalElems = Integer.parseInt(myScanner.nextLine());
    
    int[] arr = new int[totalElems];
    for(int i = 0; i < totalElems; i++){
      arr[i] = myScanner.nextInt();
    }

    int testCases = myScanner.nextInt();
    for(int i = 0; i < testCases; i++){
      int testCase = myScanner.nextInt();
      int res = minBT(arr,0,testCase,0);
      if(res==Integer.MAX_VALUE){
        res=0;
      }
      System.out.println(res);
    }

    myScanner.close();
  }
  public static int minBT(int[] nums,int index,int suma,int cont){
    if(suma<0|| index==nums.length) return Integer.MAX_VALUE;
    if(suma==0) return cont;
    return min(minBT(nums,index+1,suma,cont),minBT(nums, index, suma-nums[index], cont+1));
  }
  private static int min(int a, int b) {
    if(a<b)return a;
    return b;
  }


}
    