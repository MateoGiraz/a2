package tads;
import java.util.*;
public class LinkedList<T> implements List<T> {
  private int totalElements;
  private Node head;

  public class Node {
    public T data;
    public Node next;
    
    public Node(T d){
      data = d;
      next = null;
    }
  }

  public LinkedList(){
    totalElements = 0;
    head = null;
  }

  @Override
  public int totalElements() {
    return totalElements;
  }

  @Override
  public void addElement(T data) {
    Node newNode = new Node(data);
    totalElements++;

    if(head == null){
      head = newNode;
      return;
    }    

    newNode.next = head;
    head = newNode;
  }
  

  public void remove(T data){
    if(head == null) return;
    if(head.equals(data)) head = null;
    Node aux = head;
    while(!aux.next.equals(data)) aux = aux.next;
    if(aux.next == null) return;
    aux.next = aux.next.next;
  }
  

  @Override
  public Iterable<T> data() {
    return new Iterable<T>(){

      @Override
      public Iterator<T> iterator() {
        return new LinkedListIterator();
      }
      
    };
  }

  class LinkedListIterator implements Iterator<T>{

    private Node head;
    int nodesLeft;

    public LinkedListIterator(){
      this.head = head;
      this.nodesLeft=totalElements;
    }

    @Override
    public boolean hasNext() {
      return nodesLeft > 0;
    }

    @Override
    public T next() {
      while(head != null){
        T current =head.data;
        head = head.next;
        
        nodesLeft--;
        return current;
      }
      return null;
    }

  }

}
