import java.util.zip.DataFormatException;

////////////////FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
//Title:    (descriptive title of the program making use of this file)
//Course:   CS 300 Fall 2021
//
//Author:   Jaesung Lim	
//Email:    jlim83@wisc.edu
//Lecturer: Hobbes LeGault
//
////////////////////PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//Partner Name:    (name of your pair programming partner)
//Partner Email:   (email address of your programming partner)
//Partner Lecturer's Name: (name of your partner's lecturer)
//
//VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//_x_ Write-up states that pair programming is allowed for this assignment.
//_x_ We have both read and understand the course Pair Programming Policy.
//_x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
//Persons:         (identify each by name and describe how they helped)
//Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A version of the tester for the ClimbingTracker if it uses exceptions for
 * error handling
 * 
 * @author Jaesung
 */
public class ExceptionalClimbingTester {

	/**
	 * this method check if sendClimb works well
	 * 
	 * @return true when it works well
	 */
	public static boolean testSendClimb() {

		// scenarios1
		// Valid input causes no exception
		int size = 5;
		String[] array = new String[size];
		try {
			ExceptionalClimbing.sendClimb(array, 0, "V0");
			ExceptionalClimbing.sendClimb(array, 1, "V0");

			// check if there is DataFormatException
			// the exception is checked exception and I throws it in the sendClimb method
			// and the message is checked if it is right or not
			// if it is wrong, return false
		} catch (DataFormatException dfe) {
			String message = dfe.getMessage();
			if (!message.contains("invalid oversize array"))
				return false;
			System.out.println(message);
			// check all exceptions for any unexpected exception
		} catch (Exception e) {
			return false;
		}

		// scenarios2
		// Invalid grade causes IllegalArgument
		size = 2;
		array = new String[size];
		try {
			ExceptionalClimbing.sendClimb(array, 0, "V8");

			// V8 is Invalid grade, so it is caught here
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!message.contains("V8 is not a valid grade"))
				return false;
			System.out.println(message);
		} catch (DataFormatException dfe) {
			String message = dfe.getMessage();
			if (!message.contains("invalid oversize array"))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}

