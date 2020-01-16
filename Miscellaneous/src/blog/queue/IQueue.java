package blog.queue;

/**
 * Queue Interface that ADT supports
 * @author Prateek
 * @param <T>
 */
public interface IQueue<T> {
 /**
  * Inserts an item to Queue, pointed by Rear.
  * @param item
  */
  void enqueue(T item);

  /**
   * @return oldest element in the queue, pointer by front pointer
   */
  T dequeue();
  
  boolean isEmpty();
  
  /*return size of Queue*/
  int size();
  
  boolean isFull();
}