import java.util.Scanner;
import tads.*;

public class Ejercicio3 {
    public static void main(String[] args) {  
        Scanner myScanner = new Scanner(System.in);
        int numOfV = Integer.parseInt(myScanner.nextLine());
        int numOfE = Integer.parseInt(myScanner.nextLine());
        
        Graph g = new LinkedGraph(numOfV);
      
        for(int i = 0; i < numOfE; i++){
          //System.out.println("Ingrese arista:");
          String[] input = myScanner.nextLine().split(" ");
          int v = Integer.parseInt(input[0]);
          int w = Integer.parseInt(input[1]);
          int weight=Integer.parseInt(input[2]);
          g.addEdge(v, w,weight);
          g.addEdge(w, v,weight);
        }
        int numOfExcluded= Integer.parseInt(myScanner.nextLine());
        int[] excluded=new int[numOfExcluded];
        for (int i = 0; i < numOfExcluded; i++) {
            excluded[i] = Integer.parseInt(myScanner.nextLine());
        }
        kruskal(g,excluded);
    }

    public static void kruskal(Graph g, int[] excluded){
        PQHeap cp=new PQHeap(g.edgeCount());
        for(int i=0;i<g.size();i++){
          for(Edge e:g.edges(i)){
            if(!isExcluded(e.vOrigen, e.vDest, excluded))
            cp.push(e);
          }
        }
        PQHeap ret=new PQHeap(g.edgeCount());
        DisjointSet dSet= new DisjointSet(g.size());
        while(!cp.isEmpty()){
          Edge e=cp.pop();
          if(dSet.find(e.vOrigen)!=dSet.find(e.vDest)){
            dSet.join(e.vOrigen,e.vDest);
            int verticeChico=min(e.vOrigen,e.vDest);
            int verticeGrande=max(e.vOrigen,e.vDest);
            Edge nuevo=new Edge(e.weight, verticeGrande, verticeChico);
            ret.push(nuevo);
          }
          
        }
        System.out.println(ret.size());
        while(!ret.isEmpty()){
            Edge e=ret.pop();
            System.out.println(e.weight+" "+e.vDest+" "+e.vOrigen);
        }
    }

    public static boolean isExcluded(int v,int w, int[] excluded){
        for (int i = 0; i < excluded.length; i++) {
            if(v==excluded[i] || w==excluded[i]){
                return true;
            }           
        }
        return false;
    }
    public static int min(int x,int y){
        if(x>y)return y;
        return x;
    }
    public static int max(int x,int y){
        if(x>y)return x;
        return y;
    }


}
