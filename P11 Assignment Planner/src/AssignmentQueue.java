
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P11 Assignment Planner
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
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Array-based heap implementation of a priority queue containing Assignments.
 * Guarantees the min-heap invariant, so that the Assignment at the root should
 * have the earliest due date, and children always have a due date after or at
 * the same time as their parent. The root of a non-empty queue is always at
 * index 0 of this array-heap.
 */
public class AssignmentQueue implements PriorityQueueADT<Assignment>, Iterable<Assignment> {
	private Assignment[] queue; // array min-heap of assignments representing this priority queue
	private int size; // size of this priority queue

	/**
	 * Creates a new empty AssignmentQueue with the given capacity
	 * 
	 * @param capacity Capacity of this AssignmentQueue
	 * @throws IllegalArgumentException with a descriptive error message if the
	 *                                  capacity is not a positive integer
	 */
	public AssignmentQueue(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException();
		queue = new Assignment[capacity];
		size = 0;

	}

	/**
	 * Checks whether this AssignmentQueue is empty
	 * 
	 * @return {@code true} if this AssignmentQueue is empty
	 */
	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	/**
	 * Returns the size of this AssignmentQueue
	 * 
	 * @return the size of this AssignmentQueue
	 */
	@Override
	public int size() {

		return this.size;
	}

	/**
	 * Returns the capacity of this AssignmentQueue
	 * 
	 * @return the capacity of this AssignmentQueue
	 */
	public int capacity() {

		return queue.length;
	}

