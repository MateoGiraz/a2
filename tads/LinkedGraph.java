package tads;
import tads.*;

import java.util.Iterator;

public class LinkedGraph implements Graph {


  private int totalElems;
  private int edges;
  private LinkedList<Edge>[] arr;

  public LinkedGraph(int elems){
    edges = 0;
    totalElems=elems;
    arr = (LinkedList<Edge>[]) new Object[totalElems+1];
  }

  @Override
  public int size() {
    return arr.length;
  }

  @Override
  public void addEdge(int v, int w, int weight) {
    Edge edge = new Edge(v,w,weight);
    arr[v].addElement(edge);
  }

  @Override
  public int edgeCount(int v) {
    return arr[v].totalElements();
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public boolean hasEdge(int v, int w) {
    LinkedList a=arr[v];
    for(Edge e:edges(v)){
      if (e.vDest==w){
        return true;
      } 
    }
    return false;
  }

  @Override
  public int getWeight(int v, int w) {
    int ret = 0;
    for(Edge e:edges(v)){
      if (e.vDest==w){
        return e.weight;
      }

    
  }
  return ret;
}

  @Override
  public void removeEdge(int v, int w) {

  }

  @Override
  public Iterable<Edge> edges(int v) {
    return arr[v].data();
      
    };
  }
  
 

