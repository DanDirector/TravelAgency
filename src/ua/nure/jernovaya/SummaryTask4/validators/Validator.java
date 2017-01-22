/**
 * 
 */
package ua.nure.jernovaya.SummaryTask4.validators;

/**
 * @author Elmira Jernovaya.
 *
 */
public class Validator {
	/**
	 * checks if given objects are null.
	 * @param o
	 * @return true if all objects are null.
	 */
	public static boolean isNull(Object...o){
		for (Object object : o) {
			if (object==null) {
				return true;
			}
		}
		return false;
		
	}
	/**
	 * checks if given strings are integers.
	 * @param i
	 * @return true if all given stings are integers.
	 */
	public static boolean isInteger(String...i){
		for (String string : i) {
			if (!string.matches("\\d+")) {
				return false;
			}
		}
		return true; 
	}
	/**
	 * checks if given strings have the type double.
	 * @param price
	 * @return true if all given strings have type double.
	 */
	public static boolean isDouble(String... price) {
		for (String string : price) {
			if (!string.matches("\\b\\d+[.,]*[\\d]*\\b")) {
				return false;
			}
		}
		return true;
	}
	

}
