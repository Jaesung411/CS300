
public class LinkedNode <T> {
	
	private T data;
	private LinkedNode<T> next;
	
	public LinkedNode(T data) {
		this.data = data;
		this.next = null;
	}
	
	public LinkedNode(T data,LinkedNode<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public LinkedNode<T> getNext() {
		return this.next;
	}
	
	public T getData() {
		return this.data;
	}
	
	@Override  
	public String toString() {
		return data.toString(); 
	}
	
	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}
}
