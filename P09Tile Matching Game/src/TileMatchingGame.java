
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
 * This class models the game matching tiles
 * 
 * @author Jaesung Lim
 */
public class TileMatchingGame {

	private TileStack[] columns;

	/**
	 * Create a new game matching tile with a given number of columns
	 * 
	 * @param columnCount a number of columns
	 */
	public TileMatchingGame(int columnCount) {
		if (columnCount <= 0)
			throw new IllegalArgumentException();
		columns = new TileStack[columnCount];
		for (int i = 0; i < columnCount; i++) {
			columns[i] = new TileStack();
		}

	}

	/**
	 * Remove all the tiles from a column with a given index
	 * 
	 * @param index the index of column to clear
	 */
	public void clearColumn(int index) {
		try {
			columns[index] = new TileStack();
		} catch (IndexOutOfBoundsException iobex) {

		}
	}

	/**
	 * Return a string representing a given index of column
	 * 
	 * @param index the index of column to represent
	 * @return a string representing a given index of column
	 */
	public String column(int index) {

		String tiles = "";
		if (index < 0 || index >= columns.length)
			throw new IndexOutOfBoundsException();
		if (!columns[index].isEmpty()) {
			Iterator<Tile> itr = columns[index].iterator();
			while (itr.hasNext()) {
				tiles += itr.next() + " ";
			}
		}

		return tiles;
	}

	/**
	 * Drop a tile at the top of the given index of column. If tile will be dropped
	 * at the top of an tile of same color, both tiles will be removed from the
	 * stack of tiles
	 * 
	 * @param tile  a tile to drop
	 * @param index column position of the stack of tiles will be dropped
	 */
	public void dropTile(Tile tile, int index) {
		if (index < 0 || index >= columns.length)
			throw new IndexOutOfBoundsException();
		if (columns[index].isEmpty()) {
			columns[index].push(tile);
		} else if (columns[index].peek().equals(tile)) {
			columns[index].pop();
		} else {
			columns[index].push(tile);
		}

	}

	/**
	 * Get the number of columns in this game
	 * 
	 * @return the number of columns
	 */
	public int getColumnsNumber() {
		return columns.length;
	}

	/**
	 * Restart the game
	 */
	public void restartGame() {
		for (int i = 0; i < columns.length; i++) {
			this.clearColumn(i);
		}
	}

	/**
	 * Return a string representing of all of the tiles in this game
	 */
	@Override
	public String toString() {

		String ret = "GAME COLUMNS:\n";

		for (int i = 0; i < this.getColumnsNumber(); i++) {
			ret += i + ": " + this.column(i) + "\n";
		}
		return ret;
	}
}
