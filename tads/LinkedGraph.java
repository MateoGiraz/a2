package tads;

import java.util.Iterator;

public class LinkedGraph implements Graph {

  public class Node{
    int data;
    Node next;
    int weight;

    public Node(int d, int w){
      data = d;
      weight = w;
      next = null;
    }
  }
  
  private int edges;
  private Object arr[];

  public LinkedGraph(int elems){
    edges = elems;
    arr = new Object[elems+1];
  }

  @Override
  public int size() {
    return arr.length;
  }

  @Override
  public void addEdge(int v, int w, int weight) {
    Node head = (Node) arr[v];

    while(head != null){
      if(head.data == w) return;
      head = head.next;
    }

    Node newNode = new Node(w, weight);
    newNode.next = (Node) arr[v];
    arr[v] = newNode;
  }

  @Override
  public int edgeCount(int v) {
    Node head = (Node) arr[v];
    int count = 0;

    while(head != null){
      count++;
      head = head.next;
    }

    return count;
  }

  @Override
  public int edgeCount() {
    return edges;
  }

  @Override
  public boolean hasEdge(int v, int w) {
    Node head = (Node) arr[v];
    boolean ret = false;

    while(head != null){
      if(head.data == w) ret = true;
      head = head.next;
    }

    return ret;
  }

  @Override
  public int getWeight(int v, int w) {
    Node head = (Node) arr[v];
    int ret = 0;

    while(head != null){
      if(head.data == w) ret = head.weight;
      head = head.next;
    }

    return ret;
  }

  @Override
  public void removeEdge(int v, int w) {
    Node head = (Node) arr[v];

    if(head == null) throw new Error("removing null");
    while(head.next != null && head.next.data != w) head = head.next;

    if(head.next == null) return;

    head.next = head.next.next;
  }

  @Override
  public Iterable<Edge> edges(int v) {
    return new Iterable<Edge>(){

      @Override
      public Iterator<Edge> iterator() {
        return new LinkedGraphIterator(v, edges);
      }
      
    };
  }
  
  class LinkedGraphIterator implements Iterator<Edge>{

    private Node head;
    int edges;

    public LinkedGraphIterator(int v, int e){
      head = (Node) arr[v];
      edges = e;
    }

    @Override
    public boolean hasNext() {
      return edges > 0;
    }

    @Override
    public Edge next() {
      while(head != null){
        Edge newEdge = new Edge(head.data, head.weight);
        head = head.next;
        edges--;
        return newEdge;
      }
      return null;
    }

  }
}
