package tads;

import java.util.Iterator;

public class EdgeLinkedList<Edge> implements EdgeList<Edge> {
  
  public class Node{
    Edge data;
    Node next;
    public Node(Object data){
      this.data = (Edge) data;  
      this.next = null;
    }
    @Override
    public boolean equals(Object o){
      Node node = (Node) o;
      Edge edge = (Edge) node.data;
      if(this.data.equals(edge)) return true;
      return false;
    }
  }
  int totalElements;
  Node head;

  public EdgeLinkedList(){
    head = null;
    totalElements = 0;
  }

  @Override
  public int totalElements() {
    return totalElements;
  }

  @Override
  public void addElement(Object data) {
    Node newNode = new Node((Edge) data);
    totalElements++;
    if(head == null){
      head = newNode;
      return;
    }

    newNode.next = head;
    head = newNode;
  }

  @Override
  public void removeElement(Object data) {
    if(head == null) return;
    Node newNode = new Node((Edge) data);

    if(head.equals(newNode)){
      head = head.next;
      totalElements--;
      return;
    }
    
    Node aux = head;
    while(aux.next != null && !aux.next.equals(newNode)) aux = aux.next;
    
    if(aux == null || aux.next == null) return;

    aux.next = aux.next.next;
    totalElements--;

  }

  @Override
  public Iterable<Edge> data() {
    return new Iterable<Edge>(){

      @Override
      public Iterator<Edge> iterator() {
        return new LinkedListIterator();
      }
      
    };
  }
  
  class LinkedListIterator implements Iterator<Edge>{

    private Node top;

    public LinkedListIterator(){
      this.top = head;
    }

    @Override
    public boolean hasNext() {
      return top != null;
    }

    @Override
    public Edge next() {
      Edge current = top.data;
      top = top.next;
      return current;
    }

  }

  
}
