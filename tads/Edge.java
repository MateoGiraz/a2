package tads;

public class Edge {
  public int vDest;
  public int weight;

  public Edge(int v, int w){
    vDest = v;
    weight = w;
  }
  @Override
  public boolean equals(Object o){
    Edge other = (Edge) o;
    return this.vDest == other.vDest;
  }
}