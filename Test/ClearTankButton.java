//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P05 Fish Tank 3000
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

public class ClearTankButton extends Button{
	public ClearTankButton(float xButton, float yButton) {
		super("clear",xButton,yButton);
	}
	
	@Override
	public void mousePressed() {
		
			if(this.isMouseOver()==true) {
				for(int i = 0; i < Button.tank.objects.size(); i++) {
				if(Button.tank.objects.get(i) instanceof Fish) {
					Button.tank.objects.remove(i);
					i--;
				}
			}
		}
	}
}
