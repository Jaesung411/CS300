import java.util.Random;
import java.io.File;
import processing.core.PApplet;
import processing.core.PImage;
     
public class Try {

	private static PApplet processing; // PApplet object that represents the graphic
                               // interface of the JunglePark application
	private static PImage backgroundImage; // PImage object that represents the
                                   // background image
	private static Random randGen; // Generator of random numbers
	private static Fish[] fishes; // perfect size array storing the different fish present
    // in the fish tank. These fish can be of different species.

/**
 * Defines the initial environment properties of this application
 * @param processingObj a reference to the graphic display window of this application
 */
	public static void setup(PApplet processingObj) {

		//2.3 바탕화면 
		processing = processingObj;
		
		// load the image of the background
		backgroundImage = processing.loadImage("images/background.png");
		
		//3.2
		randGen = new Random();
		fishes = new Fish[8];		
//		for(int i = 0; i < 7; i++) {
//			
//		
//		float x = (float)randGen.nextInt(processing.width); // generates a random x-position of type
//				// float within the width of the display window
//		float y = (float)randGen.nextInt(processing.height); // generates a random y-position of type
//				// float within the height of the display window
//		System.out.print(i);
//		fishes[i] = new Fish(processing);
//		fishes[i]= new Fish(processing,x,y);
//		}
//		
//		
		}

	
	/**
	 * Draws and updates the application display window.
	 * This callback method called in an infinite loop.
	 */
	//4.1
	public static void draw(){
		
		//4.1
		// Draw the background image at the center of the screen
		processing.image(backgroundImage, processing.width / 2, processing.height / 2);
		// width [resp. height]: System variable of the processing library that stores
		// the width [resp. height] of the display window.
			
		for(int i = 0; i < fishes.length-1; i++) {
			System.out.print(fishes.length);
//			if(fishes[i] != null) {
				fishes[i].draw(); // where i is the index of the created Fish in the fishes array.
//			}
			
		}

	}
	
	//4.2
	/**
	 * Checks if the mouse is over a specific Fish whose reference is provided
	 * as input parameter
	 *
	 * @param Fish reference to a specific fish
	 * @return true if the mouse is over the specific Fish object (i.e. over
	 *        the image of the Fish), false otherwise
	 */
	public static boolean isMouseOver(Fish fish) {
		float xFish = fish.getImage().width;
		float yFish = fish.getImage().height;
		if((processing.mouseX > fish.getPositionX()-(xFish/2))&&(processing.mouseX<fish.getPositionX()+(xFish/2))
				&&(processing.mouseY<fish.getPositionY()+(yFish/2))&&(processing.mouseY>fish.getPositionY()-(yFish/2))) {
			
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Callback method called each time the user presses the mouse
	 */
	public static void mousePressed() {
		
		for(int i = 0; i < 8; i++) {
//			if(fishes[i] != null) {
//				fishes[i].setDragging(fishes[i].isDragging());
//				if(isMouseOver(fishes[i])==true) {
//					//Check
//					System.out.print("4");
//					fishes[i].setDragging(true);
//						//Check
//						System.out.print("1");
//						fishes[i].setPositionX(processing.mouseX);
//						fishes[i].setPositionY(processing.mouseY);	
//					}
//				}
//			}
			if(fishes[i] != null) {
				if(isMouseOver(fishes[i])==true) {
					fishes[i].setDragging(true);
					break;
				}
			
			}
		}
	}
	/**
	 * Callback method called each time the mouse is released
	 */
	public static void mouseReleased() {
//		fishes[0].setDragging(fishes[0].isDragging());
//		fishes[0].isDragging()=false;
		for(int i = 0; i < 8; i++) {
			if(fishes[i] != null) {
				fishes[i].setDragging(false);
			}
		}
	}

	/**
	 * Callback method called each time the user presses a key
	 */
	public static void keyPressed() {
		int index = 0;
		
		if(processing.key == 'f'|| processing.key == 'F') {
			for(int i = 0; i < 8; i++) {
				
				if(fishes[i] != null) {
					index++;

				}
				
			}
			
			float x = (float)randGen.nextInt(processing.width); // generates a random x-position of type
					// float within the width of the display window
			float y = (float)randGen.nextInt(processing.height); // generates a random y-position of type
					// float within the height of the display window
			
			fishes[index] = new Fish(processing);
			fishes[index]= new Fish(processing,x,y);
			
		}
		if(processing.key == 'r'|| processing.key == 'R') {
			
			for(int j =0; j < index; j++) {
				 
					if(fishes[j] != null) {
						
							if(isMouseOver(fishes[j])==true) {
								fishes[j] = null;
								index--;
							}	
					}	
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Utility.startApplication();
		

	}

}


