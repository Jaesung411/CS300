//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 Benchmarking Hacks
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

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A class testing the methods, getContents, getDeepContents, lookupByName
 * ,lookupByKey, and lookupBySize
 * 
 * @author jaesung Lim
 *
 */
public class FolderExplorerTester {
	/**
	 * This method testing the method getContents by five scenarios
	 * 
	 * @param folder a tested folder
	 * @return check if the method is operated correctly
	 */
	public static boolean testGetContents(File folder) {
		try {
			// Scenario 1
			// list the basic contents of the cs300 folder
			ArrayList<String> listContent = FolderExplorer.getContents(folder);
			// expected output must contain "exams preparation", "grades",
			// "lecture notes", "programs", "reading notes", "syllabus.txt",
			// and "todo.txt" only.
			String[] contents = new String[] { "exams preparation", "grades", "lecture notes", "programs",
					"reading notes", "syllabus.txt", "todo.txt" };
			List<String> expectedList = Arrays.asList(contents);
			// check the size and the contents of the output
			if (listContent.size() != 7) {
				System.out.println("Problem detected: cs300 folder must contain 7 elements.");
				return false;
			}
			for (int i = 0; i < expectedList.size(); i++) {
				if (!listContent.contains(expectedList.get(i))) {
					System.out.println("Problem detected: " + expectedList.get(i)
							+ " is missing from the output of the list contents of cs300 folder.");
					return false;
				}
			}
			// Scenario 2 - list the contents of the grades folder
			File f = new File(folder.getPath() + File.separator + "grades");
			listContent = FolderExplorer.getContents(f);
			if (listContent.size() != 0) {
				System.out.println("Problem detected: grades folder must be empty.");
				return false;
			}
			// Scenario 3 - list the contents of the p02 folder
			f = new File(folder.getPath() + File.separator + "programs" + File.separator + "p02");
			listContent = FolderExplorer.getContents(f);
			if (listContent.size() != 1 || !listContent.contains("FishTank.java")) {
				System.out.println("Problem detected: p02 folder must contain only " + "one file named FishTank.java.");
				return false;
			}

			// Scenario 4 - List the contents of a file
			f = new File(folder.getPath() + File.separator + "todo.txt");
			try {
				listContent = FolderExplorer.getContents(f);
				System.out.println("Problem detected: Your FolderExplorer.getContents() must "
						+ "throw a NotDirectoryException if it is provided an input which is not" + "a directory.");
				return false;
			} catch (NotDirectoryException e) { // catch only the expected exception
				// no problem detected
			}
			// Scenario 5 - List the contents of not found directory/file
			f = new File(folder.getPath() + File.separator + "music.txt");
			try {
				listContent = FolderExplorer.getContents(f);
				System.out.println("Problem detected: Your FolderExplorer.getContents() must "
						+ "throw a NotDirectoryException if the provided File does not exist.");
				return false;
			} catch (NotDirectoryException e) {
				// behavior expected

			}
		} catch (Exception e) {
			System.out.println(
					"Problem detected: Your FolderExplorer.getContents() has thrown" + " a non expected exception.");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * This method testing the method getDeepContents
	 * 
	 * @param folder a tested folder
	 * @return check if the method is operated correctly
	 */
	public static boolean testDeepGetContentsBaseCase(File folder) {
		try {
			// the contents of the output
			ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);
			// the expected result
			String[] contents = new String[] {};
			List<String> expectedList = Arrays.asList(contents);
			// check the expected result and the contents of the output
			if (!(listContent.equals(expectedList))) {
				System.out.println("Problem detected: FolderExplorer.getDeepContentsBaseCase");
				return false;
			}
		} catch (NotDirectoryException e) {
			// behavior expected
		}

		return true;
	}

	/**
	 * This method testing the method getContents by five scenarios
	 * 
	 * @param folder a tested folder
	 * @return check if the method is operated correctly
	 */
	public static boolean testDeepListRecursiveCase(File folder) {
		try {
			// the contents of output
			ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);
			// the expected result
			String[] contents = new String[] { "ClimbingTrackerTester.java", "Program02.pdf", "Program03.pdf", "FishTank.java",
					"ExceptionalClimbing.java", "ExceptionalClimbingTester.java", "ClimbingTracker.java",
					"Program01.pdf", };
			List<String> expectedList = Arrays.asList(contents);

			// check the expected result and the contents of the output
			for(int i = 0; i < expectedList.size(); i++ ) {
				if (!(listContent.contains(expectedList.get(i)))) {
					System.out.println("Problem detected: FolderExplorer.testDeepListRecursiveCase");
					return false;
				}
			}
		} catch (NotDirectoryException e) {
			// behavior expected
		}
		return true;
	}

	/**
	 * This method testing the method getContents by five scenarios
	 * 
	 * @param folder a tested folder
	 * @return check if the method is operated correctly
	 */
	public static boolean testLookupByFileName(File folder, String fileName) {
		// the contents of output
		String content = FolderExplorer.lookupByName(folder, fileName);
		// the expected result
		String expectedContents = "cs300/reading notes/zyBooksCh4.txt";
		// check the expected result and the contents of the output
		if (!(content.equals(expectedContents))) {
			System.out.println("Problem detected: FolderExplorer.testLookupByFileName");
			return false;
		}
		return true;
	}

	/**
	 * This method testing the method getContents by five scenarios
	 * 
	 * @param folder a tested folder
	 * @return check if the method is operated correctly
	 */
	public static boolean testLookupByKeyBaseCase(File folder, String fileName) {

		try {
			ArrayList<String> listContent = FolderExplorer.getDeepContents(folder);
			String[] contents = new String[] { "zyBooksCh3.txt", "zyBooksCh2.txt", "zyBooksCh1.txt", "zyBooksCh4.txt" };
			List<String> expectedList = Arrays.asList(contents);
			
			// check the expected result and the contents of the output
			for(int i = 0; i < expectedList.size(); i++ ) {
				if (!(listContent.contains(expectedList.get(i)))) {
					System.out.println("Problem detected: FolderExplorer.testLookupByKeyBaseCase");
					return false;
				}
			}
		} catch (NotDirectoryException e) {
			// behavior expected
		}

		return true;
	}

	/**
	 * main method executing all tests
	 */
	public static void main(String[] args) {
		System.out.println("testGetContents: " + testGetContents(new File("cs300")));
		System.out.println("testGetDeepContentsBaseCase: " + testDeepGetContentsBaseCase(new File("grades")));
		System.out.println("testGetDeepKistRecursiveCase: "
				+ testDeepListRecursiveCase(new File("cs300" + File.separator + "programs")));
		System.out.println("testLookupByFileName: " + testLookupByFileName(new File("cs300"), "zyBooksCh4.txt"));
		System.out.println("testLookupByKeyBaseCase: "
				+ testLookupByKeyBaseCase(new File("cs300" + File.separator + "reading notes"), "txt"));
	}
}
