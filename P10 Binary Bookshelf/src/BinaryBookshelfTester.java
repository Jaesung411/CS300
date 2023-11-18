
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
 * This class tests the BinaryBookshelf class
 * 
 * @author Jaesung
 *
 */
public class BinaryBookshelfTester {

	/**
	 * this method tests TreeNode class
	 *
	 * @return true if the TreeNode class works correctly
	 */
	public static boolean testTreeNode() {

		// Scenario 1: a single TreeNode with no children
		TreeNode<Integer> snr1 = new TreeNode<Integer>(1);
		try {
			// check whether the node does not have children,
			if (snr1.getLeft() != null || snr1.getRight() != null)
				return false;
			// check whether the node's data is same with the string representation of the
			// data value
			if (!snr1.getData().toString().equals("1"))
				return false;
		} catch (Exception e) {
			return false;
		}

		// Scenario 2: a simple collection of TreeNodes
		// check if the mutator is working
		TreeNode<Integer> snr2 = new TreeNode<Integer>(1);
		TreeNode<Integer> snr2Child = new TreeNode<Integer>(2);
		snr2.setLeft(snr2Child);
		try {
			if (snr2.getLeft() != snr2Child)
				return false;
			if (snr2.getRight() != null)
				return false;
		} catch (Exception e) {
			return false;
		}

		// Scenario 3: multiple-arg constructor
		TreeNode<Integer> snr3LeftChild = new TreeNode<Integer>(1);
		TreeNode<Integer> snr3RightChild = new TreeNode<Integer>(2);
		TreeNode<Integer> snr3 = new TreeNode<Integer>(3, snr3LeftChild, snr3RightChild);
		try {
			if (!snr3.getLeft().equals(snr3LeftChild))
				return false;
			if (!snr3.getRight().equals(snr3RightChild))
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * this method tests BinaryBookshelf class
	 * 
	 * @return true if the BinaryBookshelf class work correctly
	 */
	public static boolean testEmptyTree() {

		// Scenario 1: invalid constructor inputs
		try {
			// Check if an ordered array of Attributes begins with AUTHOR
			Attribute[] attri = {};
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
			if (attri[0] != Attribute.AUTHOR)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException iaex) {

		}

		try {
			// Check if an ordered array of Attributes has 4 size
			Attribute[] attri = { Attribute.AUTHOR, Attribute.ID, Attribute.ID, Attribute.PAGECOUNT, Attribute.TITLE,
					Attribute.ID };
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
			if (attri.length != 4)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException iaex) {

		}

		try {
			// Check if an ordered array of Attributes has same elements
			Attribute[] attri = { Attribute.AUTHOR, Attribute.ID, Attribute.PAGECOUNT, Attribute.ID };
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
		} catch (IllegalArgumentException iaex) {

		}

		try {
			// Check if an ordered array of Attributes begins with AUTHOR
			Attribute[] attri = { Attribute.ID, Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.TITLE };
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
		} catch (IllegalArgumentException iaex) {

		}

		// Scenario 2: valid input
		try {
			Attribute[] attri = { Attribute.AUTHOR, Attribute.ID, Attribute.PAGECOUNT, Attribute.TITLE };
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
			// Verify that the size() of this Bookshelf is 0, that it isEmpty(),
			// that its toString() returns an empty String, and that its getRoot() is null.
			if (bbs.size() != 0 || !bbs.toString().equals("") || bbs.getRoot() != null)
				return false;
		} catch (Exception e) {
			return false;
		}
		try {
			Attribute[] attri = { Attribute.AUTHOR, Attribute.ID, Attribute.PAGECOUNT, Attribute.TITLE };
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
			// check if the getAttributeOrder method work correctly
			String expected = "1:AUTHOR 2:ID 3:PAGECOUNT 4:TITLE";
			if (!bbs.getAttributeOrder().equals(expected))
				return false;

			// check if the contains method work correctly
			if (bbs.contains(new Book("Finish", 310)) == true)
				return false;

			// check if the getBookByAuthor method work correctly
			ArrayList<Book> expectedArray = new ArrayList<Book>();
			if (!bbs.getBooksByAuthor("anything").equals(expectedArray))
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * this method tests the InsertBook method works correctly
	 * 
	 * @return true if the InsertBook method works correctly
	 */
	public static boolean testInsertBook() {

		try {
			// Scenario 1: inserting into an empty tree
			Attribute[] attri = { Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT, Attribute.ID };
			BinaryBookshelf bbs = new BinaryBookshelf(attri);
			Book book1 = new Book("The Fellowship of the Ring", 390, "Tolkien", "JRR");
			TreeNode<Book> addedNode1 = new TreeNode<Book>(book1);
			bbs.insertBook​(book1);
			// check if the shelf is not empty
			if (bbs.isEmpty() == true)
				return false;
			// check if the size increases
			if (bbs.size() != 1)
				return false;
			// check if the added book is the root node
			if (addedNode1.getData() != bbs.getRoot().getData())
				return false;

			// Scenario 2 : inserting a unique, smaller value into a non-empty tree
			Book book2 = new Book("please", 390, "LeGuin", "Ursula");
			TreeNode<Book> addedNode2 = new TreeNode<Book>(book2);
			bbs.insertBook​(book2);
			// check if the left child is the added node
			if (bbs.getRoot().getLeft().getData() != addedNode2.getData())
				return false;
			// check if the size increases
			if (bbs.size() != 2)
				return false;

			// Scenario 3 : inerting a value with a shared author attribute
			Book book3 = new Book("The Two Towers", 390, "Tolkien", "JRR");
			TreeNode<Book> addedNode3 = new TreeNode<Book>(book3);
			bbs.insertBook​(book3);
			// check if the compareToHelper method compare other Attribute's elements
			if (bbs.compareToHelper(book3, book1) <= 0)
				return false;
			// check if the right child is the added node
			if (bbs.getRoot().getRight().getData() != addedNode3.getData())
				return false;
			// check if the size increases
			if (bbs.size() != 3)
				return false;

			// Scenario 4: inserting a duplicate value
			Book book4 = new Book("The Two Towers", 390, "Tolkien", "JRR");
			bbs.insertBook​(book4);
			// check if the size increases
			if (bbs.size() != 4)
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * this method tests the contains method works correctly
	 * 
	 * @return true if the contains method works correctly
	 */
	public static boolean testContains() {

		// Scenario 1: non-recursive case
		Attribute[] attri = { Attribute.AUTHOR, Attribute.TITLE, Attribute.PAGECOUNT, Attribute.ID };
		BinaryBookshelf bbs = new BinaryBookshelf(attri);
		Book book1 = new Book("The Fellowship of the Ring", 390, "M", "JRR");
		Book book2 = new Book("please", 254, "P", "Ursula");
		Book book3 = new Book("The Two Towers", 190, "C", "JRR");
		bbs.insertBook​(book1);
		bbs.insertBook​(book2);

		if (bbs.contains(book1) != true)
			return false;
		if (bbs.contains(book3) != false)
			return false;

		// Scenario 2: recursive case
		Book book4 = new Book("100", 190, "A", "Lim");
		Book book5 = new Book("The Two Men", 190, "Z", "E");
		bbs.insertBook​(book4);
		bbs.insertBook​(book5);

		// Search for the book at the root
		if (bbs.contains(book1) != true)
			return false;
		// Search for the book at the leaf
		if (bbs.contains(book4) != true)
			return false;
		// Search for the book at the internal
		if (bbs.contains(book2) != true)
			return false;
		// Search for the book which is not in the Bookshelf
		Book book6 = new Book("False", 110, "Why", "Kim");
		if (bbs.contains(book6) != false)
			return false;

		return true;
	}

	/**
	 * this method tests the getBooksByAuthor method works correctly
	 * 
	 * @return true if the getBooksByAuthor method works correctly
	 */
	public static boolean testGetBooksByAuthor() {

		try {
			// Scenario 1: non-recursive case
			Attribute[] attri2 = { Attribute.AUTHOR, Attribute.PAGECOUNT, Attribute.TITLE, Attribute.ID };
			BinaryBookshelf bbs = new BinaryBookshelf(attri2);
			Book book1 = new Book("The First", 100, "M", "J");
			bbs.insertBook​(book1);

			// check if the size is 1 when finding the added book's author
			if (bbs.getBooksByAuthor(book1.getAuthor()).size() != 1)
				return false;
			// check if the size is 0 when finding the other author
			if (bbs.getBooksByAuthor("Lim, Jaesung").size() != 0)
				return false;

			// Scenario 2: recursive case
			Book book2 = new Book("The Second", 200, "C", "J");
			Book book3 = new Book("The Third", 300, "Z", "J");
			Book book4 = new Book("The Fourth", 400, "A", "J");
			Book book5 = new Book("The Fifth", 500, "A", "J");
			Book book6 = new Book("The Fifth", 500, "E", "J");

			TreeNode<Book> node2 = new TreeNode<Book>(book2);
			TreeNode<Book> node3 = new TreeNode<Book>(book3);
			TreeNode<Book> node4 = new TreeNode<Book>(book4);
			TreeNode<Book> node5 = new TreeNode<Book>(book5);
			TreeNode<Book> node6 = new TreeNode<Book>(book6);

			// Make Binary search tree
			bbs.getRoot().setLeft(node2);
			bbs.getRoot().setRight(node3);
			node2.setLeft(node4);
			node2.setRight(node6);
			node4.setRight(node5);

			// check if the size of the book written by the first book is one
			if (bbs.getBooksByAuthor(book2.getAuthor()).size() != 1)
				return false;
			if (bbs.getBooksByAuthor(book2.getAuthor()).get(0) != book2)
				return false;

			// check if the size of two books written by same author is two
			if (bbs.getBooksByAuthor(book4.getAuthor()).size() != 2)
				return false;
			if (bbs.getBooksByAuthor(book1.getAuthor()).contains(book5))
				return false;
			if (bbs.getBooksByAuthor(book1.getAuthor()).contains(book4))
				return false;

			Book book7 = new Book("The Sixth", 500, "L", "J");
			// check if the size of the book written by other author is zero
			if (bbs.getBooksByAuthor(book7.getAuthor()).size() != 0)
				return false;

		} catch (Exception e) {
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
		if (testTreeNode() != true) {
			System.out.println("Failed testTreeNode()");
			return false;
		}
		if (testEmptyTree() != true) {
			System.out.println("Failed testEmptyTree()");
			return false;
		}
		if (testInsertBook() != true) {
			System.out.println("Failed testInsertBook()");
			return false;
		}
		if (testContains() != true) {
			System.out.println("Failed testContains()");
			return false;
		}
		if (testGetBooksByAuthor() != true) {
			System.out.println("Failed testGetBooksByAuthor()");
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
