
public class Lec924 {

		  /**
		   * Gets the numeric value out of an input string
		   * @param x a string with the format "V"+a double
		   * @return the double value
		   * @throws NumberFormatException if the stuff following "V" isn't a double
		   */
		  private static double getValue(String x) 
		      throws NumberFormatException, IllegalArgumentException {
		    // validate input: input isn't null
//		    if (x == null) throw new NullPointerException();
		    
		    // validate input: NOT in a try/catch
		    if (x.length() < 2)
		      throw new IllegalArgumentException("Too short");
		    else if (x.charAt(0) != 'V') 
		      throw new IllegalArgumentException("Doesn't start with V");
		    
		    // strip off the first character: SAFE because we validated length
		    x = x.substring(1);
		    
		    // convert the rest to a double: could cause a NumberFormatException!!
		    // could catch and convert to IllegalArgument, but let's not...
		    double result = Double.parseDouble(x);
		    
		    // return the result
		    return result;
		  }
		  
		  private static double getAverage(String[] arr) throws ArithmeticException {
		    // add up all the values from the array
		    double total = 0;
		    int divideBy = 0;
		    for (int i=0; i<arr.length; i++) {
		      try {
		        total += getValue(arr[i]);  // might throw an exception
		        divideBy++;                 // only runs if getValue doesn't throw exception
		      } catch (NumberFormatException nfe) {
		        // we had a V but it wasn't followed by a double, skip it
		      } catch (IllegalArgumentException iae) {
		        
		        // badly formatted grade, skip index i
		        String message = iae.getMessage();
		        if (message.contains("V")) { /* whatever */ }
		        System.out.println(message);
		        
		      } catch (Exception e) {
		        // something bad happened, skip this index
		      }
		    }
		    
		    // divide by the length of the array
		    // what if divideBy is zero
		    if (divideBy != 0) total /= divideBy;
		    else throw new ArithmeticException("Nothing valid in the array");
		    
		    // return the result
		    return total;
		  }
		  
		  public static String getAverages(String[] one, String[] two) {
		    // add those to a results string
		    String result = "one: ";
		    
		    // get individual averages from one and two
		    // might throw ArithmeticException
		    try {
		      double avg1 = getAverage(one);
		      result += avg1;
		    } catch (ArithmeticException ae) {
		      result += "--";
		    }
		    
		    result += "\ntwo: ";
		    
		    try {
		      double avg2 = getAverage(two);
		      result += avg2;
		    } catch (ArithmeticException ae) {
		      result += "--";
		    }
		    
		    // return that string
		    return result;
		  }

		  public static void main(String[] args) {
		    // create my two string arrays
		    String[] one = new String[] {"Q2.2", "V1.47", "V100", "V-2.3",""};
		    String[] two = new String[] {"V37","V-1.2","VIX"};

		    // call getAverages
		    String result = getAverages(one, two);
		    
		    // print the result
		    System.out.println(result);
		  }

		}


