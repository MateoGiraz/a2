import java.util.Scanner;

import tads.Graph;
import tads.LinkedGraph;
import tads.Edge;
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

    for(int i = 1; i <= numOfV && connected; i++){
      for(int j = 1; j <= numOfV && connected; j++)
        connected = connected && isConnected(g, i, j);
    }

    String res = connected ? "1" : "0";
    System.out.println(res);
    myScanner.close();

  }

  public static boolean isConnected(Graph g, int i, int j){
    boolean visited[] = new boolean[g.size()];
    visited[0] = true;
    visited[i] = true;
    visited[j] = true;
    int min = getMinValue(i,j);
    dfs(g, min, visited, i, j);
    for(boolean elem : visited) if(!elem) return false;
    return true;
  }

  public static void dfs(Graph g, int v, boolean[] visited, int i, int j){
    if(v == i || v == j) return;
    visited[v] = true;
    for(Edge e : g.edges(v)){
      if(!visited[e.vDest]){
        dfs(g, e.vDest, visited, i, j);
      }
    }
  }

  public static int getMinValue(int i, int j){
    int min = 1;
    while(min == i || min == j) min++;
    return min;
  }

}
