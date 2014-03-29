package blog.interfaces.stackandQueue;


/**
 * Interface declaring the operations supported by a Stack
 * @author Prateek
 *
 * @param <T> : Type to the Elements to be inserted into Stack
 */
public interface IStack<T> {
	 void push(T item);
	 T pop();
	 T peek();
	 boolean isEmpty();
}
