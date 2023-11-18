
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
 * a class representing the blue fish inheriting Fish.
 * 
 * @author Jaesung, Kyungmin Park
 */
public class BlackFish extends Fish {

	private TankObject source;// a point of departure
	private TankObject destination;// arrival point.

	/**
	 * constructor initializing a black fish with departure and arrival point
	 * 
	 * @param source      a point of departure
	 * @param destination arrival point.
	 */
	public BlackFish(TankObject source, TankObject destination) {
		super(2, "images" + File.separator + "black.png");
		this.source = source;
		this.destination = destination;

	}

	/**
	 * makes one speed move towards destination
	 */
	public void moveTowardsDestination() {

		float dx = destination.getX() - getX();
		float dy = destination.getY() - getY();
		int d = (int) Math.sqrt(dx * dx + dy * dy);

		setX(getX() + (this.speed() * dx) / d);
		setY(getY() + (this.speed() * dy) / d);

	}

	/**
	 * @param other any space
	 * @return true if this black fish is over another tank object, and false
	 *         otherwise
	 */
	public boolean isOver(TankObject other) {
		return !(getX() + image.width / 2 < other.getX() - image.width / 2
				|| getX() - image.width / 2 > other.getX() + image.width / 2
				|| getY() + image.height / 2 < other.getY() - image.height / 2
				|| getY() - image.height / 2 > other.getY() + image.height / 2);
	}

	/**
	 * swim the fish towards its destination if destination is reached (meaning this
	 * fish is over its destination, switch source and destination
	 */
	@Override
	public void swim() {
		TankObject temp;
		moveTowardsDestination();
		startSwimming();
		if (isOver(destination)) {
			temp = source;
			source = destination;
			destination = temp;
		}
	}

}
