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
 * A class representing buttons in the tank, and interface TankListener
 * 
 * @author Jaesung, Kyungmin Park
 */
public class Button implements TankListener {

	private static final int WIDTH = 85; // Width of this Button
	private static final int HEIGHT = 32; // Height of this Button
	protected static FishTank tank; // PApplet object where this button will be displayed
	private float x; // x-position of this button in the display window
	private float y; // y-position of this button in the display window
	protected String label; // text/label which represents this button

	/**
	 * Creates a new Button at a given position within the display window and sets
	 * its label
	 * 
	 * @param label the label of a button
	 * @param x     the x-component of a button
	 * @param y     the y-component of a button
	 */
	public Button(String label, float x, float y) {
		this.label = label;
		this.x = x;
		this.y = y;
	}

	/**
	 * sets the PApplet display window where this button is displayed and handled
	 * 
	 * @param tank PApplet display
	 */
	public static void setProcessing(FishTank tank) {
		Button.tank = tank;
	}

	/**
	 * Checks whether the mouse is over this button
	 * 
	 * @return true if the mouse is over this button, false otherwise.
	 */
	@Override
	public boolean isMouseOver() {
		return !(tank.mouseX > x + WIDTH / 2 || tank.mouseX < x - WIDTH / 2 || tank.mouseY > y + HEIGHT / 2
				|| tank.mouseY < y - HEIGHT / 2);
	}

	/**
	 * Draws this button to the display window
	 */
	@Override
	public void draw() {
		tank.stroke(0);// set line value to black

		// if the mouse is over this button, sets the fill color to dark gray.
		// Sets the fill color to light gray otherwise
		if (isMouseOver()) {
			tank.fill(100);
		} else
			tank.fill(200);

		// draw the button (rectangle with a centered text)
		tank.rect(x - WIDTH / 2.0f, y - HEIGHT / 2.0f, x + WIDTH / 2.0f, y + HEIGHT / 2.0f);
		tank.fill(0); // set the fill color to black
		tank.text(label, x, y); // display the text of the current button
	}

	/**
	 * Implements the default behavior of this button when the mouse is pressed.
	 * This method must be overridden in the sub-classes to implement a specific
	 * behavior if needed.
	 */
	@Override
	public void mousePressed() {
		// if the mouse is over this button, print
		// "A button was pressed." to the console
		if (isMouseOver())
			System.out.println("A button was pressed.");

	}

	/**
	 * Implements the default behavior of this button when the mouse is released.
	 * This method must be overridden in the sub-classes to implement a specific
	 * behavior if needed.
	 */
	@Override
	public void mouseReleased() {
		// Leave this method empty
	}

}
