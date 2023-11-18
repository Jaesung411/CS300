
public class Try {

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
	public static int sendClimb(String[] send, int numSend, String grade) {
		return helper(send, numSend, grade);
		
	}
	public static int failClimb(String[] fail, int numFail, String grade) {
		return helper(fail, numFail, grade);
	}
	
	public static String getStats(String[] send, int numSend, String[] fail, int numFail, int historyLength) {
	double sum1 =0.0;
	double sum2 =0.0;
	
	for(int i = numSend-1; i > numSend-historyLength-1 ; i--) {
		int temp1 = Integer.parseInt(send[i].substring(1));
		sum1 = sum1 + temp1;
		
	}
	for(int i = numFail-1; i > numFail-historyLength-1 ; i--) {
		int temp2 = Integer.parseInt(fail[i].substring(1));
		sum2 = sum2 + temp2;
		
		
	}
	double av1 = sum1/historyLength;
	double av2 = sum2/historyLength;
	return "Send: "+ av1 +"\n"+"Fail:" +av2;

	
}
	
	public static void main(String[] args) {
		final int LEVELS_CAPACITY = 6;
		int numSend = 0;
		int numFail = 0;
		String[] level = new String[LEVELS_CAPACITY];
		
		String[] lev = new String[LEVELS_CAPACITY];
	
		
		sendClimb(level, 1, "V0");
		sendClimb(level, 1, "V1");
		sendClimb(level, 2, "V0");
		printOversizeArray(level, 6);
		levelSize =0;
	
		failClimb(lev, 1, "V2");
		failClimb(lev, 1, "V1");
		overSizeArray(lev, 6);

		for(int i=0; i<level.length; i++) {
			if(level[i] == null) {
				break;
			}
			numSend++;
		}
		for(int i=0; i<lev.length; i++) {
			if(lev[i] == null) {
				break;
			}
			numFail++;
		}
		System.out.println(getStats(level, numSend, lev , numFail, 3));
		
		
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
	public static void overSizeArray(String[ ]arrayRef, int arraySize) {
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

	

		
		
		
		
		


