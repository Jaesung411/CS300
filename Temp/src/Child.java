
public class Child extends Parent {
  
  public int age;
  
 public Child() {
	 System.out.println("1");
 }
  public Child(int i, int n) {
//	  super(i,n);
  }
  
  @Override
  public void somethingElse(int x) {
    System.out.println("hi");
  }
}
