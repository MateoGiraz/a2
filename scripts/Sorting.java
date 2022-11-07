package scripts;

public class Sorting{
  public static void main(String[] args) {
    int[] arr = {5,4,8,123,3,5,2,6,8,5,3,5,2,5,7,4,132,543,234,74,143,534,654,234};
    mergeSort(arr, 0, arr.length-1);
    for(int elem : arr){
        System.out.println(elem);
    }
}

public static void mergeSort(int[] arr, int start, int end){
    if(start == end) return;
    int mid=(start+end)/2;
    mergeSort(arr,start,mid);
    mergeSort(arr,mid+1,end);
    merge(arr,start,mid,end);
}

public static void merge(int[]arr,int start,int mid,int end){
    int size1 = mid - start + 1;
    int size2 = end - mid;

    int[] left = new int[size1];
    int[] right = new int[size2];
    
    for(int i = 0; i < size1; i++) left[i] = arr[i + start]; 
    for(int i = 0; i < size2; i++) right[i] = arr[mid + i + 1];
    
    int i = 0, j = 0;
    int index = start;

    while(i < size1 && j < size2){
        if(left[i] <= right[j]){
            arr[index] = left[i];
            i++;
        }else{
            arr[index] = right[j];
            j++;
        }
        index++;
    }


}
}