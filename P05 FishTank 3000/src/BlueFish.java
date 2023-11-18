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

/*
 * the class representing the blue fish inheriting Fish.
 * @author Jaesung, Kyungmin Park
 */
public class BlueFish extends Fish {

	/*
	 * constructor initializing the blue fish having speed 2
	 */
	public BlueFish() {
		super(2, "images" + File.separator + "blue.png");
	}

	/**
	 * swim from right side to left side
	 */
	@Override
	public void swim() {

		float diff = 0;
		// when the fish's x-component is negative, set the component to width with
		// difference.
		if (this.getX() - this.speed() < 0) {
			diff = this.getX() - this.speed();
			this.setX(tank.width + diff);
		} else {
			this.setX(this.getX() - this.speed());
		}
		startSwimming();
	}

}
