package tads;

public interface EdgeList<Edge> {
  public int totalElements();
  public void addElement(Edge data);
  public void removeElement(Edge data);
  public Iterable<Edge> data();
}