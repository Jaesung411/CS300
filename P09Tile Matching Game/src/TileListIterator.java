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
import java.util.NoSuchElementException;

/**
 * This class models a iterator of tile list
 * 
 * @author jaesung Lim
 *
 */
public class TileListIterator implements Iterator<Tile> {

	private Node node; // the head of node

	/**
	 * this constructor sets head node.
	 * 
	 * @param head
	 */
	public TileListIterator(Node head) {
		// Creates a new iterator to iterate through a list of tiles starting from its
		// head
		// head is a reference to the head of the linked list of tiles
		this.node = head;
	}

	/**
	 * Check whether the next node is existed
	 */
	@Override
	public boolean hasNext() {
		if (node != null)
			return true;
		return false;
	}

	/**
	 * Return the next node
	 * 
	 * @return the next node
	 */
	@Override
	public Tile next() {
		if (node == null)
			throw new NoSuchElementException("");
		Tile tile = node.getTile();
		node = node.getNext();
		return tile;
	}

}
