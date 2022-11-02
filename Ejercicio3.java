import java.util.Scanner;
import tads.*;

public class Ejercicio3 {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int numOfV = Integer.parseInt(myScanner.nextLine());
    int numOfE = Integer.parseInt(myScanner.nextLine());
  
    Graph g = new LinkedGraph(numOfV);

    for(int i = 0; i < numOfE; i++){
      String[] input = myScanner.nextLine().split(" ");
      int v = Integer.parseInt(input[0]);
      int w = Integer.parseInt(input[1]);
      int weight = input.length == 3 ? Integer.parseInt(input[2]) : 1;
      
      g.addEdge(v, w, weight);
      g.addEdge(w, v, weight);
    }    
    
    int numOfExcluded = Integer.parseInt(myScanner.nextLine());
    int[] excluded = new int[numOfExcluded];
    for(int i = 0; i < numOfExcluded; i++){
      int elemExcluded = myScanner.nextInt();
          excluded[i] = elemExcluded;
    }

    myScanner.close();


  }
}
