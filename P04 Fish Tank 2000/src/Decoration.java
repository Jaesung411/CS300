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

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class makes a decoration in the fish tank.
 * 
 * @author Kyungmin Park, Jaesung Lim
 */
public class Decoration {
	private static PApplet processing;
	private PImage image;
	private float x;
	private float y;
	private boolean isDragging;
	private int oldMouseX;
	private int oldMouseY;
	
	// Creates a decoration object positioned to the display window.
	public Decoration(PApplet processing, float x, float y, String imageFileName){ 
	// processing: PApplet reference to the display window of the Fish Tank application
	// x: x-position of this decoration object
	// y: y-position of this decoration object
    // imageFileName: filename of the image to be loaded for this object
		Decoration.processing = processing;
		this.x = x;
		this.y = y;
		this.image = processing.loadImage(imageFileName);
	}
	
	// accessor of the value image
	// Returns the image of this decoration object
	public PImage getImage() {
		return this.image;
	}
	
	// accessor of the position of X
	// Returns the x-position of this decoration object
	public float getPositionX() {
		return this.x;
	}
	
	// accessor of the position of Y
	// Returns the y-position of this decoration object
	public float getPositionY() {
		return this.y;
	}
	
	// Checks whether this decoration object is being dragged
	// returns true if the object is being dragged, false otherwise
	public boolean isDragging() {
		return this.isDragging;
	}
	
	
	// Starts dragging this decoration object
	// Sets the oldMouseX and oldMouseY to the current position of the mouse
	public void startDragging() {
		this.oldMouseX = Decoration.processing.mouseX;
		this.oldMouseY = Decoration.processing.mouseY;
		this.isDragging = true;
	}
	
	// Stops dragging this decoration object
	public void stopDragging() {
		this.isDragging = false;
	}
	
	// Checks whether the mouse is over this decoration object
	public boolean isMouseOver() {
	    int decoWidth = this.getImage().width;
	    int decoHeight = this.getImage().height;
	
	    // checks if the mouse is over the provided fish
	    return processing.mouseX >= this.getPositionX() - decoWidth / 2
	    		&& processing.mouseX <= this.getPositionX() + decoWidth / 2
			    && processing.mouseY >= this.getPositionY() - decoHeight / 2
			    && processing.mouseY <= this.getPositionY() + decoHeight / 2;
	}
	
	// Moves this decoration object with dx and dy
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	// Draws this decoration object to the display window.
	// This method sets also the position of this object to follow the moves of the
	// mouse if it is being dragged
	public void draw() { 
		if(this.isDragging == true) {
			this.move(Decoration.processing.mouseX-this.oldMouseX,Decoration.processing.mouseY-this.oldMouseY); // move the decoration following mouse
			this.startDragging();	// oldMouse update
		}
		//draw the decoration
		Decoration.processing.image(this.image, this.getPositionX(), this.getPositionY());
	}
}
