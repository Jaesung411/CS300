import java.io.File;

public class LinkedBookshelfTester {
	
	public static boolean testLinkedNode() {
		Book.resetGenerator();
		try {
			//scenario 1
			//test one constructor
			Book book1 = new Book("2001", 296, "Clarke", "Arthur C");
			Book book2 = new Book("FEED", 608, "Grant", "Mira");
			LinkedNode<Book> node1 = new LinkedNode<Book>(book1);
			LinkedNode<Book> node2 = new LinkedNode<Book>(book2);
		
			if(!node1.getData().equals(book1)) {
				System.out.println("Problem detected: wrong constructor");
				return false;
			}
			
			//scenario 2
			//test one accessor
			if(node1.getData()!=book1) {
				System.out.println("Problem detected: wrong accessor");
				return false;
			}
			
			//scenario 3
			//test one mutator
			node1.setNext(node2);
			if(!node1.getNext().equals(node2)) {
				System.out.println("Problem detected: wrong mutator");
				return false;
			}
		}catch(NullPointerException nex) {
			return false;
		}
		
		return true;
	}
	
	public static boolean testClear() {
		Book.resetGenerator();
		try {
			LinkedBookshelf shelf = new LinkedBookshelf();
			Book book1 = new Book("2001", 296, "Clarke", "Arthur C");
			Book book2 = new Book("FEED", 608, "Grant", "Mira");
			Book book3 = new Book("Good Omens", 288, "Gaiman", "Neil");
			Book book4 = new Book("Snow Crash", 468, "Stephenson", "Neal");
			shelf.appendBook(book1);
			shelf.appendBook(book2);
			shelf.appendBook(book3);
			shelf.appendBook(book4);
			shelf.clear();
			if(shelf.isEmpty() != true) {
				return false;
			}
			if(shelf.getFirst() != null || shelf.getLast() != null) {
				return false;
			}
		}catch(NullPointerException nex) {
			
		}
		
		return true;
	}

	public static boolean testAddBooks() {
		Book.resetGenerator();
		Book book1 = new Book("2001", 296, "Clarke", "Arthur C");
		Book book2 = new Book("FEED", 608, "Grant", "Mira");
		LinkedBookshelf shelf = new LinkedBookshelf();
		shelf.appendBook(book1);
		shelf.appendBook(book2);
		if(shelf.getLast() != book2) {
			return false;
		}
		if(shelf.size() != 2) {
			
			return false;
		}
		return true;
	}
	
	public static boolean testSortBooks() {
		Book.resetGenerator();
		LinkedBookshelf shelf = new LinkedBookshelf();
		Book book1 = new Book("Good Omens", 288, "Gaiman", "Neil");
		Book book2 = new Book("FEED", 608, "Grant", "Mira");
		Book book3 = new Book("Snow Crash", 468, "Stephenson", "Neal");
		Book book4 = new Book("2001", 296, "Clarke", "Arthur C");
		
		shelf.appendBook(book1);
		shelf.appendBook(book2);
		shelf.appendBook(book3);
		shelf.appendBook(book4);
		LinkedBookshelf.sort(shelf,Attribute.AUTHOR);
		String expectedShelf = "AUTHOR\n"+
				"3: \"2001\", Clarke, Arthur C (296)\n"+
				"0: \"Good Omens\", Gaiman, Neil (288)\n"+
				"1: \"FEED\", Grant, Mira (608)\n"+
				"2: \"Snow Crash\", Stephenson, Neal (468)\n";
		if(!shelf.toString().equals(expectedShelf)) {
			return false;
		}
		return true;
	}
	
	/**
	 * this method check all of the four methods work well
	 * 
	 * @return true when they work well
	 */
	public static boolean runAllTests() {
		//check whether all the tests 
		if (testLinkedNode() != true) {
			System.out.println("Failed testLinkedNode()");
			return false;
		}
		if (testClear() != true) {
			System.out.println("Failed testClear()");
			return false;
		}
		if (testAddBooks() != true) {
			System.out.println("Failed testAddBooks()");
			return false;
		}
		if (testSortBooks() != true) {
			System.out.println("Failed testSortBooks()");
			return false;
		}
		return true;
	}
	
	/**
	 * this method call the result of the runAllTests() method
	 */
	public static void main(String[] args) {
		LinkedNode<String> current = new LinkedNode("a",new LinkedNode("b",new LinkedNode("c")));

		while(current != null){
			  System.out.print(current.getData() + " ");
			  current = current.getNext();
			}

		System.out.print(runAllTests());
	}
}
