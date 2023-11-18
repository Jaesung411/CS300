import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;

public class FishTankPractice {
	private static PApplet processing; // PApplet object that represents the graphic
    // interface of the JunglePark application
	private static PImage backgroundImage; // PImage object that represents the
        // background image
	private static Fish[] fishes; // perfect size array storing the different fish present
	// in the fish tank. These fish can be of different species.
	private static Random randGen; // Generator of random numbers
	//2
	public static void setup(PApplet processingObj) {
		fishes = new Fish[8];
		processing = processingObj;
		
		// load the image of the background
		backgroundImage = processing.loadImage("images/background.png");
		
		// Draw the background image at the center of the screen
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.
		for(int i = 0; i < 8; i++) {
		
		fishes[0] = new Fish(processing);
		fishes[i].draw();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Utility.startApplication(); // starts the application
	}

}
