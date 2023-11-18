//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Benchmarking Hacks
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
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * A class creating PasswordHackers, timing those two approaches and comparing
 * them
 * 
 * @author Jaesung Lim
 */
public class Benchmarker {

	/**
	 * record the time before and after calling the PasswordHacker's bruteForce
	 * method
	 * 
	 * @param ph the PasswordHacker object
	 * @return the elapsed time in millseconds
	 */
	public static long timeBruteForce(PasswordHacker ph) {

		// time the starting
		long beforeTime = System.currentTimeMillis();

		// execute the method I measure
		ph.bruteForce();

		// time the ending
		long afterTime = System.currentTimeMillis();

		return afterTime - beforeTime;
	}

	/**
	 * record the time before and after calling the PasswordHacker's hack method
	 * 
	 * @param ph the PasswordHacker object
	 * @return the elapsed time in millseconds
	 */
	public static long timeHack(PasswordHacker ph) {

		// time the starting
		long beforeTime = System.currentTimeMillis();

		// execute the method I measure
		ph.hack();

		// time the ending
		long afterTime = System.currentTimeMillis();

		return afterTime - beforeTime;
	}

	/**
	 * print the results of this time of hacking
	 * 
	 * @param passwordLength the length of password
	 * @param numRuns        the number of hacking
	 * @return the results of this race as a String
	 */
	public static String race(int passwordLength, int numRuns) {
		long totalBruteTime = 0;// the total time when the BruteTime method is executed
		long totalHackTime = 0;// the total time when the Hack method is executed
		long averageBruteTime = 0; // the average time when the BruteTime method is executed
		long averageHackTime = 0;// the average time when the Hack method is executed

		// add all the time while the BruteTime method is executed
		for (int i = 0; i < numRuns; i++) {
			PasswordHacker caseBruteForce = new PasswordHacker(passwordLength);
			totalBruteTime += timeBruteForce(caseBruteForce);
		}

		// add all the time while the Hack method is executed
		for (int i = 0; i < numRuns; i++) {
			PasswordHacker caseHack = new PasswordHacker(passwordLength);
			totalHackTime += timeHack(caseHack);
		}
		
		//calculate the average of the time
		averageBruteTime = totalBruteTime / numRuns;
		averageHackTime = totalHackTime / numRuns;
		
		return "Brute force " + passwordLength + ": " + averageBruteTime + "\nHack " + passwordLength + ": "
				+ averageHackTime;
	}

	public static void main(String[] args) {
	
	}

}
