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
import java.util.NoSuchElementException;

/**
 * A class setting the testing methods
 * 
 * @author Jaesung Lim
 *
 */
public class FolderExplorer {

	/**
	 * the method arranging all the files or folders in the folder in the String
	 * arrayList.
	 * 
	 * @param currentDirectory the arranging folder
	 * @return a list of the names of all files and directories in the the given
	 *         folder currentDirectory.
	 * @throws NotDirectoryException if the provided currentDirectory does not exist
	 *                               or if it is not a directory
	 */
	public static ArrayList<String> getContents(File currentDirectory) throws NotDirectoryException {

		ArrayList<String> nameFiles = new ArrayList<String>();
		
		if (currentDirectory.exists() == false || currentDirectory.isFile())
			throw new NotDirectoryException("Not exist or not folder");
		
		for (int i = 0; i < currentDirectory.list().length; i++) {
			String name = currentDirectory.list()[i];
			nameFiles.add(name);
		}

		return nameFiles;
	}

	/**
	 * the recursive method that lists the names of all the files (not directories)
	 * in the given directory and its sub-directories.
	 * 
	 * @param currentDirectory the listing folder
	 * @return lists the names of all the files
	 * @throws NotDirectoryException exception if the provided currentDirectory does
	 *                               not exist or if it is not a directory
	 */
	public static ArrayList<String> getDeepContents(File currentDirectory) throws NotDirectoryException {

		ArrayList<String> nameFiles = new ArrayList<String>();
		
		if (currentDirectory.isFile()) throw new NotDirectoryException("file is not folder");
		
		// base case that there are not any sub-directories in the directory
		if (currentDirectory.listFiles() == null) {
			return nameFiles;
		}

		// check in the present directory
		for (int i = 0; i < currentDirectory.list().length; i++) {
			// if the element is file, add it in the list
			if (currentDirectory.listFiles()[i].isFile()) {
				nameFiles.add(currentDirectory.listFiles()[i].getName());
			}
			// if the element is directory, call own method for checking the directory
			if (currentDirectory.listFiles()[i].isDirectory()) {
				nameFiles.addAll(getDeepContents(currentDirectory.listFiles()[i]));
			}

		}

		return nameFiles;
	}

	/**
	 * a recursive method Searching the given directory and all of its
	 * sub-directories for an exact match to the provided fileName by helping the
	 * method lookupByName
	 * 
	 * @param currentDirectory the searching folder
	 * @param fileName         the name of the found file
	 * @return a path to the file, if it exists.
	 */
	public static String lookupByNameHelper(File currentDirectory, String fileName) {
		String path = new String();
		// Throws NoSuchElementException with a descriptive error message if
		// fileName is null or currentDirectory does not exist, or was not a directory)
		if (fileName == null || currentDirectory.isFile() || !(currentDirectory.exists()))
			throw new NoSuchElementException("No file's name, or not existed");

		for (int i = 0; i < currentDirectory.listFiles().length; i++) {
			// base case when the searching file's name is same with the found file's name
			if (currentDirectory.list()[i].equals(fileName)) {
				return currentDirectory.getName() + File.separator + fileName;
			}
			//if any directory is existed, check if the found file's name in the folder
			// if yes, save the path and call the own method for searching next path
			if (currentDirectory.listFiles()[i].isDirectory()) {
				try {
					if (getDeepContents(currentDirectory.listFiles()[i]).contains(fileName)) {
						path = path + currentDirectory.getName() + File.separator
								+ lookupByName(currentDirectory.listFiles()[i], fileName);
					}
				} catch (NotDirectoryException e) {
					
				}

			}
		}

		return path;
	}

	/**
	 * a method Searching the given directory and all of its sub-directories for an
	 * exact match to the provided fileName
	 * 
	 * @param currentDirectory the searching folder
	 * @param fileName the name of the found file
	 * @return a path to the file, if it exists.
	 */
	public static String lookupByName(File currentDirectory, String fileName) {
		// Throws NoSuchElementException with a descriptive error message if the
		// search operation returns with no results found
		if (lookupByNameHelper(currentDirectory, fileName).equals(""))
			throw new NoSuchElementException("File Not Found");

		return lookupByNameHelper(currentDirectory, fileName);
	}

	/**
	 * a recursive method searches the given folder and its sub-directories for ALL
	 * files that contain the given key in part of their name.
	 * 
	 * @param currentDirectory the searching folder
	 * @param key              the given key
	 * @return An arraylist of all the names of files that match
	 */
	public static ArrayList<String> lookupByKey(File currentDirectory, String key) {

		ArrayList<String> containFile = new ArrayList<String>();
		
		for (int i = 0; i < currentDirectory.listFiles().length; i++) {
			// base case that the element in the folder contains with the key
			if (currentDirectory.list()[i].contains(key)) {
				containFile.add(currentDirectory.list()[i]);
			}
			//if the element in the folder is folder, call the own method for searching it
			if (currentDirectory.listFiles()[i].isDirectory()) {
				containFile.addAll(lookupByKey(currentDirectory.listFiles()[i], key));
			}
		}
		return containFile;
	}

	/**
	 * a recursive method that searches the given folder and its sub-directories for
	 * ALL files whose size is within the given max and min values, inclusive.
	 * 
	 * @param currentDirectory the searching folder
	 * @param sizeMin          the minimum size of the accommodated file
	 * @param sizeMax          the maximum size of the accommodated file
	 * @return an array list of the names of all files whose size are within the
	 *         boundaries
	 */
	public static ArrayList<String> lookupBySize(File currentDirectory, long sizeMin, long sizeMax) {

		ArrayList<String> sizeDirectory = new ArrayList<String>();

		for (int i = 0; i < currentDirectory.listFiles().length; i++) {
			// base case that add the element in the folder is a file in a boundary
			if (currentDirectory.listFiles()[i].isFile()) {
				if (currentDirectory.listFiles()[i].length() >= sizeMin
						&& currentDirectory.listFiles()[i].length() <= sizeMax) {
					sizeDirectory.add(currentDirectory.list()[i]);
				}
			} else {
				//if the directory is empty, skip it
				if (currentDirectory.listFiles()[i].list() == null) return sizeDirectory;
				//if there is a directory, call the own method for searching it
				sizeDirectory.addAll(lookupBySize(currentDirectory.listFiles()[i], sizeMin, sizeMax));
			}
		}
		return sizeDirectory;
	}
}
