package tads;
 
class DisjointSet {
  int[] sets;
  int numOfElems;
 
  public DisjointSet(int n){
      sets = new int[n+1];
      numOfElems = n;
      for (int i = 0; i < n; i++) {
        sets[i] = i;
      }
  }

  public int find(int x){
    if(sets[x] == x) return x;
    return find(sets[x]);
  }
  
  public void join(int x, int y){
    int xRep = find(x);
    int yRep = find(y);
    sets[yRep] = xRep;
  }

}

