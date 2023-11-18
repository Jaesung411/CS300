
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

public class AssignmentQueueTester {

	/**
	 * this method tests the AssignmentQueue class's constructor
	 * 
	 * @return true if the constructor of AssignmentQueue functions properly
	 */
	public static boolean testConstructor() {

		AssignmentQueue assignQ;

		// Scenario 1
		// invalid case when the capacity is negative
		try {
			assignQ = new AssignmentQueue(-1);
		} catch (IllegalArgumentException iae) {

		} catch (Exception e) {
			return false;
		}

		// Scenario 2
		// valid case
		assignQ = new AssignmentQueue(3);
		// check if the size of the queue is zero
		if (assignQ.size() != 0)
			return false;

		return true;
	}

	/**
	 * this method tests the AssignmentQueue class's enqueue and peek method
	 * 
	 * @return true if AssignmentQueue.enqueue() and AssignmentQueue.peek() function properly
	 */
	public static boolean testEnqueue() {

		AssignmentQueue assignQ;

		// Scenario 1
		// invalid case when using the peek method if the queue is empty
		try {
			assignQ = new AssignmentQueue(3);
			assignQ.peek();

		} catch (NoSuchElementException nse) {

		} catch (Exception e) {
			return false;
		}

		try {
			// Scenario 2
			// valid case when the enqueue works correctly if the queue is empty
			Assignment assign1 = new Assignment("First", 12, 12, 12);
			assignQ = new AssignmentQueue(3);
			assignQ.enqueue(assign1);

			// check if the size is one
			if (assignQ.size() != 1)
				return false;
			// check if the first element is same with the given assignment
			if (!assignQ.peek().equals(assign1))
				return false;
			
			// Scenario 3
			// valid case when the enqueue works correctly if the queue is not empty
			Assignment assign2 = new Assignment("Second", 11, 11, 11);
			assignQ.enqueue(assign2);
			// check if the size is two
			if (assignQ.size() != 2)
				return false;
			// check if the first element is same with the given assignment
			if (!assignQ.peek().equals(assign2))
				return false;

			// Scenario 4
			// check if the peek method works correctly
			Assignment assign3 = new Assignment("Third", 10, 10, 10); // the assign3 with the earliest due date
			assignQ.enqueue(assign3);
			// check if the size is three
			if (assignQ.size() != 3)
				return false;
			if (!assignQ.peek().equals(assign3))
				return false;
			
			//check if the assignment is in the proper position
			Iterator<Assignment> itr = assignQ.iterator();
			if(!itr.next().equals(assign3))return false;
			if(!itr.next().equals(assign2))return false;
			if(!itr.next().equals(assign1))return false;
			
			// Scenario 5
			// invalid case when the assignment is added when the queue is full
			Assignment assign4 = new Assignment("Third", 10, 10, 10); // the assign3 with the earliest due date
			assignQ.enqueue(assign4);
			
		} catch (IllegalStateException ise) {

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		// Scenario 6
		// invalid case when the nothing(null) is added in the queue
		try {
			assignQ = new AssignmentQueue(3);
			assignQ.enqueue(null);
		} catch (NullPointerException npe) {

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return true;
	}

	/**
	 * this method tests the AssignmentQueue class's dequeue and peek method
	 *  
	 * @return true if AssignmentQueue.dequeue() and AssignmentQueue.peek() function properly
	 */
	public static boolean testDequeuePeek() {

		AssignmentQueue assignQ;

		// Scenario 1
		// invalid case : the dequeue method is used when the queue is empty
		try {
			assignQ = new AssignmentQueue(7);
			assignQ.dequeue();
		} catch (NoSuchElementException nse) {

		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		// Scenario 2
		// valid case : the dequeue method is used when the queue is not empty
		try {
			assignQ = new AssignmentQueue(7);
			Assignment assign1 = new Assignment("1", 12, 12, 12);
			assignQ.enqueue(assign1);
			// check if return value is the root value
			if (!assignQ.dequeue().equals(assign1))
				return false;
			// check if the queue is empty after dequeue method
			if (!assignQ.isEmpty())
				return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		try {
			// Scenario 3
			// valid case: calling peek on a non-empty queue should always return
			// the Assignment with the earliest due date after using the dequeue method
			assignQ = new AssignmentQueue(7);
			Assignment assign1 = new Assignment("1", 12, 12, 12);
			Assignment assign2 = new Assignment("2", 11, 11, 11);
			Assignment assign3 = new Assignment("3", 9, 9, 9);
			assignQ.enqueue(assign1);
			assignQ.enqueue(assign2);
			assignQ.enqueue(assign3);
			if (!assignQ.dequeue().equals(assign3))
				return false;
			if (!assignQ.peek().equals(assign2))
				return false;
			
			// Scenario 4
			// valid case: calling peek on a non-empty queue having more element should
			// always return the Assignment with the earliest due date after using
			// the dequeue method
			Assignment assign4 = new Assignment("4", 8, 8, 8);
			Assignment assign5 = new Assignment("5", 7, 7, 7);
			Assignment assign6 = new Assignment("6", 6, 6, 6);
			Assignment assign7 = new Assignment("7", 5, 5, 5);
			assignQ.enqueue(assign4);
			assignQ.enqueue(assign5);
			assignQ.enqueue(assign6);
			assignQ.enqueue(assign7);
			if (!assignQ.dequeue().equals(assign7))
				return false;
			if (!assignQ.peek().equals(assign6))
				return false;
			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

		return true;
	}
	
	/**
	 * this method tests the AssignmentQueue class's clear method
	 * 
	 * @return true if clear() functions properly
	 */
	public static boolean testClear() {

		AssignmentQueue assignQ;
		// Scenario 1
		// clear can be called on an empty queue with no errors
		try {
			assignQ = new AssignmentQueue(3);
			assignQ.clear();
			if (!assignQ.isEmpty())
				return false;
			if (assignQ.size() != 0)
				return false;
		} catch (Exception e) {
			return false;
		}

		// Scenario 2
		// clear can be called on a non-empty queue with no errors
		try {
			assignQ = new AssignmentQueue(3);
			Assignment assign1 = new Assignment("1", 12, 12, 12);
			Assignment assign2 = new Assignment("2", 11, 11, 11);
			Assignment assign3 = new Assignment("3", 9, 9, 9);
			assignQ.enqueue(assign1);
			assignQ.enqueue(assign2);
			assignQ.enqueue(assign3);
			assignQ.clear();
			if (!assignQ.isEmpty())
				return false;
			if (assignQ.size() != 0)
				return false;
			for (int i = 0; i < assignQ.size(); i++) {
				if (assignQ.dequeue() != null) {
					return false;
				}
			}
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
		if (testConstructor() != true) {
			System.out.println("Failed testConstructor()");
			return false;
		}
		if (testEnqueue() != true) {
			System.out.println("Failed testEnqueue()");
			return false;
		}
		if (testDequeuePeek() != true) {
			System.out.println("Failed testDequeuePeek()");
			return false;
		}
		if (testClear() != true) {
			System.out.println("Failed testClear()");
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