		// scenarios3
		// full array causes IllegalArgumentException
		int size1 = 1;
		String[] array1 = new String[size1];
		int[] num1 = new int[] { 0, 1 };
		String[] grade1 = new String[] { "V3", "V1" };
		try {
			for (int i = 0; i < grade1.length; i++) {

				ExceptionalClimbing.sendClimb(array1, num1[i], grade1[i]);
			}
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!message.contains("cannot add new value to full length 1 array"))
				return false;
			System.out.println(message);
			// IllegalArgumentException is caught here
		} catch (DataFormatException dfe) {
			String message = dfe.getMessage();
			if (!message.contains("invalid oversize array"))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}

		// scenarios4
		// array with null elements or invalid size causes DataFormatException
		int size2 = 6;
		String[] array2 = new String[size2];
		int[] num2 = new int[] { 0, 1, 2, 5 };
		String[] grade2 = new String[] { "V2", "V4", "V5", "V2" };

		try {
			for (int i = 0; i < grade2.length; i++) {
				ExceptionalClimbing.sendClimb(array2, num2[i], grade2[i]);
			}
			// DataFormatException is caught here
		} catch (DataFormatException dfe) {
			String message = dfe.getMessage();
			if (!message.contains("invalid oversize array"))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}

		// scenarios5
		// Combinations of these error conditions
		int size3 = 3;
		String[] array3 = new String[size3];
		int[] num3 = new int[] { 0, 1, 2, 5 };
		String[] grade3 = new String[] { "V1", "C2", "V5", "V2" };

		try {
			for (int i = 0; i < grade3.length; i++) {
				ExceptionalClimbing.sendClimb(array3, num3[i], grade3[i]);
			}
		} catch (DataFormatException dfe) {
			String message = dfe.getMessage();
			if (!message.contains("invalid oversize array"))
				return false;
			System.out.println(message);
			// first listed applicable exception, IllegalArgumentException, is caught here
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!(message.contains("cannot add new value to full length 2 array")
					|| message.contains("C2 is not a valid grade")))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}
		System.out.println("");
		return true;
	}

	/**
	 * this method check if getStats() works well
	 * 
	 * @return true when it works well
	 */
	public static boolean testGetStats() {

		// scenarios 1
		// valid input causes no exceptions
		int statsSendSize1 = 3;
		String[] statsSendArray1 = new String[statsSendSize1];
		int[] statsSendNum1 = new int[] { 0, 1, 2 };
		String[] statsSendGrade1 = new String[] { "V2", "V4", "V5" };
		for (int i = 0; i < statsSendGrade1.length; i++) {
			try {
				ExceptionalClimbing.sendClimb(statsSendArray1, statsSendNum1[i], statsSendGrade1[i]);
			} catch (DataFormatException dfe) {
				String message = dfe.getMessage();
				if (!message.contains("invalid oversize array"))
					return false;
				System.out.println(message);
			} catch (Exception e) {
				return false;
			}
		}
		int statsFailSize1 = 3;
		String[] statsFailArray1 = new String[statsFailSize1];
		int[] statsFailNum1 = new int[] { 0, 1, 2 };
		String[] statsFailGrade1 = new String[] { "V1", "V1", "V2" };
		for (int i = 0; i < statsFailGrade1.length; i++) {
			try {
				ExceptionalClimbing.failClimb(statsFailArray1, statsFailNum1[i], statsFailGrade1[i]);
			} catch (DataFormatException dfe) {
				String message = dfe.getMessage();
				if (!message.contains("invalid oversize array"))
					return false;
				System.out.println(message);
			} catch (Exception e) {
				return false;
			}
		}

		try {
			ExceptionalClimbing.getStats(statsSendArray1, statsSendSize1, statsFailArray1, statsFailSize1, 2);
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!(message.contains("2 is not a valid history")))
				return false;
			System.out.println(message);
		} catch (RuntimeException re) {
			String message = re.getMessage();
			if (!(message.contains("no climbs provided")))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}

		// scenarios 2
		// both arrays empty causes RuntimeException
		int statsSendSize2 = 0;
		String[] statsSendArray2 = new String[statsSendSize2];
		int statsFailSize2 = 0;
		String[] statsFailArray2 = new String[statsSendSize2];
		try {
			ExceptionalClimbing.getStats(statsSendArray2, statsSendSize2, statsFailArray2, statsFailSize2, 2);
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!(message.contains("2 is not a valid history")))
				return false;
			System.out.println(message);
			// RuntimeException is caught here
		} catch (RuntimeException re) {
			String message = re.getMessage();
			if (!(message.contains("no climbs provided")))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}

		// scenarios 3
		// negative or 0 historyLength causes IllegalArgumentException
		try {
			ExceptionalClimbing.getStats(statsSendArray1, statsSendSize1, statsFailArray1, statsFailSize1, -1);
			// IllegalArgumentException is caught here
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!(message.contains("-1 is not a valid history")))
				return false;
			System.out.println(message);
		} catch (RuntimeException re) {
			String message = re.getMessage();
			if (!(message.contains("no climbs provided")))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}
		// scenarios 4
		// combinations of these error conditions
		try {
			ExceptionalClimbing.getStats(statsSendArray2, statsSendSize2, statsFailArray2, statsFailSize2, -1);
		} catch (IllegalArgumentException iae) {
			String message = iae.getMessage();
			if (!(message.contains("-1 is not a valid history")))
				return false;
			System.out.println(message);
			//// first listed applicable exception, RuntimeException, is caught here
		} catch (RuntimeException re) {
			String message = re.getMessage();
			if (!(message.contains("no climbs provided")))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}
		System.out.println("");
		return true;
	}

	/**
	 * this method check if getHistogram() works well
	 * 
	 * @return true when it works well
	 */
	public static boolean testGetHistogram() {

		// scenario 1
		// valid input causes no exceptions
		int statsSendSize1 = 3;
		String[] statsSendArray1 = new String[statsSendSize1];
		int[] statsSendNum1 = new int[] { 0, 1, 2 };
		String[] statsSendGrade1 = new String[] { "V2", "V4", "V5" };
		for (int i = 0; i < statsSendGrade1.length; i++) {
			try {
				ExceptionalClimbing.sendClimb(statsSendArray1, statsSendNum1[i], statsSendGrade1[i]);
			} catch (DataFormatException dfe) {
				String message = dfe.getMessage();
				if (!message.contains("invalid oversize array"))
					return false;
				System.out.println(message);
			} catch (Exception e) {
				return false;
			}
		}
		int statsFailSize1 = 3;
		String[] statsFailArray1 = new String[statsFailSize1];
		int[] statsFailNum1 = new int[] { 0, 1, 2 };
		String[] statsFailGrade1 = new String[] { "V1", "V1", "V2" };
		for (int i = 0; i < statsFailGrade1.length; i++) {
			try {
				ExceptionalClimbing.sendClimb(statsFailArray1, statsFailNum1[i], statsFailGrade1[i]);
			} catch (DataFormatException dfe) {
				String message = dfe.getMessage();
				if (!message.contains("invalid oversize array"))
					return false;
				System.out.println(message);
			} catch (Exception e) {
				return false;
			}
		}

		try {
			ExceptionalClimbing.getHistogram(statsSendArray1, statsSendSize1, statsFailArray1, statsFailSize1);
		} catch (RuntimeException re) {
			String message = re.getMessage();
			if (!(message.contains("no climbs provided")))
				return false;
			System.out.println(message);
		}

		// scenario 2
		// both arrays empty causes RuntimeException
		int statsSendSize2 = 0;
		String[] statsSendArray2 = new String[statsSendSize2];
		int statsFailSize2 = 0;
		String[] statsFailArray2 = new String[statsSendSize2];

		try {
			ExceptionalClimbing.getHistogram(statsSendArray2, statsSendSize2, statsFailArray2, statsFailSize2);
			// RuntimeException is caught here
		} catch (RuntimeException re) {
			String message = re.getMessage();
			if (!(message.contains("no climbs provided")))
				return false;
			System.out.println(message);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * this method check all of the three methods work well
	 * 
	 * @return true when they work well
	 */
	public static boolean runAllTests() {
		
		//check whether all the tests 
		if (!(testSendClimb() == true)) {
			System.out.println("Failed Fail/Climb()");
			return false;
		}
		if (!(testGetStats() == true)) {
			System.out.println("Failed testGetStats()");
			return false;
		}
		if (!(testGetHistogram() == true)) {
			System.out.println("Failed testGetHistogram()");
			return false;
		}

		return true;
	}

	/**
	 * this method call the result of the runAllTests() method
	 */
	public static void main(String[] args) {

		System.out.print(runAllTests());

	}
}
