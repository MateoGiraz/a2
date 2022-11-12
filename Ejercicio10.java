import java.util.*;
public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
      int totalElems = Integer.parseInt(myScanner.nextLine());
      
      String[] arr = new String[totalElems];
      for(int i = 0; i < totalElems; i++){
        arr[i] = myScanner.nextLine();
      }
      for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length; j++) {
            String elem1=arr[i];
            String elem2=arr[j];
            if(greaterThan(elem1, elem2)){
                String aux=elem1;
                arr[i]=elem2;
                arr[j]=aux;
            }
        }
      }
      String ret="";
      for (int i = 0; i < arr.length; i++) {
        ret=ret+arr[i];
      }
      System.out.println(ret);
    }


    public static boolean greaterThan(String a,String b){
        int lengthA=a.length();
        int lengthB=b.length();
        int iter=0;
        while(lengthA>0 && lengthB>0){
             char charA=(a.charAt(iter));
             int numA=charA;
             char charB=(b.charAt(iter));
             int numB=charB;
            if(numA>numB){
                return true;
            }
            if(numA<numB){
                return false;
            }
            iter++;
            lengthA--;
            lengthB--;
        }
        if(lengthA==0){
            return true;
        }
        return false;
    }
}
