import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Test {

	  public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		a.add("3");
		String b = a.remove(0);
		System.out.print(b);
		System.out.print(a);
	  }
}
