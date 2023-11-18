//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P02 Fish Tank 1000
// Course: CS 300 Fall 2021
//
// Author: Jaesung Lim
// Email: jlim83@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// 	_X_ Write-up states that pair programming is allowed for this assignment.
// 	_X_ We have both read and understand the course Pair Programming Policy.
//	_X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class makes a fish tank which have maximum 8 fishes, and the fishes can
 * be dragged in the tank.
 * 
 * @author Jaesung Lim
 */
public class FishTank {

	private static PApplet processing; // PApplet object that represents the graphic
	// interface of the JunglePark application
	private static PImage backgroundImage; // PImage object that represents the
	// background image
	private static Random randGen; // Generator of random numbers
	private static Fish[] fishes; // perfect size array storing the different fish present
	// in the fish tank. These fish can be of different species.

	/**
	 * Defines the initial environment properties of this application
	 * 
	 * @param processingObj a reference to the graphic display window of this
	 *                      application
	 */
	public static void setup(PApplet processingObj) {

		// Set the processing variable to the input variable for using it anywhere
		processing = processingObj;

		// load the image of the background
		backgroundImage = processing.loadImage("images/background.png");

		randGen = new Random();
		fishes = new Fish[8];// the maximum number of fishes is 8.

	}

	/**
	 * Draws and updates the application display window. This callback method called
	 * in an infinite loop.
	 */
	public static void draw() {

		// Draw the background image at the center of the screen
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.

		// Draw fishes as much as the fishes array have.
		for (int i = 0; i < fishes.length; i++) {

			// Avoid a NullPointerException by using the if statement.
			if (fishes[i] != null) {
				fishes[i].draw(); // where i is the index of the created Fish in the fishes array.

			}

		}

	}

	/**
	 * Checks if the mouse is over a specific Fish whose reference is provided as
	 * input parameter
	 *
	 * @param Fish reference to a specific fish
	 * @return true if the mouse is over the specific Fish object (i.e. over the
	 *         image of the Fish), false otherwise
	 * 
	 */
	public static boolean isMouseOver(Fish fish) {

		float xFish = fish.getImage().width;// xFish is the fish's width
		float yFish = fish.getImage().height;// yFish is the fish's height

		// Measure the position of the specific fish object in the if statement
		if ((processing.mouseX > fish.getPositionX() - (xFish / 2))
				&& (processing.mouseX < fish.getPositionX() + (xFish / 2))
				&& (processing.mouseY < fish.getPositionY() + (yFish / 2))
				&& (processing.mouseY > fish.getPositionY() - (yFish / 2))) {

			return true;
		} else {
			return false;
		}
	}

	/**
	 * Callback method called each time the user presses the mouse
	 */
	public static void mousePressed() {

		// Check if fish objects is empty and if the mouse is over a specific fish.
		for (int i = 0; i < fishes.length; i++) {
			if (fishes[i] != null) {
				if (isMouseOver(fishes[i]) == true) {
					fishes[i].setDragging(true);
					break;// Drag only the fish stored at the lowest index within the fishes array.
				}

			}
		}
	}

	/**
	 * Callback method called each time the mouse is released
	 */
	public static void mouseReleased() {

		// Stop dragging when the mouse is released
		for (int i = 0; i < fishes.length; i++) {
			if (fishes[i] != null) {
				fishes[i].setDragging(false);
			}
		}
	}

	/**
	 * Callback method called each time the user presses a key
	 */
	public static void keyPressed() {
		
		//the index variable finds the minimum null index
		int index = -1;

		//the if statement works by pressing F or f key.
		if (String.valueOf(processing.key).equalsIgnoreCase("F")) {
			for (int i = 0; i < fishes.length; i++) {

				if (fishes[i] == null) {
					index = i;
					break;//Don't need to do anymore after finding the index
				}

			}

			if (index == -1) {
				return;
			}

			float x = (float) randGen.nextInt(processing.width); // generates a random x-position of type
			// float within the width of the display window
			float y = (float) randGen.nextInt(processing.height); // generates a random y-position of type
			// float within the height of the display window

			//Add a fish 
			fishes[index] = new Fish(processing);
			fishes[index] = new Fish(processing, x, y);

		}

		//the if statement works by pressing R or r key.
		if (String.valueOf(processing.key).equalsIgnoreCase("R")) {
			for (int j = 0; j < fishes.length; j++) {

				if (fishes[j] != null) {

					if (isMouseOver(fishes[j]) == true) {
						fishes[j] = null; //Remove the fish which is over the mouse and is not empty.
						break;//Don't need to do anymore after removing the fish.
					}
				}
			}
		}
	}

	public static void main(String[] args) {

		Utility.startApplication();

	}

}
