package tads;

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
  
}