	/**
	 * Removes all elements from this AssignmentQueue
	 */
	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			queue[i] = null;
		}
		size = 0;
	}

	/**
	 * help to swap the assignments of the given indexes
	 * 
	 * @param a the given index
	 * @param b the given index
	 */
	private void swap(int a, int b) {
		Assignment temp = queue[a];
		queue[a] = queue[b];
		queue[b] = temp;
	}

	/**
	 * Returns the Assignment at the root of this AssignmentQueue, i.e. the
	 * Assignment with the earliest due date.
	 * 
	 * @return the Assignment in this AssignmentQueue with the earliest due date
	 * @throws NoSuchElementException if this AssignmentQueue is empty
	 */
	@Override
	public Assignment peek() {
		if (isEmpty())
			throw new NoSuchElementException();
		return queue[0];
	}

	/**
	 * Adds the given Assignment to this AssignmentQueue at the correct position
	 * based on the min-heap ordering. This queue should maintain the min-heap
	 * invariant, so that the Assignment at each index has an earlier or equivalent
	 * due-date than the Assignments in its child nodes. Assignments should be
	 * compared using the Assignment.compareTo() method.
	 * 
	 * @param e Assignment to add to this AssignmentQueue
	 * @throws NullPointerException  if the given Assignment is null
	 * @throws IllegalStateException with a descriptive error message if this
	 *                               AssignmentQueue is full
	 */
	@Override
	public void enqueue(Assignment e) {

		// throw NullPointerException if the given Assignment is null
		if (e == null)
			throw new NullPointerException();
		// throw IllegalStateException with a descriptive error message if this
		// AssignmentQueue is full
		if (this.size == queue.length)
			throw new IllegalStateException("It is full");

    //add the give assignment in the end of the queue and increase the size
    queue[size] = e;
    size++;
    // the present last index
    int index = size-1;
    //finish if the size is one because the queue does not need swap
    if(size == 1) {
    	
    }else {
	    percolateUp(index);
	}

}

	/**
	 * Removes and returns the Assignment at the root of this AssignmentQueue, i.e.
	 * the Assignment with the earliest due date.
	 * 
	 * @return the Assignment in this AssignmentQueue with the earliest due date
	 * @throws NoSuchElementException with a descriptive error message if this
	 *                                AssignmentQueue is empty
	 */
	@Override
	public Assignment dequeue() {
		
		int parentIndex = 0; // the starting point
		
		// throw exception if the AssignmentQueue is empty
		if (isEmpty())
			throw new NoSuchElementException();
		
	//save the assignment with the earliest due for returning
	Assignment min = queue[0];
	
	if(size > 1) {
		//bring the last assignment to the most front queue
		queue[0] = queue[size-1];
		queue[size-1] =null;
		size--;
		percolateDown(parentIndex);
		
	}else {
		size --;
	}
	
		return min;
	}

	/**
	 * Recursive implementation of percolateDown() method. Restores the min-heap
	 * invariant of a given subtree by percolating its root down the tree. If the
	 * element at the given index does not violate the min-heap invariant (it is due
	 * before its children), then this method does not modify the heap. Otherwise,
	 * if there is a heap violation, then swap the element with the correct child
	 * and continue percolating the element down the heap.
	 * 
	 * @param i index of the element in the heap to percolate downwards
	 * @throws IndexOutOfBoundsException if index is out of bounds - do not catch
	 *                                   the exception
	 */
	protected void percolateDown(int i) {
		// TODO provide the worst-case runtime complexity of this method assuming that
		// the problem size
		// N is the size of this queue
		// Time complexity: O(N)

		// the index of children
		int leftIndex = 2 * i + 1;
		int rightIndex = 2 * i + 2;

		// base case :out of bounds
		if (leftIndex >= size  && rightIndex >= size) {

		}else {
			//check if right is not empty
			if(queue[rightIndex]!=null) {
				//if the left is lower than the parent
				if(queue[rightIndex].compareTo(queue[i])<0) {
					//check if right is not empty
					if(queue[leftIndex]!=null) {
						//swap them if the left is lower than the right
						if(queue[rightIndex].compareTo(queue[leftIndex])>0) {
							swap(leftIndex,i);
							percolateDown(leftIndex);
						}
					}
					//swap the left and parent if the right is empty 
					swap(rightIndex,i);
					percolateDown(rightIndex);
				
				}
			//case that the left is empty and the right is not empty
			} if(queue[leftIndex]!=null) {
				//swap them if the right is lower than the parent 
				if(queue[i].compareTo(queue[leftIndex])>=0) {
					System.out.println("1");
					swap(leftIndex,i);
					percolateDown(leftIndex);
				}
			}
		}		
	}

	/**
	 * Recursive implementation of percolateUp() method. Restores the min-heap
	 * invariant of the tree by percolating a leaf up the tree. If the element at
	 * the given index does not violate the min-heap invariant (it occurs after its
	 * parent), then this method does not modify the heap. Otherwise, if there is a
	 * heap violation, swap the element with its parent and continue percolating the
	 * element up the heap.
	 * 
	 * @param i index of the element in the heap to percolate upwards
	 * @throws IndexOutOfBoundsException if index is out of bounds - do not catch
	 *                                   the exception
	 */
	protected void percolateUp(int i) {
		// TODO provide the worst-case runtime complexity of this method assuming that
		// the problem size
		// N is the size of this queue
		// Time complexity: O(N)

		// base case
		if (i == 0) {

		}
		// recursive case
		else {
			// the parent index
			int parentIndex = (i - 1) / 2;
			// swap if the parent is higher than child
			if (queue[parentIndex].compareTo(queue[i]) > 0) {
				swap(parentIndex, i);
			}
			// check the parent's parent
			percolateUp(parentIndex);
		}

	}

	/**
	 * Returns a deep copy of this AssignmentQueue containing all of its elements in
	 * the same order. This method does not return the deepest copy, meaning that
	 * you do not need to duplicate assignments. Only the instance of the heap
	 * (including the array and its size) will be duplicated.
	 * 
	 * @return a deep copy of this AssignmentQueue. The returned new assignment
	 *         queue has the same length and size as this queue.
	 */
	public AssignmentQueue deepCopy() {
		AssignmentQueue deepCopy = new AssignmentQueue(queue.length);
		for (int i = 0; i < size; i++) {
			deepCopy.enqueue(queue[i]);
		}
		return deepCopy;
	}

	/**
	 * Returns a String representing this AssignmentQueue, where each element
	 * (assignment) of the queue is listed on a separate line, in order from
	 * earliest to latest.
	 * 
	 * @see Assignment#toString()
	 * @see AssignmentIterator
	 * @return a String representing this AssignmentQueue
	 */
	public String toString() {
		StringBuilder val = new StringBuilder();

		for (Assignment a : this) {
			val.append(a).append("\n");
		}

		return val.toString();
	}
	
	/**
	 * Returns an Iterator for this AssignmentQueue which proceeds from the earliest
	 * to the latest Assignment in the queue.
	 * 
	 * @see AssignmentIterator
	 * @return an Iterator for this AssignmentQueue
	 */
	@Override
	public Iterator<Assignment> iterator() {
		return new AssignmentIterator(this);
	}
}