//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Climbing Tracker
// Course: CS 300 Fall 2021
//
// Author: Jaesung Lim
// Email: jlim83@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Kyungmin Park
// Partner Email: kpark234@wisc.edu
// Partner Lecturer's Name: Hobbes LeGault
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: (identify each by name and describe how they helped)
// Online Sources: (identify each by URL and describe how it helped)
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class tracks the number of successes and failures a climber challenges the grade from V0 to
 * V7.
 * 
 * @author Kyungmin Park, Jaesung Lim
 */
public class ClimbingTracker {

  /**
   * Set the size of array, Checks the index of the number of successes and failures in array. Since
   * the array is designated as oversize so the remaining successful and failure indexes will be
   * output as null.
   * 
   * @param array is the name of the trials that contain success and failure including null.
   * @param num   is the number of successes and failures in the array.
   * @param grade is the stage of climbing between V0 and V7 that will go into the array.
   * @return the size of the array designated as oversized.
   */
  private static int helper(String[] array, int num, String grade) {

    // the inputSize is when this variable apply to the helper method.
    int inputSize = 0;
    // the outputSize is the size after running this method
    int outputSize = 0;

    if (num == array.length) {
      return num;
    }

    // Calculate the input size
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        break;
      }
      inputSize++;
    }

    // Assign the grade as many as num to the end of the array
    for (int i = 0; i < num; i++) {
      array[num + inputSize - 1 - i] = grade;
    }

    // Calculate the output size
    for (int i = 0; i < array.length; i++) {
      if (array[i] == null) {
        break;
      }
      outputSize++;
    }

    // Check if the grade is invalid or not.
    if (!(grade == null)) {
      if (!(grade.charAt(0) == 'V' && Character.isDigit(grade.charAt(1)))) {
        return 0;
      }
    }
    return outputSize;
  }

  /**
   * Check the index of the number of success continuously in the array.
   * 
   * @param send    is an array of variables same as the array in the helper method.
   * @param numSend is that checks how many times in a row the climber successes in the array.
   * @param grade   is the stage of climbing between V0 and V7.
   * @return Call the helper method and return the number of successes for each step in the array.
   */
  public static int sendClimb(String[] send, int numSend, String grade) {
    return helper(send, numSend, grade);

  }

  /**
   * Check the index of the number of fail continuously in the array.
   * 
   * @param fail    is an array of variables same as the array in the helper method.
   * @param numFail is that checks how many times in a row the climber fails in the array.
   * @param grade   is the stage of climbing between V0 and V7.
   * @return Call the helper method and return the number of fails for each step in the array.
   */
  public static int failClimb(String[] fail, int numFail, String grade) {
    return helper(fail, numFail, grade);
  }

  /**
   * Checks the value that the average climb grade is divided by the most recent number of climbs in
   * each of the send and fail arrays.
   * 
   * @param send          is an array of variables same as the array in the helper method.
   * @param numSend       is that checks how many times the climber succeeds in the array.
   * @param fail          is an array of variables same as the array in the helper method.
   * @param numFail       is that checks how many times the climber fails in the array.
   * @param historyLength is the most recent number of climbs in each of the send and fail arrays.
   * @return the average climb grade is divided by historyLength.
   */
  public static String getStats(String[] send, int numSend, String[] fail, int numFail,
      int historyLength) {
    double sum1 = 0.0; // For the average of send
    double sum2 = 0.0; // For the average of fail

    int n = 0, m = 0;

    /*
     * Make another variable, and if n has a historyLength equivalent numSend value, then n has a
     * numSend value, otherwise n has a historyLength value.
     */
    if (historyLength > numSend) {
      n = numSend;

    } else {
      n = historyLength;
    }

    if (historyLength > numFail) {
      m = numFail;

    } else {
      m = historyLength;
    }

    // Assign the sum of send to sum1
    for (int i = numSend - 1; i > numSend - n - 1; i--) {
      int temp1 = Integer.parseInt(send[i].substring(1));
      sum1 = sum1 + temp1;

    }

    // Assign the sum of fail to sum1
    for (int i = numFail - 1; i > numFail - m - 1; i--) {
      int temp2 = Integer.parseInt(fail[i].substring(1));
      sum2 = sum2 + temp2;


    }

    double av1 = sum1 / n;
    double av2 = sum2 / m;

    // Assumed that there are the exceptions
    if (historyLength <= 0 || (numSend == 0 && numFail == 0)) {
      return "Send: --" + "\n" + "Fail: --";
    }

    if (numSend == 0) {
      return "Send: --" + "\n" + "Fail: " + av2;
    }
    if (numFail == 0) {
      return "Send: " + av1 + "\n" + "Fail: --";
    }
    return "Send: " + av1 + "\n" + "Fail: " + av2;

  }

  /**
   * Based on the array, and each failure is represented with a "-", each success is represented
   * with a "+" and are listed second.
   * 
   * @param send    is an array of variables same as the array in the helper method.
   * @param numSend is that checks how many times the climber succeeds in the array.
   * @param fail    is an array of variables same as the array in the helper method.
   * @param numFail is that checks how many times the climber fails in the array.
   * @return Return the number of successes or failures that are represented with a "-" or "+",
   *         However, if there are no attempts for a given grade, it displays empty.
   */
  public static String getHistogram(String[] send, int numSend, String[] fail, int numFail) {

    // @param result is the result of histogram
    String result = "";

    // Assumed that there is a exception
    if ((numSend == 0) && (numFail == 0)) {
      return "Error: no data to display";
    }

    // Find the Maximum value for setting the end line.
    int max = Integer.parseInt(send[0].substring(1));
    for (int i = 0; i < send.length; i++) {
      if (send[i] == null) {
        break;
      }
      if (Integer.parseInt(send[i].substring(1)) > max) {
        max = Integer.parseInt(send[i].substring(1));
      }
    }
    for (int i = 0; i < fail.length; i++) {
      if (fail[i] == null) {
        break;
      }
      if (Integer.parseInt(fail[i].substring(1)) > max) {
        max = Integer.parseInt(fail[i].substring(1));

      }
    }

    // Assign the grades in a row and + or - as many as the number of the grade in array to @param
    // result
    for (int i = 0; i <= max; i++) {
      String findGrade = "V" + i;

      result += findGrade + ": ";

      int failCount = 0;
      int sendCount = 0;

      for (int j = 0; j < send.length; j++) {
        if (findGrade.equals(send[j])) {
          sendCount++;
        }

      }
      for (int j = 0; j < fail.length; j++) {
        if (findGrade.equals(fail[j])) {
          failCount++;
        }
      }

      for (int j = 0; j < failCount; j++) {
        result += "- ";
      }
      for (int j = 0; j < sendCount; j++) {
        result += "+ ";
      }
      result += "\n";
    }
    return result;
  }
}
