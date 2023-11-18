
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
import java.util.ArrayList;

/**
 * this class models the binary search tree
 * 
 * @author Jaesung
 *
 */
public class BinaryBookshelf {

	/**
	 * the root node of the BST
	 */
	private TreeNode<Book> root;

	/**
	 * the number of nodes currently contained in the BST
	 */
	private int size;

	/**
	 * the ordered array of attributes by which the BST nodes are sorted
	 */
	private Attribute[] sortList;

	/**
	 * One-argument constructor, initializes an empty BinaryBookshelf
	 * 
	 * @param sortList
	 * @throws IllegalArgumentException the list is not satisfied with the condition
	 */
	public BinaryBookshelf(Attribute[] sortList) {
		if (sortList.length != 4 || sortList[0] != Attribute.AUTHOR)
			throw new IllegalArgumentException();
		for (int i = 0; i < sortList.length; i++) {
			// check all elements of the list is Attribute object
			if (!(sortList[i] instanceof Attribute))
				throw new IllegalArgumentException();
			// check if each element is different
			for (int j = i + 1; j < sortList.length; j++) {
				if (sortList[i].equals(sortList[j]))
					throw new IllegalArgumentException();
			}
		}

		this.root = null;
		this.size = 0;
		this.sortList = sortList;
	}

	/**
	 * Accessor the number of nodes currently in the BST
	 * 
	 * @return the number of nodes currently
	 */
	/** Complexity: O(1) */
	public int size() {
		return this.size;
	}

	/**
	 * Determine whether the BST is empty
	 * 
	 * @return true if the BST is empty
	 */
	/** Complexity: O(1) */
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * Accessor a String-formatted list of the attributes
	 * 
	 * @return a String-formatted list of the attributes
	 */
	public String getAttributeOrder() {
		String ret = "";
		for (int i = 1; i <= sortList.length; i++) {
			if (i == sortList.length) {
				ret += i + ":" + sortList[i - 1];
			} else {
				ret += i + ":" + sortList[i - 1] + " ";
			}
		}
		return ret;
	}

	/**
	 * Search for the input in the bookshelf
	 * 
	 * @param book the book to search for
	 * @return true if the book is present in the shelf
	 */
	/** Complexity: O(N) */
	public boolean contains(Book book) {
		return containsHelper(book, root);
	}

	/**
	 * Recursuve helper method for searching for the input book
	 * 
	 * @param book    the book to search for
	 * @param current the root of the current subtree
	 * @return true if the book is contained in the subtree
	 */
	protected boolean containsHelper(Book book, TreeNode<Book> current) {
		// base cases:
		// current node is null = search failed
		if (current == null)
			return false;
		// curent nodes's data is same with the given book = search success
		if (book == current.getData())
			return true;

		// recursive cases
		// the given book is bigger than the current data, search right child
		if (compareToHelper(current.getData(), book) < 0)
			return containsHelper(book, current.getRight());
		// the given book is small than the current data, search left child
		if (compareToHelper(current.getData(), book) > 0)
			return containsHelper(book, current.getLeft());

		return false;

	}

	/**
	 * helper method to compare two Book objects according to the sortList of
	 * attributes
	 * 
	 * @param one the book to compare
	 * @param two the book to compare
	 * @return a negative if one < two, a positive value if one > two, and 0 if they
	 *         are equal
	 */
	protected int compareToHelper(Book one, Book two) {

		// case: one and two have same attributes
		if (one.equals(two))
			return 0;

		// check if the elements of attributes are same orderly
		for (int i = 0; i < sortList.length; i++) {
			if (one.compareTo(two, sortList[i]) != 0) {
				if (one.compareTo(two, sortList[i]) < 0)
					return -1;
				else
					return 1;
			}
		}
		return 0;
	}

	/**
	 * Return a list books in the bookshelf written by the given author
	 * 
	 * @param authorName the author name to filter on
	 * @return a list of books by the author
	 */
	public ArrayList<Book> getBooksByAuthor(String authorName) {
		return getBooksByAuthorHelper(authorName, root);
	}

	/**
	 * A list of books in the bookshelf written by the given author
	 * 
	 * @param authorName the author name to filter on
	 * @param the        root of the current subtree
	 * @return a list of books by the author
	 */
	protected ArrayList<Book> getBooksByAuthorHelper(String authorName, TreeNode<Book> current) {
		ArrayList<Book> ret = new ArrayList<Book>();
		
		if (current != null) {
			//add the book written by same author
			if (current.getData().getAuthor().equals(authorName)) {
				ret.add(current.getData());
			}
			// add the book on the left subtree
			ret.addAll(getBooksByAuthorHelper(authorName, current.getLeft()));
			// add the book on the right subtree
			ret.addAll(getBooksByAuthorHelper(authorName, current.getRight()));

		}

		return ret;
	}

	/**
	 * returns an in-order traversal of the BST
	 * 
	 * @return String an in-order traversal of the BST
	 */
	/** Complexity: O(N) */
	@Override
	public String toString() {

		return toStringHelper​(root);
	}

	/**
	 * help the toString method
	 * 
	 * @param current the root of the current subtree
	 * @return the string representation of this subtree
	 */
	protected String toStringHelper​(TreeNode<Book> current) {
		String ret = "";
		// base case
		// there are not any children
		if (current == null)
			return ret;

		// recursive cases
		// add the left tree
		ret += toStringHelper​(current.getLeft());
		// add the current book
		ret += current + "\n";
		// add right tree
		ret += toStringHelper​(current.getRight());

		return ret;
	}

	/**
	 * Returns a shallow copy of the root node
	 * 
	 * @return a reference to the current root node
	 */
	protected TreeNode<Book> getRoot() {
		TreeNode<Book> ret = root;
		return ret;
	}

	/**
	 * Resets the BST to be empty
	 */
	public void clear() {
		this.root = null;
		this.size = 0;
	}

	/**
	 * Adds a new Book to the BST in sorted order, relative to this BST's sortList
	 * attributes
	 */
	public void insertBook​(Book book) {

		// throw IllegalArgumentException if this Book is already in the BST
		if (this.contains(book))
			throw new IllegalArgumentException();

		// add the root if the root is empty
		if (root == null) {
			root = new TreeNode<Book>(book);
		} else {
			insertBookHelper​(book, root);
		}
		// add size after inserting
		size++;
	}

	/**
	 * help the inserBook method for recursive method
	 * 
	 * @param book    the Book object to be added to the BST
	 * @param current the root of the current subtree
	 */
	protected void insertBookHelper​(Book book, TreeNode<Book> current) {
		// make a node to insert
		TreeNode<Book> insertNode = new TreeNode<Book>(book);

		// check the given book is lower than current book
		if (compareToHelper(book, current.getData()) < 0) {
			// if left child is empty, add the node in the left child
			if (current.getLeft() == null) {
				current.setLeft(insertNode);
			} else {
				// try to insert the given book in the left subtree
				insertBookHelper​(book, current.getLeft());
			}
			// check the given book is higher than current book
		} else if (compareToHelper(book, current.getData()) > 0) {
			// if right child is empty, add the node in the right child
			if (current.getRight() == null) {
				current.setRight(insertNode);
			} else {
				// try to insert the given book in the right subtree
				insertBookHelper​(book, current.getRight());
			}
		} else {
			// not approach here because if the given book cannot be same the current book
			insertBookHelper​(book, current);
		}

	}

}
