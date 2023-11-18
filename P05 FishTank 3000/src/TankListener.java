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
 * A interface TankListener
 * 
 * @author Jaesung, Kyungmin Park
 */
public interface TankListener {

	// draws this tank object to the display window
	public void draw();

	// called each time the mouse is Pressed
	public void mousePressed();

	// called each time the mouse is Released
	public void mouseReleased();

	// checks whether the mouse is over this Tank GUI
	// return true if the mouse is over this tank GUI object, false otherwise
	public boolean isMouseOver();

}
