import java.util.ArrayList;

public class Test {
	public static void doesItWork(int[] incoming) {
		  int[] workingCopy = incoming;
		  int len = incoming.length;
		  int tmp;
		  for(int i=0; i<len/2; i++) {
		    tmp = workingCopy[i];
		    workingCopy[i] = workingCopy[len - i - 1];
		    workingCopy[len - i - 1] = tmp;
		  }
		} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[4];
				for( int i = 0; i <4 ; i++) {
					x[i] = i;
				}
		doesItWork[x];
	}

}
