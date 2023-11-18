
public class LinkedBookshelfTester {
  
  
  
  public static <T> boolean testLinkedNode() {
	  try {
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    
    LinkedNode<Integer> ln = new LinkedNode<Integer>(a);
    LinkedNode<Integer> ln2 = new LinkedNode<Integer>(b,ln);
    LinkedNode<Integer> ln3 = new LinkedNode<Integer>(c,ln2);
    LinkedNode<Integer> ln4 = new LinkedNode<Integer>(d);
    
  
      
      if(ln.getNext() != null) return false;
      
      
      if(!ln.getData().toString().equals("1")) return false;
      if(!ln2.getNext().equals(ln)) return false;
      
      if(!(ln2.getData() == 2)) return false;
      
      ln3.setNext(ln4);
      if(!ln3.getNext().equals(ln4)) return false;
      
      ln.getNext().getNext();
      
    } catch (NullPointerException npe) {
     
    }
    return true;   
  }
  
  public static boolean testClear() {
    Book.resetGenerator();
    LinkedBookshelf testShelf = new LinkedBookshelf();
    Book book1 = new Book("Good Omens" , 288, "Gaiman", "Neil");
    Book book2 = new Book("FEED" , 608, "Grant", "Mira");
    Book book3 = new Book("Snow Crash" , 468, "Stephenson", "Neal");
    Book book4 = new Book("2001" , 296, "Clarke", "Arther C");
    testShelf.appendBook(book1);
    testShelf.appendBook(book2);
    testShelf.appendBook(book3);
    testShelf.appendBook(book4);
    testShelf.clear();
    
    try {
      testShelf.getFirst();
      testShelf.getLast();
      return false;
    } catch (NullPointerException npe) {} 
   
    
    
    if(!testShelf.isEmpty()) return false;
    return true;
    }
  
  public static boolean testAddBooks() {
    
    Book.resetGenerator();
    LinkedBookshelf testShelf = new LinkedBookshelf();
    Book book1 = new Book("Good Omens" , 288, "Gaiman", "Neil");
    Book book2 = new Book("FEED" , 608, "Grant", "Mira");
    Book book3 = new Book("Snow Crash" , 468, "Stephenson", "Neal");
    testShelf.appendBook(book3);
    if(!(testShelf.getFirst().equals(book3) && testShelf.getLast().equals(book3) && testShelf.size() == 1)) return false;
    testShelf.appendBook(book2);
    if(!(testShelf.getFirst().equals(book3) && testShelf.getLast().equals(book2) && testShelf.size() == 2)) return false;
    testShelf.appendBook(book1);
    if(!(testShelf.getFirst().equals(book3) && testShelf.getLast().equals(book1) && testShelf.size() == 3)) return false;
    return true;
  }
  
  public static boolean testSortBooks() {
    Book.resetGenerator();
    LinkedBookshelf testShelf = new LinkedBookshelf();
    Book book1 = new Book("Good Omens" , 288, "Gaiman", "Neil");
    Book book2 = new Book("FEED" , 608, "Grant", "Mira");
    Book book3 = new Book("Snow Crash" , 468, "Stephenson", "Neal");
    Book book4 = new Book("2001" , 296, "Clarke", "Arther C");
    testShelf.appendBook(book1);
    testShelf.appendBook(book2);
    testShelf.appendBook(book3);
    testShelf.appendBook(book4);

    String result = "AUTHOR\n"+
			"3: \"2001\", Clarke, Arthur C (296)\n"+
			"0: \"Good Omens\", Gaiman, Neil (288)\n"+
			"1: \"FEED\", Grant, Mira (608)\n"+
			"2: \"Snow Crash\", Stephenson, Neal (468)\n";
    System.out.println(result);
    LinkedBookshelf.sort(testShelf, Attribute.AUTHOR);
    System.out.println(testShelf.toString());
//    System.out.println(testShelf.toString().equals(result));
//    if(!(testShelf.toString().equals(result))) {return false;}
    if(!testShelf.toString().equals(result)) {
		return false;
	}
//    System.out.println(testShelf.size());
//    LinkedBookshelf.sort(testShelf, Attribute.ID);
//    System.out.println(testShelf);
//   String result = "ID\n"
//	        + "0: \"Good Omens\", Gaiman, Neil (288)\n"
//	        + "1: \"FEED\", Grant, Mira (608)\n"
//	        + "2: \"Snow Crash\", Stephenson, Neal (468)\n"
//	        + "3: \"2001\", Clarke, Arthur C (296)";
//   System.out.println(result);
//    if(!testShelf.equals(result)){ return false;}
    
    
    return true;
  }
  
  public static boolean runAllTests() {
    if(!testLinkedNode()) return false;
    if(!testClear()) return false;
    if(!testAddBooks()) return false;
    if(!testSortBooks()) return false;
    return true;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(runAllTests());
    
  }

}
