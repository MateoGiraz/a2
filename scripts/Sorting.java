package scripts;

public class Sorting{
  public static void main(String[] args) {
    int[] array = {1, 2, 6, 7, 2, 6, 8, 3, 4, 5, 7};
    int[] arr = mergeSort(array, 0, 10);
    System.out.println(arr);
  }

  public static int[] mergeSort(int [] arr,int inicio, int fin){
    int medio=(inicio+fin)/2;
    int largo=fin-inicio+1;
    if(largo!=1){
    mergeSort(arr,inicio,medio);
    mergeSort(arr,medio+1,fin);
    }
    return merge(arr,inicio,medio,fin);

}

public static int[] merge(int[]arr,int inicio,int medio,int fin){
    int [] ret= new int[fin-inicio+1];
    int aux=inicio;
    int aux2=medio;
    for (int i = 0; i < ret.length && aux<=medio && aux2<=fin; i++) {
        if(arr[aux]<arr[aux2]){
            ret[i]=aux;
            aux++;
        }
        else if(arr[aux]>=arr[aux2]){
            ret[i]=aux2;
            aux2++;
        }
    }
    return ret;

}
}