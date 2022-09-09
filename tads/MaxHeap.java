package tads;

public class MaxHeap implements Heap{
  
  private int[] arr;
  int totalElements = 0;

  private boolean hasLeftChild(int index){
    return index*2 < arr.length;
  }
  private boolean hasRightChild(int index){
    return index*2+1 < arr.length;
  }

  private int getRightChild(int index){
    return arr[index*2+1];
  }

  private void doSink(int i, int elements){
    int index = i;

    while(hasLeftChild(index) && 2*index < elements){ //if not, theres not right child either.
      int biggestChildIndex = 2*index;
      
      if(hasRightChild(index) && getRightChild(index) > arr[biggestChildIndex])
        biggestChildIndex = 2*index+1;
      
      if(arr[index] < arr[biggestChildIndex]) 
        swap(index, biggestChildIndex);

      index = biggestChildIndex;
    }
  }

  private void swap(int index1, int index2){
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
  
  @Override
  public void heapify(int[] arr) {
    this.totalElements = arr.length-1;
    this.arr = arr;
    int index = Math.floorDiv(arr.length, 2);
    for(int i = index; i > 0; i--) doSink(i, this.totalElements);
  }

  public void heapSort(){
    for(int i = arr.length-1; i > 0; i--) pop();
  }

  private void pop(){
    swap(1, this.totalElements);
    this.totalElements--;
    doSink(1, this.totalElements);
  }  
}