import java.util.Scanner;
import tads.*;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("numero de vertices:");
        int numOfV = Integer.parseInt(myScanner.nextLine());
        System.out.println("numero de aristas:");
        int numOfE = Integer.parseInt(myScanner.nextLine());
        
        Graph g = new LinkedGraph(numOfV);
      
        for(int i = 0; i < numOfE; i++){
          System.out.println("Ingrese arista:");
          String[] input = myScanner.nextLine().split(" ");
          int v = Integer.parseInt(input[0]);
          int w = Integer.parseInt(input[1]);
          int weight=Integer.parseInt(input[2]);
          
          g.addEdge(v, w,weight);
          g.addEdge(w, v,weight);
        }
        System.out.println("Ingrese cantidad de vértices a excluir");
        int numOfExcluded= Integer.parseInt(myScanner.nextLine());
        int[] excluded=new int[numOfExcluded];
        for (int i = 0; i < numOfExcluded; i++) {
            System.out.println("Ingrese el vértice a excluir");
            excluded[i] = Integer.parseInt(myScanner.nextLine());
        }
        kruskal(g,excluded);
    }

    public static void kruskal(Graph g, int[] excluded){
        PQHeap cp=new PQHeap(g.size());
        for(int i=0;i<g.size();i++){
          for(Edge e:g.edges(i)){
            if(!isExcluded(e.vOrigen, e.vDest, excluded))
            cp.push(e);
          }
        }
        LinkedList <Edge> ret=new LinkedList<Edge>();
        DisjointSet dSet= new DisjointSet(g.size());
        while(!cp.isEmpty()){
          Edge e=cp.pop();
          if(dSet.find(e.vOrigen)!=dSet.find(e.vDest)){
            dSet.join(e.vOrigen,e.vDest);
            ret.addElement(e);
          }
        }
        System.out.println(ret.totalElements());
        for(Edge h:ret.data()){
            System.out.println(h.vOrigen+" "+h.vDest+" "+h.weight);
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


}
