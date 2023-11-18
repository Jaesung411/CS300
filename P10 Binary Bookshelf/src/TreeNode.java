//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P10 Binary Bookshelf
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

/**
 * A class models TreeNode having a data of T type, left and right child.
 * 
 * @author Jaesung
 *
 * @param <T> the type of data
 */
public class TreeNode<T> {

	/**
	 * the node's data of T type
	 */
	private T data;

	/**
	 * the node's left child
	 */
	private TreeNode<T> left;

	/**
	 * the node's right child
	 */
	private TreeNode<T> right;

	/**
	 * Construct a node with the given data and no children
	 * 
	 * @param data the data in this node
	 */
	public TreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	/**
	 * Construct a node with the given data and children
	 * 
	 * @param data  the data in this node
	 * @param left  the left child of this node
	 * @param right the right child of this node
	 */
	public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * Accessor for the left child of the node
	 */
	public TreeNode<T> getLeft() {
		return this.left;
	}

	/**
	 * Accessor for the right child of the node
	 */
	public TreeNode<T> getRight() {
		return this.right;
	}

	/**
	 * Accessor for the data contained in the node
	 */
	public T getData() {
		return this.data;
	}

	/**
	 * Mutator for the left child in the node
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Mutator for the right child in the node
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Return a string representation of this node's data
	 */
	@Override
	public String toString() {
		String ret = "" + data;
		return ret;
	}
}
