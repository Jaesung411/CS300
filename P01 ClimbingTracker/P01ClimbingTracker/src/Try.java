
//public class Try {
//
//	public static boolean testTotal() {
//		String items = new String[] {"apples","banana"};
//		int[] num = new int[] {5,5};
//		double[] prices = new double[] {1.0,1.0};
//		double expected =10;
//		if(otherClass.getTotal(items,num,prices) == expected) {
//			System.out.println("faliled test1");
//			return false;
//		}
//		
//		double[] otherPrices = new double[] {0.5,0.5};
//		double expected2 =10;
//		if(otherClass.getTotal(items,num,prices) == expected) {
//			return false;
//		}
//		
//	}
//}
public class Try {

    public static int helper(String[] t, int num, String grade){
//        if (num == t.length) {        //크기 초과시 감지 못하고 어레이 인덱스 오류
//            return num;
//        }
    	int levelSize = 0;
        if(num + levelSize > t.length)      //배열 크기 초과시 리턴
            return num;

        for(int i = 0; i < num; i++) {
            t[num+levelSize-1-i] = grade;
        }
        levelSize = levelSize + num;
        ++num;
        return num;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    //기존에 역순으로 찾아가는 방법보다 가독성이 좋음, 위치 저장 후 앞에서부터 순서대로 채워나가는 방법
    private static int pivot = 0;
    public static int helper_ex(String[] t, int num, String grade){
        if(num + pivot > t.length)
            return num;

        for(int i=0; i<num+pivot; i++)
            t[i] = grade;

        pivot = pivot + num;
        return pivot;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public static int sendClimb(String[] send, int numSend, String grade) { return helper(send, numSend, grade); }
    public static int failClimb(String[] fail, int numFail, String grade) { return helper(fail, numFail, grade); }

    public static String getStats(String[] send, int numSend, String[] fail, int numFail, int historyLength) {
        double sum1 =0.0;
        double sum2 =0.0;

        int n = 0, m = 0;

        // historyLength가 numSend나 numFail보다 크면 historyLength를 쓰지말고, numSend나, numFail 값을 쓰라고했어서 그부분을 해준거임

        // 변수를 하나 더 만들어서 만약 n에 historyLength임가 numSend값보가 크면 n에 numSend값을 넣어주고 그게 아니면 n 에 historyLength값을 넣어준거
        if(historyLength > numSend){
            n = numSend;
        }else{
            n = historyLength;
        }

        if(historyLength > numFail){
            m = numFail;
        }else{
            m = historyLength;
        }

        for(int i = numSend-1; i > numSend-n-1 ; i--) {
            int temp1 = Integer.parseInt(send[i].substring(1));
            sum1 = sum1 + temp1;

        }
        for(int i = numFail-1; i > numFail-m-1 ; i--) {
            int temp2 = Integer.parseInt(fail[i].substring(1));
            sum2 = sum2 + temp2;


        }
        double av1 = sum1/n;
        double av2 = sum2/m;
        if(numSend==0) {
            return "Send: --" +"\n"+"Fail: " +av2;
        }
        if(numFail==0) {
            return "Send: "+ av1 +"\n"+"Fail: --";
        }
        if(historyLength <= 0) {
            return "Send: --" +"\n"+"Fail: --";
        }
        return "Send: "+ av1 +"\n"+"Fail: " +av2;


    }

    public static String getHistogram(String[] send,int numSend, String[] fail, int numFail) {

        if(numSend == 0 && numFail == 0){           //기록이 없을 경우
            String error = "Error: no data to display";
            return error;
        }

        int sum = 1;
        String temp = "";
        for(int i = 0; i < numSend; i++) {
            temp = send[i];

            for(int j = i+1; j < numSend - i; j++) {
                if ( send[i]==send[j] ) {
                    sum += 1 ;
                }
            }

        }
        while(sum>0) {
            temp += "+";
            sum--;
        }
        return temp;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
//    public static String getHistogram_ex(String[] send, int numSend, String[] fail, int numFail){
//
//        if(numSend == 0 && numFail == 0){           //기록이 없을 경우
//            String error = "Error: no data to display";
//            return error;
//        }
//
//        int max_practice = Integer.MIN_VALUE;
//        ArrayList<ArrayList<Character>> tryset = new ArrayList<>();
//        for(int i=0; i<8; i++)
//            tryset.add(new ArrayList<>());              //시도 결과를 담을 2차원 리스트
//
//        StringBuilder sb = new StringBuilder();         //결과를 담을 문자열
//
//        //성공 전에 실패가 있다면 먼저 기록되므로, 실패 배열 먼저 탐색
//        for(int i=0; i<numFail; i++){
//            char level = fail[i].charAt(1);
//            int Level = level - '0';        //'V0'에서 0만 추출
//            tryset.get(Level).add('-');     //해당 레벨에 실패기록 추가
//
//            max_practice = Math.max(max_practice, Level);       //기록된 최고레벨 이하의 기록들은 모두 출력해야하므로, 최고레벨 저장
//        }
//
//        //성공 배열 탐색
//        for(int i=0; i<numSend; i++){
//            char level = send[i].charAt(1);
//            int Level = level - '0';
//            tryset.get(Level).add('+');
//
//            max_practice = Math.max(max_practice, Level);
//        }
//
//        //기록된 최고레벨까지 출력값 정리, 하위 레벨에 기록이 없어도 출력해야함
//        for(int i=0; i<=max_practice; i++){
//            sb.append("V" + i + ": ");
//            for(int j=0; j<tryset.get(i).size(); j++){
//                sb.append(tryset.get(i).get(j) + " ");
//            }
//            sb.append("\n");
//        }
//
//        return sb.toString();
//    }
    /////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        final int LEVELS_CAPACITY = 6;
        int numSend = 0;
        int numFail = 0;
        String[] level = new String[LEVELS_CAPACITY];

        String[] lev = new String[LEVELS_CAPACITY];


        sendClimb(level, 1, "V0");
        sendClimb(level, 1, "V1");
        sendClimb(level, 2, "V0");
        sendClimb(level, 2, "V0");
        printOversizeArray(level, 6);
        levelSize =0;

        failClimb(lev, 1, "V2");
        failClimb(lev, 1, "V1");
        failClimb(lev, 2, "V2");
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
        System.out.println(getStats(level, numSend, lev , numFail, 2));
//        System.out.println(getHistogram_ex(level, numSend, lev , numFail));


    }

    //출력 다듬었음
    public static void printOversizeArray(String[ ]arrayRef, int arraySize) {
        int index;

        System.out.print("send: {");
        for(index=0; index < arraySize; ++index){
            System.out.print(arrayRef[index]);
            if(index != arraySize) {
                if(index != arraySize-1)
                    System.out.print(",");
            }
        }
        System.out.print("}");
        System.out.println(", numSend: "+ levelSize);
    }

    //출력 다듬었음
    public static void overSizeArray(String[ ]arrayRef, int arraySize) {
        int index;

        System.out.print("fail: {");
        for(index=0; index < arraySize; ++index){
            System.out.print(arrayRef[index]);
            if(index != arraySize) {
                if(index != arraySize-1)
                    System.out.print(",");
            }
        }
        System.out.print("}");
        System.out.println(", numFail: "+ levelSize);
    }
}

	

		
		
		
		
		


