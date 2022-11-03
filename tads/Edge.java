package tads;

public class Edge {
  public int vOrigen;
  public int vDest;
  public int weight;

  public Edge(int v, int w,int x){
    vOrigen=v;
    vDest = w;
    weight = x;
  }
  @Override
  public boolean equals(Object o){
    Edge other = (Edge) o;
    return this.vDest == other.vDest;
  }
}