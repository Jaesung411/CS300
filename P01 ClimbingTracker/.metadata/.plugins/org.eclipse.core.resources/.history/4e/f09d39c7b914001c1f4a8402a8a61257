
public class practice {
	private static int levelSize = 0;
	public static int helper(String[] t, int num, String grade){
		if (num == t.length) {
			return num;
		}
		for(int i = 0; i < num; i++) {
			t[num+levelSize-1-i] = grade;
		}
		levelSize = levelSize + num;
		++num;
		return num;
	}
	
	public static int sendClimb(String[] send, int numSend, String grade){
		return helper(send, numSend, grade);
		}
	public static int failClimb(String[] fail, int numFail, String grade) {
		return helper(fail, numFail, grade);
	}
	
	public static String getStats(String[] send, int numSend, String[] fail, int numFail, int historyLength) {
		double sum =0.0;
		for(int i = numSend-1; i > numSend-historyLength-1 ; i--) {
			int temp = Integer.parseInt(send[i].substring(1));
			sum += temp;
		}
		double av = sum/historyLength;
		return "Send: "+ av;
	
	}
	public static void main(String[] args) {
		final int LEVELS_CAPACITY = 5;
		String[] level = new String[LEVELS_CAPACITY];
		String[] lev = new String[LEVELS_CAPACITY];
		
		sendClimb(level, 1, "V0");
		sendClimb(level, 1, "V1");
		sendClimb(level, 2, "V0");
		printOversizeArray(level,5);
		System.out.println(getStats(level, levelSize, lev , levelSize, 3));
		
		levelSize =0;
		
		failClimb(lev, 1, "V0");
		failClimb(lev, 2, "V1");
		failClimb(lev, 2, "V0");
		OversizeArray(lev,5);
		
		
		
	}
	public static void printOversizeArray(String[ ]arrayRef, int arraySize) {
		int index;
		
		System.out.print("[");
		for(index=0; index < arraySize; ++index){
			System.out.print(arrayRef[index]);
			if(index != arraySize) {
				System.out.print(",");
			}
		}
		System.out.print("]  ");
		System.out.println("numSend: "+ levelSize);
	}
	public static void OversizeArray(String[ ]arrayRef, int arraySize) {
		int index;
		
		System.out.print("[");
		for(index=0; index < arraySize; ++index){
			System.out.print(arrayRef[index]);
			if(index != arraySize) {
				System.out.print(",");
			}
		}
		System.out.print("]  ");
		System.out.println("numFail: "+ levelSize);
	}
}



