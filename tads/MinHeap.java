package tads;

public class MinHeap implements EdgeHeap{
    private Edge [] arr;
    private int elements;
    private int maxElements;
    
    public MinHeap(int max){
        this.maxElements=max;
        this.elements=0;
        this.arr=new Edge [max+1];
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public Edge top() {
        return arr[1];
    }

    @Override
    public void insert(Edge data) {
        if(elements!=maxElements){
            elements++;
            arr[elements]=data;
            int aux=elements;
            while(arr[aux].weight<arr[getParent(aux)].weight){
                swap(aux,getParent(aux));
                aux=getParent(aux);
            }
        }        
    }
    private void swap(int index1, int index2){
        Edge temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
      }

    @Override
    public Edge pop() {
        Edge ret=arr[1];
        swap(1,this.elements);
        this.elements--;
        doSink(1,this.elements);
        return ret;
        
        
    }

    private void doSink(int i, int elements){
        int index = i;
    
        while(hasLeftChild(index) && 2*index < elements){ //if not, theres not right child either.
          int smallestChildIndex = 2*index;
          
          if(hasRightChild(index) && getRightChild(index).weight < arr[smallestChildIndex].weight)
            smallestChildIndex = 2*index+1;
          
          if(arr[index].weight > arr[smallestChildIndex].weight) 
            swap(index, smallestChildIndex);
    
          index = smallestChildIndex;
        }
      }
    

    @Override
    public void heapify(Edge[] arr) {
    }

    @Override
    public boolean isFull() {
        return elements==maxElements;
    }

    @Override
    public boolean isEmpty() {
        return elements==0;
    }


        //Auxiliares

        private int getParent(int pos){
            return (pos-1)/2;
        }
    
        private boolean hasLeftChild(int pos){
            return pos*2 < arr.length;
        }
        
        private boolean hasRightChild(int pos){
            return pos*2+1 < arr.length;
        }
        
        private Edge getRightChild(int pos){
            return arr[pos*2+1];
        }
    
        private Edge getLeftChild(int pos){
            return arr[pos*2];
        }
    
        private boolean isLeaf(int pos)
        {
            if (pos > (elements/2) && pos <= elements) {
                return true;
            }
            return false;
        }
}