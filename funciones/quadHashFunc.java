package funciones;

public class quadHashFunc implements HashFunc {

  @Override
  public int hash(String data) {
    int hashValue = 0;
    for(char elem : data.toCharArray()) hashValue += elem*elem;
    return hashValue;
  }
  
}
