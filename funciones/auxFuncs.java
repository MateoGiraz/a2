package scripts;

public class auxFuncs {
  public int[] initCostos(int origen, int v){
    int[] arr = new int[v+1];
    for(int i = 1; i < arr.length; i++){
      arr[i] = Integer.MAX_VALUE;
    }
    arr[origen] = 0;
    return arr;
  } 

  public boolean[] initVisitados(int v){
    boolean[] arr = new boolean[v+1];
    for(int i = 1; i < arr.length; i++){
      arr[i] = false;
    }
    return arr;
  }

  public int[] initAnterior(int v){
    int[] arr = new int[v+1];
    for(int i = 1; i < arr.length; i++){
      arr[i] = -1;
    }
    return arr;
  }


}
