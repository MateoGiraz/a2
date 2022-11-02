package tads;

public class PQHeap implements PriorityQueue<Edge> {
    private MinHeap heap;    
    public PQHeap(int expextedSize){
        this.heap=new MinHeap(expextedSize);
    }

    @Override
    public Edge pop() {
        return heap.pop();           
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public void push(Edge data) {
        heap.insert(data);
    }
    
}