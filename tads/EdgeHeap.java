package tads;

public interface EdgeHeap {

    public int size();
    
    public Edge top();

    public void insert(Edge data);

    public Edge pop();

    public void heapify(Edge arr[]);

    public boolean isFull();

    public boolean isEmpty();

    
}
