import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 *  @author Nathan Roberts
 */

public class Lock {
	
	private int upper;
	private boolean isOpen;
	protected Combination comb;
	
	/**
	 * Constructor that receives an int upper bound and a COmbination 
	 * object.If the combination is within range and is the correct 
	 * length the lock will be open.
	 * 
	 * @param int upperBound
	 * @param Combination combination
	 * 
	 */
	public Lock(int upperBound, Combination combination){
		upper = upperBound;
		comb = combination;
		
		if(!comb.isWithinRange(upperBound)){
			throw new InvalidLockCombinationException();
		}
		if(comb.getNumbers().length < 3){
			throw new InvalidLockCombinationException();
		}
		isOpen = true;
	}
	/**
	 * Method returns an int representing the dials upper limit.
	 * 
	 * @return upper
	 */
	public int getDialLimit(){
		int tempUpper = upper;
		return tempUpper;
	}
	/**
	 * Method that receives a Combination and returns a boolean saying 
	 * if the lock is open or not. If the Combination equals the lock's 
	 * Combination, then it sets the lock's state to open.
	 *  
	 * @param Combination testComb
	 */
	public void open(Combination testComb){
		if(testComb.equals(comb)){
			isOpen = true;
		}
	}
	/**
	 * Method that sets the lock's state to closed and returns nothing
	 * 
	 */
	public void close(){
		isOpen = false;
	}
	/**
	 * Method that returns a boolean that indicates if the lock is open
	 * or not.
	 * 
	 * @return boolean isOpen
	 */
	
	public boolean isOpen(){
		return isOpen;
	}
	
	
	
	public void resetNaive() {
		String usrInput = JOptionPane.showInputDialog("Type a "
				+ "new combination");
		if(usrInput != null){
			Scanner scnr = new Scanner(usrInput);
			int aNum1 = scnr.nextInt();
			int aNum2 = scnr.nextInt();
			int aNum3 = scnr.nextInt();
			scnr.close();
			Combination newComb = new Combination(aNum1, aNum2, 
					aNum3);
			if(!newComb.isWithinRange(getDialLimit())){
				throw new InvalidLockCombinationException();
			}
			else{
				comb = newComb;
			}
		}
	}
	
	
	
	public void resetRetry() {
		boolean check = true;
		while(check == true){
			try{
				resetNaive();
				check = false;
			} catch(InvalidLockCombinationException e){
				JOptionPane.showMessageDialog(null, "Type 3 integers in the range [0.." 
						+ getDialLimit() + "]");
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "Type 3 integers separated by spaces");
			}
		}
	}
}
