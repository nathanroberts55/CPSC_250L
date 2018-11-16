
/**
 * Combination shell program for developing a lock combination class
 * @author Your benevolent Lab T/A
 * @author Nate Roberts
 */

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @class Combination shell class for developing a lock combination class
 */
public class Combination {
	private int aNum1;
	private int aNum2;
	private int aNum3;
	/**
	 * array to store the 3-digit integer lock combination
	 */
	private int[] numbers;

	/**
	 * 3-argument constructor that takes integer values for the lock combination
	 * and creates the numbers array instance and populates the elements with
	 * the lock combination in order of the given arguments.
	 * 
	 * @param int1
	 * @param int2
	 * @param int3
	 */

	public Combination(int num1, int num2, int num3) {
		aNum1 = num1;
		aNum2 = num2;
		aNum3 = num3;
		
		numbers = new int[3];
		 numbers[0] = num1;
		 numbers[1] = num2;
		 numbers[2] = num3;
	}

	/**
	 * getNumbers returns a *copy* of the numbers field array (in same order)
	 * 
	 * @return copy of numbers array
	 */
	public int[] getNumbers() {
		int[] array = {numbers[0], numbers[1], numbers[2]};
		return array;

	}

	/**
	 * isWithinRange - returns <code>true</code> if the *all* values in the
	 * numbers array are within the range [0,value] (the angle brackets show
	 * that this is inclusive so that 0 is a valid element as is value)
	 * 
	 * @param upper
	 *            limit
	 * @return <code>true</code> if all elements of array are in [0,upper],
	 *         <code>false</code> otherwise
	 */
	public boolean isWithinRange(int upper){
		if(aNum1 > upper || aNum1 < 0){
			return false;
		}
		if(aNum2 > upper || aNum2 < 0){
			return false;
		}
		if(aNum3 > upper || aNum3 < 0){
			return false;
		}
		return true;
		
	}

	// -------- Provided code below - do not change! --------------------------
	/**
	 * equals method that compares one combination to another object Only
	 * returns true if the combinations are equal
	 * 
	 * 
	 * @param anObject
	 *            - intended to be another Combination object, but will return
	 *            false if non-combination
	 * @return <code>true</code> if combinations exactly match,
	 *         <code>false</code> otherwise
	 */
	@Override
	public boolean equals(Object theOther) {
		if (theOther != null && this.getClass() == theOther.getClass()) {
			Combination aCombination = (Combination) theOther;
			int[] aNumbers = aCombination.getNumbers();

			return Arrays.equals(numbers, aNumbers);
		}
		return false;
	}
}
