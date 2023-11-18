
public class LinkedBookshelf{
	
	private LinkedNode<Book> front;
	private LinkedNode<Book> back;
	private int size;
	private Attribute sortedBy;
	
	public LinkedBookshelf() {
		front = null;
		back = null;
		size = 0;
		sortedBy = Attribute.ID;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		if(this.size==0) {
			return true;
		}
		return false;	
	}

	public String toString() {
		String result = "";
		result = result + sortedBy.toString() + "\n";
		for(int i = 0; i < size; i++) {
			result += this.getNode(i) + "\n";
		}
		return  result;
	}
	
	public LinkedNode<Book> getNode(int index){
		
		LinkedNode<Book> cur = front;
		if(index < 0 && index > size-1) throw new IndexOutOfBoundsException();
		for(int i=0; i < index; i++) {
			cur = cur.getNext();
		}
		return cur;
	}
	
	public Book get(int index) {
		if(index >= 0 && index > size-1) throw new IndexOutOfBoundsException();
		return this.getNode(index).getData();
	}
	
	public Book getFirst() {
		return front.getData();
	}
	
	public Book getLast() {
		return back.getData();
	}
	
	public void clear() {
		front = null;
		back = null;
		size = 0;
		sortedBy = Attribute.ID;
	}
	
	public void appendBook(Book toAdd) {
		LinkedNode<Book> appendNode = new LinkedNode<Book>(toAdd);
		//empty array
		if(front == null) {
			front = appendNode;
		}else {
			back.setNext(appendNode);
		}
		back = appendNode;
		size++;
	}
	
	public void insertBook(Book toAdd) {
		LinkedNode<Book> insertNode = new LinkedNode<Book>(toAdd);
		if(this.size == 0) {
			front = insertNode;
			back = insertNode;
		}
		//맨앞일경
		else if(front.getData().compareTo(toAdd,sortedBy)>0) {
			LinkedNode<Book> temp = front;
			front = insertNode;
			front.setNext(temp);
		}else if(back.getData().compareTo(toAdd,sortedBy)<0){
			back.setNext(insertNode);
			back = insertNode;
		
		//마지막일 경우
		}else {
			for(int i = 0; i< size; i++) {
				if(this.getNode(i).getData().compareTo(toAdd,sortedBy)<0) {
					insertNode.setNext(this.getNode(i+1));
					this.getNode(i).setNext(insertNode);		
				}
			}
		}
		size++;
		
	}
	
	public static void sort(LinkedBookshelf b, Attribute sortedBy) {
		LinkedBookshelf temp = new LinkedBookshelf();
		if(b.size()==0||b.size()==1) {
			
		}else {
			b.sortedBy = sortedBy;
			temp.sortedBy = sortedBy;
			temp.appendBook(b.get(0));
			for(int i = 1; i < b.size(); ++i) {
				temp.insertBook(b.get(i));
			}
			b.clear();
			b.sortedBy = sortedBy;
			for(int i =0 ; i < temp.size();i++) {
				b.appendBook(temp.get(i));	
			}
		}

	}

}
