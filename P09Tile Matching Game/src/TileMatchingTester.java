
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Benchmarking Hacks
// Course:   CS 300 Fall 2021
//
// Author:   Jaesung Lim
// Email:    jlim83@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
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
import java.util.Iterator;

/**
 * This class test many methods
 * 
 * @author Jaesung Lim
 */
public class TileMatchingTester {

	/**
	 * Test equals method
	 * 
	 * @return true if it works correctly
	 */
	public static boolean tileEqualsTester() {

		try {
			// scenario 1
			// compare a tile to an object which is not instance of the class Tile
			Tile tile1 = new Tile(Color.BLACK);
			String comparedTile1 = "BLACK";
			if (tile1.equals(comparedTile1)) {
				System.out.print("Problem detected: scenario1 ");
				return false;
			}

			// scenario 2
			// compare a tile to another tile of the same color
			Tile tile2 = new Tile(Color.BLACK);
			Tile comparedTile2 = new Tile(Color.BLACK);

			if (!tile2.equals(comparedTile2)) {
				System.out.print("Problem detected: scenario2 ");
				return false;
			}

			// scenario 3
			// compare a tile to another tile of the different color
			Tile tile3 = new Tile(Color.BLACK);
			Tile comparedTile3 = new Tile(Color.YELLOW);

			if (tile3.equals(comparedTile3)) {
				System.out.print("Problem detected: scenario3 ");
				return false;
			}
		} catch (ClassCastException cex) {
			return false;
		}

		return true;
	}

	/**
	 * Test next and hasNext methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean tileListIteratorTester() {
		Tile tile1 = new Tile(Color.BLACK);
		Tile tile2 = new Tile(Color.BLUE);
		Tile tile3 = new Tile(Color.ORANGE);
		Node node = new Node(tile1, new Node(tile2, new Node(tile3)));

		// test hasNext() method
		TileListIterator itr = new TileListIterator(node);
		boolean expectedHasNext = true;
		if (itr.hasNext() != expectedHasNext) {
			System.out.println("Problem detected: hasNext() method");
			return false;
		}

		// test next() method
		Tile expectedNext = new Tile(Color.BLACK);
		if (!itr.next().equals(expectedNext)) {
			System.out.println("Problem detected: next() method");
			return false;
		}

		return true;
	}

	/**
	 * test the isEmpty, size, push, and peek methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean tileStackTesterHelper1() {

		TileStack stack = new TileStack();

		// test isEmpty method
		if (!stack.isEmpty())
			return false;

		// test push method
		Tile tile1 = new Tile(Color.BLACK);
		Tile tile2 = new Tile(Color.BLUE);
		stack.push(tile1);
		stack.push(tile2);
		Iterator<Tile> itr = stack.iterator();
		String result = "";
		String expectedResult = "BLUE BLACK ";
		while (itr.hasNext()) {
			result += itr.next() + " ";
		}
		if (!result.equals(expectedResult)) {
			System.out.println("Problem detected: push() method");
			return false;
		}

		// test size method
		int expectedSize = 2;
		if (stack.size() != expectedSize) {
			System.out.println("Problem detected: size() method");
			return false;
		}

		// test peek method
		stack.peek();
		if (!stack.peek().equals(tile2)) {
			System.out.println("Problem detected: peek() method");
			return false;
		}

		return true;
	}

	/**
	 * test the pop and iterator methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean tileStackTesterHelper2() {

		TileStack stack = new TileStack();
		Tile tile1 = new Tile(Color.BLACK);
		Tile tile2 = new Tile(Color.ORANGE);
		stack.push(tile1);
		stack.push(tile2);

		// test pop method
		Tile expected = tile2;
		String resultRemain = "";
		String expectedRemain = "BLACK ";
		if (!stack.pop().equals(expected)) {
			System.out.println("Problem detected: pop() method");
			return false;
		}
		Iterator<Tile> itr = stack.iterator();
		while (itr.hasNext()) {
			resultRemain += itr.next() + " ";
		}
		if (!resultRemain.equals(expectedRemain)) {
			System.out.println("Problem detected: pop() method");
			return false;
		}

		// test iterator method
		stack.push(tile1);
		String resultIterator = "";
		String expectedIterator = "BLACK BLACK ";
		Iterator<Tile> testItr = stack.iterator();
		while (testItr.hasNext()) {
			resultIterator += testItr.next() + " ";
		}
		if (!resultIterator.equals(expectedIterator)) {
			System.out.println("Problem detected: iterator() method");
			return false;
		}

		return true;
	}

	/**
	 * test two helper methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean tileStackTester() {

		if (tileStackTesterHelper1() == false || tileStackTesterHelper2() == false) {
			return false;
		}
		return true;
	}

	/**
	 * test all the methods in the TileMatchingGame class
	 * 
	 * @return true if it works correctly
	 */
	public static boolean tileMatchingGameTester() {

		TileMatchingGame game = new TileMatchingGame(4);

		// test getColumnsNumber method
		int expectedResult = 4;
		if (game.getColumnsNumber() != expectedResult) {
			System.out.println("Problem detected: getColumnsNumber() method");
			return false;
		}

		// test dropTile method
		game.dropTile(new Tile(Color.BLACK), 0);
		game.dropTile(new Tile(Color.BLUE), 0);
		String expectedDropTile = "BLUE BLACK ";
		if (!game.column(0).equals(expectedDropTile)) {
			System.out.println("Problem detected: dropTile() method");
			return false;
		}

		// test column method
		String expectedColumn = "BLUE BLACK ";
		if (!game.column(0).equals(expectedColumn)) {
			System.out.println("Problem detected: column() method");
			return false;
		}

		// test clearColumn method
		game.clearColumn(0);
		if (!game.column(0).equals("")) {
			System.out.println("Problem detected: clearColumn() method");
			return false;
		}

		// test restartGame method
		game.restartGame();
		for (int i = 0; i < game.getColumnsNumber(); i++) {
			if (!game.column(i).equals("")) {
				System.out.println("Problem detected: restartGame() method");
				return false;
			}
		}

		// test toString method
		String expectedString = "GAME COLUMNS:\n" + "0: \n" + "1: \n" + "2: \n" + "3: \n";
		if (!game.toString().equals(expectedString)) {
			System.out.println("Problem detected: toString() method");
			return false;
		}

		return true;
	}

	/**
	 * test all of the tester methods
	 * 
	 * @return true if it works correctly
	 */
	public static boolean runAllTests() {
		// check whether all the tests
		if (tileEqualsTester() != true) {
			System.out.println("Failed tileEqualsTester()");
			return false;
		}
		if (tileListIteratorTester() != true) {
			System.out.println("Failed tileListIteratorTester()");
			return false;
		}
		if (tileStackTester() != true) {
			System.out.println("Failed tileStackTester()");
			return false;
		}
		if (tileMatchingGameTester() != true) {
			System.out.println("Failed tileMatchingGameTester()");
			return false;
		}

		return true;
	}

	/**
	 * this method call the result of the runAllTests() method
	 */
	public static void main(String[] args) {

		System.out.print(runAllTests());
	}

}
