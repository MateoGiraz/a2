package tads;

public interface Heap {
  public void heapify(int[] arr);
  public void heapSort();
  public int pop();
  public void insert(int data);
}