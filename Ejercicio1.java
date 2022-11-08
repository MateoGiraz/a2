import java.util.Scanner;
import tads.ClosedHash;
import tads.Hash;
import funciones.*;

public class Ejercicio1 {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int numOfElements = myScanner.nextInt();

    HashFunc h1 = new cubeHashFunc();
    HashFunc h2 = new quadHashFunc();

    Hash myClosedHash = new ClosedHash(numOfElements, h1, h2);

    int diff = 0;

    for (int i = 0; i < numOfElements; i++) {
      String elem = myScanner.nextLine();
      if(myClosedHash.insert(elem)) diff++;
    }

    System.out.println(diff);
    myScanner.close();

  }
}
