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
 * A class hacking with the LockBok
 * 
 * @author Jaesung Lim
 */
public class PasswordHacker {

	private LockBox toPick; // LockBox object
	private int passwordLength; // the length of password

	/**
	 * set the LockBox object and set the length of password
	 * 
	 * @param passwordLength the length of password
	 */
	public PasswordHacker(int passwordLength) {
		this.passwordLength = passwordLength;
		toPick = new LockBox(passwordLength);
	}

	/**
	 * compare the stored password with the password by the method hackMe
	 */
	/** Complexity: O(1) */
	public void hack() {
		toPick.reset(); // before starting hacking, reset the box
		toPick.authenticate(toPick.hackMe());
	}

	/**
	 * find the stored password by comparing with every numbers
	 */
	/** Complexity: O(10^N) */
	public void bruteForce() {
		toPick.reset(); // before starting hacking, reset the box
		int numGuess = 0; // the number of times I guess and the password I guess
		// check guess against the stored password until the Lock box opens
		while (toPick.isOpen() == false) {
			toPick.authenticate(generateGuess(numGuess));
			numGuess++;
		}
	}

	/**
	 * produce the password
	 * 
	 * @param count the number of times I've guessed a password
	 * @return String password I've guessed
	 */
	public String generateGuess(int count) {

		String guess = count + ""; // a password I guess change into String

		// set a number I guess for the type of password
		if (guess.length() > passwordLength) {
			guess = guess.substring(guess.length() - passwordLength);
		} else {
			for (int i = guess.length(); i < passwordLength; i++) {
				guess = "0" + guess;
			}
		}

		return guess;

	}

}
