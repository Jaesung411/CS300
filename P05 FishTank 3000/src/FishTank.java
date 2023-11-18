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
 * A class representing the tank with some decorations and many kinds of fishes.
 * 
 * @author Jaesung Lim, Kyungmin Park
 */
public class FishTank extends PApplet {

	private PImage backgroundImage; // PImage object which represents the background image
	protected ArrayList<TankListener> objects; // list storing interactive objects
	protected Random randGen; // Generator of random numbers
	private TankObject flower;// TankObject object which represents the flower image
	private TankObject log;// TankObject object which represents the log image
	private TankObject ship;// TankObject object which represents the ship image
	private TankObject shell;// TankObject object which represents the shell image

	/**
	 * sets the size of this PApplet to 800 width x 600 height
	 */
	@Override
	public void settings() {
		size(800, 600);
	}

	/**
	 * Defines initial environment properties such as screen size and loads the
	 * background image and fonts as the program starts. It also initializes all
	 * data fields.
	 */
	@Override
	public void setup() {

		// Set and display the title of the display window
		this.getSurface().setTitle("Fish Tank 3000");
		// Set the location from which images are drawn to CENTER
		this.imageMode(PApplet.CENTER);
		// Set the location from which rectangles are drawn.
		this.rectMode(PApplet.CORNERS);
		// rectMode(CORNERS) interprets the first two parameters of rect() method
		// as the location of one corner, and the third and fourth parameters as
		// the location of the opposite corner.
		// rect() method draws a rectangle to the display window

		this.focused = true; // Confirms that our Processing program is focused,
		// meaning that it is active and will accept mouse or keyboard input.

		// sets the text alignment to center
		this.textAlign(PApplet.CENTER, PApplet.CENTER);

		// load the background image and store the loaded image to backgroundImage
		backgroundImage = this.loadImage("images/background.png");
		// Note that you can call the loadImage() method directly (this.loadImage())

		// create an empty array list of objects
		objects = new ArrayList<TankListener>();

		// set randGen to the reference of a new Random objects
		randGen = new Random();

		// set objects and buttons processing in the display window
		TankObject.setProcessing(this);
		Button.setProcessing(this);

		// create decorations as TankObjects objects
		flower = new TankObject(430, 60, "images" + File.separator + "flower.png");
		log = new TankObject(580, 470, "images" + File.separator + "log.png");
		shell = new TankObject(65, 520, "images" + File.separator + "shell.png");
		ship = new TankObject(280, 535, "images" + File.separator + "ship.png");

		// add them to the objects arraylist
		objects.add(flower);
		objects.add(log);
		objects.add(shell);
		objects.add(ship);

		// create and add two black fishes to the objects arraylist
		objects.add(new BlackFish(log, flower));
		objects.add(new BlackFish(shell, flower));

		// create and add many kinds of buttons to the objects arraylist
		objects.add(new AddBlueFishButton(43, 16));
		objects.add(new AddOrangeFishButton(129, 16));
		objects.add(new AddYellowFishButton(215, 16));
		objects.add(new ClearTankButton(301, 16));

	}

	/**
	 * Continuously draws and updates the application display window
	 */
	@Override
	public void draw() {
		// clear the display window by drawing the background image
		this.image(backgroundImage, this.width / 2, this.height / 2);

		// traverse the objects list and draw each of the objects to this display window
		for (int i = 0; i < objects.size(); i++)
			objects.get(i).draw();
	}

	/**
	 * Callback method called each time the user presses the mouse
	 */
	@Override
	public void mousePressed() {
		// traverse the objects list and call mousePressed method
		// of the first object being clicked in the list
		for (int i = objects.size() - 1; i >= 0; i--) {
			if (objects.get(i).isMouseOver()) {
				objects.get(i).mousePressed();
				break;
			}
		}
	}

	/**
	 * Callback method called each time the mouse is released
	 */
	@Override
	public void mouseReleased() {
		// traverse the objects list and call each object's mouseReleased() method
		for (int i = 0; i < objects.size(); i++)
			objects.get(i).mouseReleased();
	}

	/**
	 * adds an instance of TankListener passed as input to the objects arraylist
	 * 
	 * @param object an instance of TankListener
	 */
	public void addObject(TankListener object) {
		objects.add(object);
	}

	/**
	 * Callback method called each time the user presses a key
	 */
	@Override
	public void keyPressed() {

		switch (Character.toUpperCase(this.key)) {
		case 'O': // if pressing 'O' or 'o'
			// add a new orange fish in the tank
			objects.add(new Fish());
			break;

		case 'Y':// if pressing 'Y' or 'y'
			// add a new yellow fish which has 2 speed in the tank
			objects.add(new Fish(2, "images" + File.separator + "yellow.png"));
			break;

		case 'R':// if pressing 'R' or 'r'
			// delete the fish being mouse over
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish && objects.get(i).isMouseOver()) {
					objects.remove(i);
					break;
				}
			}
			break;

		case 'S':// if pressing 'S' or 's'
					// start swimming
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish) {
					((Fish) objects.get(i)).swim(); // it's tanklistener before using the cast after that it's fish
													// class.
				}
			}
			break;

		case 'X':// if pressing 'X' or 'x'
			// freeze (stop swimming)
			for (int i = 0; i < objects.size(); i++) {
				if (objects.get(i) instanceof Fish) {
					((Fish) objects.get(i)).stopSwimming();
				}
			}
			break;
		case 'B':// if pressing 'B' or 'b'
			// add a new blue fish in the tank
			objects.add(new BlueFish());
			break;

		case 'C':// if pressing 'C' or 'c'
			// remove all fishes in the tank
			clear();

		}
	}

	/**
	 * Removes instances of the class Fish from this tank
	 */
	public void clear() {
		// remove all Fish objects
		for (int i = 0; i < objects.size(); i++) {
			if (objects.get(i) instanceof Fish) {
				objects.remove(i);
				i--;
			}
		}
	}
	/**
	 * This main method starts the application
	 * 
	 * @param args input arguments if any
	 */
	public static void main(String[] args) {

		PApplet.main("FishTank");

	}

}
