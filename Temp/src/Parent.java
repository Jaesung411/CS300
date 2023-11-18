import java.util.Iterator;

public class Parent implements Iterator {

	public Parent() {System.out.println("시");}
	public Parent(int i, int n) {
		System.out.println("와");
	}
	
  public String name;
  private void add() {
	  System.out.print("1");
  }
  private int privateMethod() {
    return 5;
  }
  
  public void idk(String name) {
    this.name = name;
    //if (this instanceof Child) {
      this.somethingElse(5);
    //}
  }
  
  public void somethingElse(int y) {
    System.out.println("go away");
  }
@Override
public boolean hasNext() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public Object next() {
	// TODO Auto-generated method stub
	return null;
}
  
}
