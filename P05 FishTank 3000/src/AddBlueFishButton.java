//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P05 FishTank 3000
// Course:   CS 300 Fall 2021
//
// Author:   Jaesung Lim	
// Email:    jlim83@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Kyungmin Park
// Partner Email:   kpark253@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
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
 * A class representing a button written "Add Blue" in the tank, and inherit
 * Button
 * 
 * @author Jaesung Lim, Kyungmin Park
 */
public class AddBlueFishButton extends Button {

	/**
	 * constructor initializing a button with position
	 * 
	 * @param x the x-component of the button
	 * @param y the y-component of the button
	 */
	public AddBlueFishButton(float x, float y) {
		super("Add Blue", x, y);
	}

	/**
	 * add the blue fish in the objects arraylist when pressing the button
	 */
	@Override
	public void mousePressed() {
		tank.objects.add(new BlueFish());

	}

}
