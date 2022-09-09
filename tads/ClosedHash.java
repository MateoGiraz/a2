package tads;
import funciones.*;

public class ClosedHash implements Hash{
// Pair[] arr
private Object[] arr;
private HashFunc h;
private HashFunc h_2;

public ClosedHash(int expectedSize, HashFunc h, HashFunc h_2) {
  this.arr = new Object[expectedSize * 2 - 1];
  this.h = h;
  this.h_2 = h_2;
}

class Node {
  String key;

  Node(String key) {
    this.key = key;
  }

}

  @Override
  public boolean insert(String value) {
    Node newNode = new Node(value);
    int i = 0;

    while(true){
      int pos = Math.abs((h.hash(value) + i * h_2.hash(value))) % arr.length;
      i++;

      if(arr[pos] == null){
        arr[pos] = newNode;
        return true;
      }

      if(((Node)arr[pos]).key.equals(value)) return false;
      
    }
    
  }

}
