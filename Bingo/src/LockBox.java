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
 * A class representing any kinds of fishes in the tank, and inherit FishTank
 * 
 * @author Jaesung Lim
 */
import java.util.Random;

public class LockBox {
	
	protected static Random randGen;
    private String password ="";
    private boolean isOpen;
    
    public LockBox(int passwordLength){
    	
    	//initialize the static random number generator
    	randGen = new Random();
		
    	//set exception if the length of password is negative or zero
    	if(passwordLength <= 0) {
    		throw new IllegalArgumentException("Invalid password length");
    	}else {
    		for(int i = 0; i < passwordLength; i++) {
    			this.password = randGen.nextInt(10) + password;
    		}
    	}
    }
    
    public void authenticate(String guess) {
    	
    	if(password.equals(guess)) {
    		this.isOpen = true;
    	}	
    }
    
    public String hackMe() { return password; }

    public boolean isOpen() { return isOpen; }
    
    public void reset() { isOpen = false; }
}