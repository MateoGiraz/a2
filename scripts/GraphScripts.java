package scripts;
import java.util.LinkedList;

import tads.*;
public class GraphScripts {
  public void Prim(Graph g){
    PriorityQueue pq = new PQHeap(g.size());
    boolean[] visitados = initVisitados();
    int[] costo = initCosto(1);
    int[] anterior = initAnterior()
    Edge newEdge = new Edge(1,0);
    pq.insert(1,0);
  }
}
