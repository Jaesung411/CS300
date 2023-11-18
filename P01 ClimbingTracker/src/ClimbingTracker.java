//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P01 Climbing Tracker
// Course:   CS 300 Fall 2021
//
// Author:   Jaesung Lim	
// Email:    jlim83@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

public class ClimbingTracker {
	
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
	public static void main(String[] args) {
		final int LEVELS_CAPACITY = 5;
		String[] level = new String[LEVELS_CAPACITY];
		String[] lev = new String[LEVELS_CAPACITY];
		
		sendClimb(level, 1, "V0");
		sendClimb(level, 1, "V1");
		sendClimb(level, 2, "V0");
		
		levelSize =0;
		
		failClimb(lev, 1, "V0");
		failClimb(lev, 2, "V1");
		failClimb(lev, 2, "V0");
	}
	
	public static String getStats(String[] send, int numSend, String[] fail, int numFail, int historyLength) {
			double sum1 =0.0;
			double sum2 =0.0;

			int n = 0, m = 0;

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
				return "Send: --" +"\n"+"Fail:" +av2;
			}
			if(numFail==0) {
				return "Send: "+ av1 +"\n"+"Fail: --";
			}
			if(historyLength <= 0) {
				return "Send: --" +"\n"+"Fail: --";
			}
			return "Send: "+ av1 +"\n"+"Fail:" +av2;

			
		}
			
	public static String getHistogram(String[] send,int numSend, String[] fail, int numFail) {
		
	}
}
