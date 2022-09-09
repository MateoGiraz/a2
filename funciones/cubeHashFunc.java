package funciones;

public class cubeHashFunc implements HashFunc{

  @Override
  public int hash(String data) {
    int hashValue = 0;
    int auxVal = 3;
    for(char elem : data.toCharArray()) {
      hashValue += elem * auxVal;
      auxVal = (int)Math.pow(auxVal, 3);
    }
    return hashValue;
  }
  
}
