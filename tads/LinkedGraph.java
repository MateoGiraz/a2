package tads;

public class LinkedGraph implements Graph {

  private int totalElems;
  private int edges;
  private Object[] arr;

  public LinkedGraph(int elems){
    edges = 0;
    totalElems = elems;
    arr = new Object[totalElems+1];

    for(int i = 0; i < arr.length; i++){
      arr[i] = new EdgeLinkedList<Edge>();
    }
  }

  @Override
  public int size() {
    return arr.length;
  }

  @Override
  public void addEdge(int v, int w, int weight) {
    Edge edge = new Edge(v, w, weight);
    ((EdgeLinkedList<Edge>)(arr[v])).addElement(edge);
    edges++;
  }

  @Override
  public int edgeCount(int v) {
    return ((EdgeLinkedList<Edge>)(arr[v])).totalElements();
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public boolean hasEdge(int v, int w) {
    for(Edge e : edges(v))
      if (e.vDest==w) return true;
    return false;
  }

  @Override
  public int getWeight(int v, int w) {
    for(Edge e:edges(v))
      if (e.vDest==w) return e.weight;
    return 0;
}

  @Override
  public void removeEdge(int v, int w) {
    Edge e = new Edge(v,w,0);
    ((EdgeLinkedList<Edge>)(arr[v])).removeElement(e);
    edges--;
  }

  @Override
  public Iterable<Edge> edges(int v) {
    return ((EdgeLinkedList<Edge>)(arr[v])).data();
    };
  }
  
 
