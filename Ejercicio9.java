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
      List<Integer> possibleSol = new LinkedList<Integer>();
      List<Integer> bestSol = new LinkedList<Integer>();
      List<Integer> res = solveBT(arr, testCase, possibleSol, bestSol);
      System.out.println(res.size());
    }

    myScanner.close();
  }
  
  public static List<Integer> solveBT(int[] arr, int m, List<Integer> possibleSol, List<Integer> bestSol){
    //prune
    if(m < 0 || (possibleSol.size() >= bestSol.size() && bestSol.size() > 0)) return bestSol;
    //if sol didnt got pruned, then it's new best. Return new copy of possibleSol
    if(m == 0) return List.copyOf(possibleSol);
    
    for(int i = 0; i < arr.length; i++){
      possibleSol.add(arr[i]);
      bestSol = solveBT(arr, m-arr[i], possibleSol, bestSol);
      possibleSol.remove(Integer.valueOf(arr[i]));
    }

    return bestSol;
  }

}