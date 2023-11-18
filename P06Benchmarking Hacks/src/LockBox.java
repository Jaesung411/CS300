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

import java.util.Random;

/**
 * A class setting a Lock box
 * 
 * @author Jaesung Lim
 */
public class LockBox {

	protected static Random randGen; // Random object for random password
	private String password = ""; // String object for making String type from int type
	private boolean isOpen; // boolean checking whether the lock box is opened or not

	/**
	 * a constructor initializing a lock box
	 * 
	 * @param passwordLength the length of password
	 */
	public LockBox(int passwordLength) {

		// initialize the static random number generator
		randGen = new Random();

		// throw an illegalArgumentException if the length of password is negative or
		// zero
		// generate a random password of numbers
		if (passwordLength <= 0) {
			throw new IllegalArgumentException("Invalid password length");
		} else {
			for (int i = 0; i < passwordLength; i++) {
				password = randGen.nextInt(10) + password;
			}
		}
	}

	/**
	 * check whether the stored password is compared with the password people guess
	 * 
	 * @param guess String people guess
	 */
	public void authenticate(String guess) {

		// check guess against the stored password
		if (password.equals(guess)) {
			// set the field isOpend to true
			this.isOpen = true;
		}
	}

	/**
	 * access the password of this Lock Box object
	 * 
	 * @return the stored password
	 */
	public String hackMe() {
		return password;
	}

	/**
	 * access the boolean isOpen
	 * 
	 * @return true if this Lock Box object is opened
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * reset the Open instance field to false
	 */
	public void reset() {
		isOpen = false;
	}
}
