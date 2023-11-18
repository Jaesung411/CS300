
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
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * A class models the stack of tiles
 * 
 * @author Jaesung Lim
 *
 */
public class TileStack implements Iterable<Tile>, StackADT<Tile> {

	private Node top; // the top node of this stack
	private int size; // the size of this stack

	/**
	 * Create a empty tile stack
	 */
	public TileStack() {
		this.top = null;
		this.size = 0;
	}

	/**
	 * Push the provided tile at the top of this stack
	 */
	@Override
	public void push(Tile tile) {
		Node newNode = new Node(tile);
		newNode.setNext(top);
		top = newNode;
		size++;
	}

	/**
	 * Remove and return the tile at the top of this stack
	 * 
	 * @return a tile at the top
	 */
	@Override
	public Tile pop() {
		if (!this.isEmpty()) {
			Tile ret = top.getTile();
			top = top.getNext();
			size--;
			return ret;
		} else {
			// if this stack is empty, throw EmptyStackException
			throw new EmptyStackException();
		}
	}

	/**
	 * Return the tile at the top of this stack
	 * 
	 * @return the tile at the top
	 */
	@Override
	public Tile peek() {
		if (!this.isEmpty()) {
			return top.getTile();
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * Check whether this stack is empty
	 * 
	 * @return true if this stack is empty
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * Return the size of this stack
	 * 
	 * @return the size of this stack
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Return an iterator to iterate through this stack form its top
	 */
	@Override
	public Iterator<Tile> iterator() {
		return new TileListIterator(top);
	}

}
