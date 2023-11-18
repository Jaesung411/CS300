
public class LinkedBookshelfTester {
  
  
  
  public static <T> boolean testLinkedNode() {
    int a = 1;
    int b = 2;
    int c = 3;
    int d = 4;
    LinkedNode<Integer> ln = new LinkedNode<Integer>(a);
    LinkedNode<Integer> ln2 = new LinkedNode<Integer>(b,ln);
    LinkedNode<Integer> ln3 = new LinkedNode<Integer>(c,ln2);
    LinkedNode<Integer> ln4 = new LinkedNode<Integer>(d);
    
    
    try {
      
      if(ln.getNext() != null) return false;
      
      
      if(!ln.getData().toString().equals("1")) return false;
      if(!ln2.getNext().equals(ln)) return false;
      
      if(!(ln2.getData() == 2)) return false;
      
      ln3.setNext(ln4);
      if(!ln3.getNext().equals(ln4)) return false;
      
      ln.getNext().getNext();
      
    } catch (NullPointerException npe) {
      System.out.println("nullpointer");
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
    } catch (NullPointerException npe) {System.out.println("clear problem");} 
   
    
    
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
    testShelf.appendBook(book4);
    testShelf.appendBook(book3);
    String a = "fuck you";
    String b = "fuck you";
    System.out.println(a.equals(b));
    
    LinkedBookshelf.sort(testShelf, Attribute.TITLE);
    System.out.println(testShelf.toString());
    String result = "TITLE\r\n"
        + "3: \"2001\", Clarke, Arther C (296)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)" ;
    System.out.println(result);
    System.out.println(testShelf.toString().equals(result));

    LinkedBookshelf.sort(testShelf, Attribute.AUTHOR);
    if(!(testShelf.toString().equals("AUTHOR\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)"))) return false;
    LinkedBookshelf.sort(testShelf, Attribute.PAGECOUNT);
    if(!(testShelf.toString().equals("PAGECOUNT\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)"))) return false;
    LinkedBookshelf.sort(testShelf, Attribute.ID);
    if(!(testShelf.toString().equals("ID\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)"))) return false;
 
    testShelf.appendBook(book2);
    testShelf.appendBook(book1);
    
    LinkedBookshelf.sort(testShelf, Attribute.TITLE);
    if(!(testShelf.toString().equals("TITLE\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)\r\n"
        + "1: \"FEED\", Grant, Mira (608)\r\n"
        + "0: \"Good Omens\", Gaiman, Neil (288)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)"))) return false;
    LinkedBookshelf.sort(testShelf, Attribute.AUTHOR);
    if(!(testShelf.toString().equals("AUTHOR\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)\r\n"
        + "0: \"Good Omens\", Gaiman, Neil (288)\r\n"
        + "1: \"FEED\", Grant, Mira (608)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)"))) return false;
    LinkedBookshelf.sort(testShelf, Attribute.PAGECOUNT);
    if(!(testShelf.toString().equals("PAGECOUNT\r\n"
        + "0: \"Good Omens\", Gaiman, Neil (288)\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)\r\n"
        + "1: \"FEED\", Grant, Mira (608)"))) return false;
    LinkedBookshelf.sort(testShelf, Attribute.ID);
    if(!(testShelf.toString().equals("ID\r\n"
        + "0: \"Good Omens\", Gaiman, Neil (288)\r\n"
        + "1: \"FEED\", Grant, Mira (608)\r\n"
        + "2: \"Snow Crash\", Stephenson, Neal (468)\r\n"
        + "3: \"2001\", Clarke, Arthur C (296)"))) return false;
    
    
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
