
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
import java.io.File;

/**
 * A class representing any kinds of fishes in the tank, and inherit FishTank
 * 
 * @author Jaesung Lim, Kyungmin Park
 */
public class Fish extends TankObject {

	private int speed; // speed of fish
	private boolean isSwimming; // true if the fish is swimming

	/**
	 * constructor initializing the speed and the kind of the fish
	 * 
	 * @param speed
	 * @param fishImageFileName
	 */
	public Fish(int speed, String fishImageFileName) {

		// make any fish
		super((float) tank.randGen.nextInt(tank.width), (float) tank.randGen.nextInt(tank.height), fishImageFileName);

		// throw exception if the speed is zero or negative, and set the speed of fish
		if (speed <= 0)
			throw new IllegalArgumentException("Warning: speed cannot be negative");
		else
			this.speed = speed;

	}

	/**
	 * default constructor initializing a orange fish having speed 5
	 */
	public Fish() {
		this(5, "images" + File.separator + "orange.png");
	}

	/**
	 * Overrides the draw() method implemented in the parent class. This method sets
	 * the position of this fish to follow the mouse moves if it is dragging, calls
	 * its swim() method if it is swimming, and draws it to the display window.
	 */
	@Override
	public void draw() {
		if (isSwimming) {
			swim();
		}
		super.draw();

	}

	/**
	 * Checks whether this fish is swimming
	 * 
	 * @return true if the fishes is swimming
	 */
	public boolean isSwimming() {
		return isSwimming;
	}

	/**
	 * Starts swimming this fish
	 */
	public void startSwimming() {
		this.isSwimming = true;
	}

	/*
	 * Stops swimming this fish
	 */
	public void stopSwimming() {
		this.isSwimming = false;
	}

	/*
	 * Gets the speed of this fish
	 */
	public int speed() {
		return this.speed;
	}

	/*
	 * Moves horizontally the fish one speed step from left to right.
	 */
	public void swim() {
		setX((getX() + speed) % tank.width);
		startSwimming();
	}

}
