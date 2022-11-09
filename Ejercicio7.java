import java.util.Scanner;
public class Ejercicio7{
public static void main(String[] args) {
    int suma1=0;
    int suma2=0;
    int suma3=0;
    Scanner myScanner = new Scanner(System.in);
    //int apaaa=Integer.parseInt(myScanner.nextLine());
    int length1 = Integer.parseInt(myScanner.nextLine());
    int[] arr1 = new int[length1];
    for (int i = 0; i < arr1.length; i++) {
        arr1[i] = Integer.parseInt(myScanner.nextLine());
        suma1=suma1+arr1[i];
    }
    int length2 = Integer.parseInt(myScanner.nextLine());
    int[] arr2 = new int[length2];
    for (int i = 0; i < arr2.length; i++) {
        arr2[i] = Integer.parseInt(myScanner.nextLine());
        suma2=suma2+arr2[i];
    }    
    int length3 = Integer.parseInt(myScanner.nextLine());
    int[] arr3 = new int[length3];
    for (int i = 0; i < arr3.length; i++) {
        arr3[i] = Integer.parseInt(myScanner.nextLine());
        suma3=suma3+arr3[i];
    }
    myScanner.close();
    greedy(arr1,arr2,arr3,suma1,suma2,suma3);
}

public static void greedy(int[] arr1,int []arr2,int []arr3,int suma1,int suma2,int suma3){
    int cont1=0;
    int cont2=0;
    int cont3=0;
    int ret=0;
    while(suma1!=0 && suma2!=0 &&suma3!=0){
        if(suma1==suma2&&suma2==suma3 && suma1>=ret){
            ret=suma1;
        }
        int maximo=max(max(suma1,suma2),suma3);
        if(maximo==suma1){
            suma1=suma1-arr1[cont1];
            cont1++;
        }
        if(maximo==suma2){
            suma2=suma2-arr2[cont2];
            cont2++;
        }
        if(maximo==suma3){
            suma3=suma3-arr3[cont3];
            cont3++;
        }
    }
    System.out.println(ret);
}

public static int max(int x,int y){
    if(x>y)return x;
    return y;
}

}
