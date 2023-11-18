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

import processing.core.PApplet;
import java.util.Random;
import java.io.File;
import processing.core.PImage;
import java.util.ArrayList;

/**
 * A class representing any objects in the tank and interface TankListener.
 * 
 * @author Jaesung Lim, Kyungmin Park
 */
public class TankObject implements TankListener {

	protected static FishTank tank; // PApplet object which represents the display window
	protected PImage image; // image of this tank of object

	private float x; // x-position of this tank in the display window
	private float y; // y-position of this tank in the display window
	private boolean isDragging; // indicates whether this tank object is being dragged or not

	private static int oldMouseX; // old x-position of the mouse
	private static int oldMouseY; // old y-position of the mouse

	/**
	 * constructor initializing the position of objects and filename
	 */
	public TankObject(float x, float y, String imageFileName) {

		this.image = tank.loadImage(imageFileName);
		this.x = x;
		this.y = y;
		this.isDragging = false;

	}

	/**
	 * Sets the PApplet graphic display window for all TankObjects
	 * 
	 * @param tank the tank graphic display window
	 */
	public static void setProcessing(FishTank tank) {
		TankObject.tank = tank;
	}

	/**
	 * Moves this tank object with dx and dy
	 * 
	 * @param dx move to the x-position of this tank object
	 * @param dy move to the y-position of this tank object
	 */
	public void move(int dx, int dy) {
		this.x = dx + oldMouseX;
		this.y = dy + oldMouseY;
	}

	/**
	 * access the x-position of this tank object
	 * 
	 * @return returns the x-position of this tank object
	 */
	public float getX() {
		return this.x;
	}

	/**
	 * access the y-position of this tank object
	 * 
	 * @return returns the y-position of this tank object
	 */
	public float getY() {
		return this.y;
	}

	/**
	 * sets the x-position of this tank object
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * sets the y-position of this tank object
	 */
	public void setY(float y) {
		this.y = y;

	}

	/**
	 * access the image of this tank object
	 * 
	 * @return the image of this tank object
	 */
	public PImage getImage() {
		return this.image;

	}

	/**
	 * getter of the isDragging field.
	 * 
	 * @return true if this object is being dragged, false otherwise
	 */
	public boolean isDragging() {
		return this.isDragging;

	}

	/**
	 * Starts dragging this tank object
	 */
	public void startDragging() {
		oldMouseX = (int) x; // TankObject.tank.mouseX;
		oldMouseY = (int) y; // TankObject.tank.mouseY;
		this.isDragging = true;
	}

	/**
	 * Stops dragging this tank object
	 */
	public void stopDragging() {
		this.isDragging = false;
	}

	/**
	 * draw images if they are dragging
	 */
	@Override
	public void draw() {
		if (this.isDragging) {
			int dx = tank.mouseX - oldMouseX;
			int dy = tank.mouseY - oldMouseY;
			move(dx, dy);
			oldMouseX = tank.mouseX;
			oldMouseY = tank.mouseY;
		}
		tank.image(this.image, this.x, this.y);
	}

	/**
	 * drag any objects if they press the mouse
	 */
	@Override
	public void mousePressed() {
		if (isMouseOver())
			this.isDragging = true;
	}

	/**
	 * stop dragging any objects if they release the mouse
	 */
	@Override
	public void mouseReleased() {
		this.isDragging = false;
	}

	/**
	 * @return true if the mouse is over any image
	 */
	@Override
	public boolean isMouseOver() {
		return tank.mouseX >= x - image.width / 2 && tank.mouseX <= x + image.width / 2
				&& tank.mouseY >= y - image.height / 2 && tank.mouseY <= y + image.height / 2;
	}
}