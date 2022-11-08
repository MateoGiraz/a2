package tads;
public class Pair {
  public int nodeNum;
  public int totalIncidence;
  public Pair(int v){
    nodeNum = v;
    totalIncidence = 0;
  }
  public Pair(int v, int w){
    nodeNum = v;
    totalIncidence = w;
  }
}
