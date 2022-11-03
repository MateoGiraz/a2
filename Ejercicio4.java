import java.util.Scanner;
import tads.*;

public class Ejercicio4 {

  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int numOfV = Integer.parseInt(myScanner.nextLine());
    int numOfE = Integer.parseInt(myScanner.nextLine());
    
    Graph g = new LinkedGraph(numOfV);
  
    for(int i = 0; i < numOfE; i++){
      String[] input = myScanner.nextLine().split(" ");
      int v = Integer.parseInt(input[0]);
      int w = Integer.parseInt(input[1]);
      
      g.addEdge(v, w, 1);
      g.addEdge(w, v, 1);
    }
    boolean connected = true;

    for(int i = 1; i <= numOfV; i++){
      for(int j = 1; j < numOfV; j++){
        g.removeEdge(i, j);
        g.removeEdge(j, i);
        connected = connected && isConnected(g);
        g.addEdge(i, j, 1);
        g.addEdge(j, i, 1);

      }
    }

    String res = connected ? "1" : "0";
    System.out.println(res);
    myScanner.close();

  }

  public static boolean isConnected(Graph g){
    boolean visited[] = new boolean[g.size()+1];
    for(boolean item : visited) item = false;
    dfs(g, 1, visited);
    for(boolean elem : visited) if(!elem) return false;
    return true;
  }

  public static void dfs(Graph g, int v, boolean[] visited){
    visited[v] = true;
    for(Edge e : g.edges(v))
      if(!visited[e.vDest]){
        dfs(g, e.vDest, visited);
      }
  }

}
