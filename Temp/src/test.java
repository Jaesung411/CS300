import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class test {
	public static void main(String[] args) {
		int[] ma = new int[] {1,2,3};
		test test = new test();
		test.change(ma);
		System.out.println(Arrays.toString(ma));
	}
	public void change(int[] your) {
		int[] my = new int[] {0, 0, 0};
		your =my;
	}
}
