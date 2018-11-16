import java.util.LinkedList;
import java.util.List;

/**
 * A generic FIFO Queue class.
 * 
 * @author The BEST Lab TA.
 */
public class Queue<T> {
	private List<T> list = new LinkedList<T>(); // The structure in which we
												// store the queue.

	/**
	 * Appends a value to the end of the queue.
	 * 
	 * @param value
	 *            The value to append.
	 */
	public void enqueue(T value) {
		list.add(value);
	}

	/**
	 * Removes and returns the value at the front of the queue, assuming it
	 * exists.
	 * 
	 * @return The value at the front of the queue.
	 */
	public T dequeue() {
		return list.remove(0);
	}

	/**
	 * Returns whether or not the queue is empty.
	 * 
	 * @return True if the queue is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Returns the queue in String representation.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return list.toString();
	}
}