

public class LinkedBookshelf {
  private LinkedNode<Book> front;
  private LinkedNode<Book> back;
  private int size;
  private Attribute sortedBy;
  
  
  
  public LinkedBookshelf() {
    this.front = null;
    this.back = front;
    this.size = 0;
    this.sortedBy = Attribute.ID;
  }
  
  public int size() {
    return size;
  }
  
  public boolean isEmpty() {
    if(front == null && back == null && size == 0) return true;
    else return false;
  }
  
  public String toString(){
    if(this.size == 0) return null;
    String output = "" + sortedBy;
    
    LinkedNode<Book> current;
    current = front;
    output += ("\n" + current.getData().toString());
    while(current.getNext()!= null) {
      current = current.getNext();
      output += ("\n" + current.getData().toString());
    }
    return output;
    
    
    
  }
  
  public LinkedNode<Book> getNode(int index){
    if(index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
    LinkedNode<Book> current;
    current = front;
    for(int i = 0; i < index ; i++) {
      current = current.getNext();
    }
    return current;
    
      }
  public Book get(int index){
    if(index > size - 1 || index < 0) throw new IndexOutOfBoundsException();
    LinkedNode<Book> current;
    current = front;
    for(int i = 0; i < index ; i++) {
      current = current.getNext();
    }
    return current.getData();
  }
  
  public Book getFirst() {
    return front.getData();
  }
  public Book getLast() { 
    return back.getData();
    
  }
  
  public void clear() {
    this.front = null;
    this.back = null;
    this.size = 0;  
  }
  
  public void appendBook(Book toAdd) {
    if(front == null) {
      front = new LinkedNode<Book>(toAdd);
      back = front;
    }
    else {
      LinkedNode<Book> current;
      LinkedNode<Book> append = new LinkedNode<Book>(toAdd);
      
      current = front;
      while(current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(append);
      back = append;
    }
    size++;
  }
  
  public void insertBook(Book toAdd) {
    LinkedNode<Book> current;
    LinkedNode<Book> temp;
    LinkedNode<Book> newNode = new LinkedNode<Book>(toAdd);
    int added = 0;
    if(this.size == 0) {
      front = newNode;
      back = front;
    }
    else if(this.size == 1) {
      if(front.getData().compareTo(toAdd, sortedBy) > 0) {
        temp = front;
        front = newNode;
        front.setNext(temp);
        back = front.getNext();
      }
      else {
        front.setNext(newNode);
        back = front.getNext();
      } 
    }
    else {
      current = front;
      temp = front;
      while(current.getNext() != null) {
        temp = current;
        if(current.getData().compareTo(toAdd, sortedBy) > 0 && current.equals(front)){
            temp = front;
            front = newNode;
            front.setNext(temp);
            back = front.getNext();
            added++;
            break;
          }
         else if (current.getNext().getData().compareTo(toAdd, sortedBy) > 0){
           temp = current.getNext();
           current.setNext(newNode);
           current.getNext().setNext(temp);
           added = 1;
           break;
          } 
        current = current.getNext();
      }
      if(added == 0){
        current.setNext(newNode);
      }
    }
    size++;
  }
    
    
    
  
  
  public static void sort(LinkedBookshelf b, Attribute sortedBy) {
    LinkedBookshelf sorted = new LinkedBookshelf();
    sorted.sortedBy = sortedBy;
    LinkedBookshelf notSorted = new LinkedBookshelf();
    LinkedNode<Book> current;
    
    if(b.size >= 1) {
      sorted.insertBook(b.getFirst());
      notSorted.front = b.front.getNext();
      current = notSorted.front;
      sorted.insertBook(current.getData());
      while(current.getNext() != null) {
        current = current.getNext();
        sorted.insertBook(current.getData());
      }
      b.clear();
      b.sortedBy = sortedBy;
      current = sorted.front;
      b.appendBook(current.getData());
      while(current.getNext() != null) {
        current = current.getNext(); 
        b.appendBook(current.getData());
      }  
    }
    else System.out.println("babo");
  }
}
  
