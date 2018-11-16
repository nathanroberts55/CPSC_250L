/**
 * A class for representing a candy.
 * 
 * @author Your candy-loving TA.
 */
public class Candy {
	private final String flavor; // A string that contains the flavor of the
									// candy.

	/**
	 * Constructs a Candy object.
	 * 
	 * @param _flavor
	 *            The flavor of the Candy.
	 */
	public Candy(String _flavor) {
		flavor = _flavor;
	}

	/**
	 * Returns the flavor of the Candy.
	 * 
	 * @return The flavor of the Candy.
	 */
	@Override
	public String toString() {
		return flavor;
	}

	/**
	 * Determines if another object equals this candy.
	 * 
	 * @param obj
	 *            The object to which we compare this.
	 * @return True if obj is a Candy and its flavor equals this flavor, false
	 *         otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && this.getClass() == obj.getClass()) {
			Candy other = (Candy) obj;
			return flavor.equals(other.flavor);
		}
		return false;
	}
}
