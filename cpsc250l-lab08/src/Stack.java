import java.util.ArrayList;
import java.util.List;

/**
 * A generic LIFO Stack class built upon ArrayList.
 * 
 * @author Your Tyrannical Lab TA
 */
public class Stack<T> {
	private List<T> array = new ArrayList<T>(); // Where we store the Stack

	/**
	 * Pushes a value to the top of the stack.
	 * 
	 * @param value
	 *            The value to push.
	 */
	public void push(T value) {
		array.add(value);
	}

	/**
	 * Removes and returns the node at the top of the stack, assuming its there.
	 * 
	 * @return The node at the top of the stack.
	 */
	public T pop() {
		int last = array.size() - 1;
		return array.remove(last);
	}

	/**
	 * Returns whether or not the stack is empty.
	 * 
	 * @return True if the stack is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return array.isEmpty();
	}

	/**
	 * Outputs the stack as a String.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return array.toString();
	}
}