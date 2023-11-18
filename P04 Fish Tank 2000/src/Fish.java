//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P04 Fish Tank 2000
// Course: CS 300 Fall 2021
//
// Author: Jaesung Lim
// Email: jlim83@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Kyungmin Park
// Partner Email: kpark253@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class makes a fish which can swim in the fish tank.
 * 
 * @author Kyungmin Park, Jaesung Lim
 */
public class Fish {

	private static PApplet processing;
	private PImage image;
	private float x;
	private float y;
	private int speed;
	private boolean isDragging;
	private boolean isSwimming;
	private static int oldMouseX;
	private static int oldMouseY;

	// Creates a new fish object positioned at the center of the display window.
	public Fish(PApplet processing) {
		// processing PApplet object that represents the display window
		// This constructor sets the image instance field to
		// a PImage whose file name is "images" + File.separator + "orange.png"
		// Sets speed instance field to 5
		// Sets the x and y position of the fish to the center of the display window
		// The created fish won’t be dragging nor swimming.
		this.image = processing.loadImage("images" + File.separator + "orange.png");
		this.speed = 5;
		this.x = processing.width / 2;
		this.y = processing.height / 2;

	}

	// Creates a new fish object located at a specific (x, y) position of the
	// display window
	public Fish(PApplet processing, float x, float y, int speed, String fishImageFileName) {
		// processing PApplet object that represents the display window
		// x x-position of the image of this fish in the display window
		// y y-position of the image of this fish in the display window
		// speed the swimming speed of this fish
		// fishImageFileName file name of the image of the fish to be created
		this.processing = processing;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.image = processing.loadImage(fishImageFileName);
	}

	// accessor of the value image
	public PImage getImage() {
		// getter of the image instance field
		return this.image;
	}

	// accessor of the position of X
	// Returns the x-position of this fish in the display window
	public float getPositionX() {
		// getter of the x-position of this fish
		return this.x;
	}

	// accessor of the position of Y
	// Returns the y-position of this fish in the display window
	public float getPositionY() {
		// getter of the y-position of this fish
		return this.y;
	}

	// mutator of the positions of X and Y
	// Moves this fish with dx and dy
	public void move(int dx, int dy) {
		// adds dx move to the x-position of this fish
		// adds dy move to the y-position of this fish
		this.x += dx;
		this.y += dy;
	}

	// Checks whether this fish is being dragged
	public boolean isDragging() {
		// a getter for the isDragging instance field
		return this.isDragging;
	}

	// Starts dragging this fish
	public void startDragging() {
		// sets oldMouseX data field to the current x-position of the mouse
		// sets oldMouseY data field to the current y-position of the mouse
		// sets the isDragging data field of this fish to true
		oldMouseX = Fish.processing.mouseX;
		oldMouseY = Fish.processing.mouseY;
		this.isDragging = true;
	}

	// Stops dragging this fish
	public void stopDragging() {
		// sets the isDragging data field of this fish to false
		this.isDragging = false;
	}

	// Draws this fish to the display window.
	// This method sets also the position of this fish to follow the moves of the
	// mouse if it is being dragged
	public void draw() {
		// 1. if this fish is dragging, move it with (dx, dy) to follow the moves of the
		// mouse
		// [HINT] use the current position (processing.mouseX and processing.mouseY)
		// of the mouse with respect to the old position of the mouse to compute dx and
		// dy moves
		// Make sure to update oldMouseX and oldMouseY after moving the fish
		// 2. draw this fish to the display window by calling processing.image() method

		if (this.isSwimming == true) {
			this.swim();
		}

		if (this.isDragging == true) {
			this.move(Fish.processing.mouseX - oldMouseX, Fish.processing.mouseY - oldMouseY); // 이동거리만큼 물고기 이
			this.startDragging(); // oldMouse 초기화
		}

		Fish.processing.image(this.image, this.getPositionX(), this.getPositionY()); // 이미지 생

	}

	/**
	 * Checks if the mouse is over this fish instance as instance method
	 * 
	 * @return true if the mouse is over the given fish object (i.e. over the image
	 *         of the fish), false otherwise
	 */
	public boolean isMouseOver() {
		int fishWidth = this.getImage().width;
		int fishHeight = this.getImage().height;

		// checks if the mouse is over the provided fish
		return processing.mouseX >= this.getPositionX() - fishWidth / 2
				&& processing.mouseX <= this.getPositionX() + fishWidth / 2
				&& processing.mouseY >= this.getPositionY() - fishHeight / 2
				&& processing.mouseY <= this.getPositionY() + fishHeight / 2;
	}

	// Starts swimming this fish
	public void startSwimming() {
		// 1. stops dragging the fish
		// 2. sets the isSwimming instance field to true
		this.stopDragging();
		this.isSwimming = true;

	}

	// Stops swimming this fish
	public void stopSwimming() {
		// Sets the isSwimming instance field of this fish to false
		this.isSwimming = false;

	}

	// Moves horizontally the fish one speed step from left to right
	public void swim() {
		// The speed step is the instance field speed defined for each fish
		// Note that x-position of the fish is bounded by the width of the display
		// window. If the x-position of this fish exceeds the width of the display
		// window, it is going to be set to zero. You may think of using the
		// modulo operator to implement this property.
		this.move(speed, 0);
		this.x = this.getPositionX() % this.processing.width;

	}

}
