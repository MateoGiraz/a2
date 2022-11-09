import java.util.Scanner;
public class Ejercicio6{
public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int length = Integer.parseInt(myScanner.nextLine());
    int[] arr = new int[length];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = Integer.parseInt(myScanner.nextLine());
    }
    int res=solari(arr, 0, length-1);
    System.out.println(res);
    myScanner.close();
}

public static int solari(int[] arr,int inicio,int fin){
    int mid = (inicio+fin)/2;
    if(isTrivial(arr, mid)) return arr[mid];
    
    if(mid%2==0){
        if(arr[mid]==arr[mid+1]) return solari(arr,mid,fin);
        return solari(arr,inicio,mid);
    }
    
    if(arr[mid]==arr[mid+1]) return solari(arr,inicio,mid);
    return solari(arr,mid,fin);

}

public static boolean isTrivial(int[] arr, int mid){
    return (mid == arr.length && arr[mid] != arr[mid-1])
    ||(mid == 0 && arr[mid] != arr[mid+1])
    ||(arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1]);
}

}