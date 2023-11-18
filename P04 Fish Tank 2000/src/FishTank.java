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
import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * This class makes a fish tank in where fishes can swim with some decorations.
 * 
 * @author Kyungmin Park, Jaesung Lim
 */

public class FishTank {
	private static PApplet processing; // PApplet object which represents the graphic interface
										// of the Fish Tank application
	private static PImage backgroundImage; // PImage object which represents the background image
	private static Fish[] fishes; // array storing the current fishes present in the tank
	private static Random randGen; // Generator of random numbers
	private static String[] images = new String[] { "orange.png", "blue.png", "yellow.png", "black.png" }; // circular
																											// indexed
																											// array of
																											// fish
																											// images
																											// names
	private static int nextImageIndex; // index of next fish image index in the circular array images
	private static int fishSpeed; // the fishes speed
	private static Decoration[] decorations; // array storing the decoration objects present in the tank

	/**
	 * Defines initial environment properties such as screen size and to load
	 * background images and fonts as the program starts. It also initializes all
	 * data fields.
	 * 
	 * @param processingObj a PApplet object that represents the display window of
	 *                      the Fish Tank application
	 */
	public static void setup(PApplet processingObj) {
		processing = processingObj;
		backgroundImage = processing.loadImage("images" + File.separator + "background.png");
		fishes = new Fish[8];
		randGen = new Random();
		fishSpeed = 5; // control the fishes speed here
		decorations = new Decoration[4]; // there are four decorations

		// The kinds of decorations
		decorations[0] = new Decoration(processing, 430, 60, "images" + File.separator + "flower.png");
		decorations[1] = new Decoration(processing, 580, 470, "images" + File.separator + "log.png");
		decorations[2] = new Decoration(processing, 65, 520, "images" + File.separator + "shell.png");
		decorations[3] = new Decoration(processing, 280, 535, "images" + File.separator + "ship.png");
	}

	/**
	 * Continuously draws and updates the application display window
	 * 
	 */
	public static void draw() {
		// clear the display window by drawing the background image
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);

		// traverse the decorations array and draw each of the decoration present in the
		// tank
		for (int i = 0; i < decorations.length; i++) {
			if (decorations[i] != null)
				decorations[i].draw();
		}

		// traverse the fishes array and draw each of the fish present in the tank
		for (int i = 0; i < fishes.length; i++) {
			if (fishes[i] != null)
				fishes[i].draw();

		}

	}

	/**
	 * Callback method called each time the user presses the mouse
	 */
	public static void mousePressed() {
		// traverse the fishes array and start dragging a fish if the mouse is over it
		for (int i = 0; i < fishes.length; i++) {
			if (fishes[i] != null && fishes[i].isMouseOver()) {
				fishes[i].startDragging();
				break; // only the fish at the lowest index will start dragging if there are fishes
						// overlapping
			}
		}
		for (int i = 0; i < decorations.length; i++) {
			if (decorations[i] != null && decorations[i].isMouseOver()) {
				decorations[i].startDragging();
				break; // only the fish at the lowest index will start dragging if there are fishes
						// overlapping
			}
		}
	}

	/**
	 * Callback method called each time the mouse is released
	 */
	public static void mouseReleased() {
		// traverse the fishes array and stop dragging any fish
		for (int i = 0; i < fishes.length; i++) {
			if (fishes[i] != null)
				fishes[i].stopDragging();
		}
		for (int i = 0; i < decorations.length; i++) {
			if (decorations[i] != null)
				decorations[i].stopDragging();
		}
	}

	/**
	 * Callback method called each time the user presses a key
	 */
	public static void keyPressed() {

		switch (Character.toUpperCase(processing.key)) {
		case 'F': // add a new fish if the maximum numbers of fish allowed to be
					// present in the tank is not reached
			for (int i = 0; i < fishes.length; i++) {
				if (fishes[i] == null) {
					fishes[i] = new Fish(processing, (float) randGen.nextInt(processing.width),
							(float) randGen.nextInt(processing.height), fishSpeed,
							"images" + File.separator + images[FishTank.nextImageIndex]);
					// Make the index as zero if the index of image is over the length of images
					nextImageIndex = (nextImageIndex + 1) % images.length;
					break;
				}
			}
			break;
		case 'R': // delete the clicked fish if any
			for (int i = 0; i < fishes.length; i++) {
				if (fishes[i] != null && fishes[i].isMouseOver()) {
					fishes[i] = null;
					break;
				}
			}
			break;
		case 'S': // swim the clicked fish if any
			for (int i = 0; i < fishes.length; i++) {
				if (fishes[i] != null && fishes[i].isMouseOver()) {
					fishes[i].startSwimming();
					break;
				}
			}
			break;
		case 'X': // stop swimming the clicked fish if any
			for (int i = 0; i < fishes.length; i++) {
				if (fishes[i] != null && fishes[i].isMouseOver()) {
					fishes[i].stopSwimming();
					break;
				}
			}

		}

	}

	/**
	 * This main method starts the application
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {
		// starts the application
		Utility.startApplication();

	}

}