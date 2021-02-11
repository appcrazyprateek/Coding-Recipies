/**
 * 
 */
package blog.slidingwindow.minima;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/**
 * Find the maximum for each and every continuous sub array of given window size
 * @author PRATEEK
 * 
 */
public class SlidingWindowMaxima {

	/**
	 * Dequeue was most suited DS in this problem, we can use heap based solution.
	 * following operations are performed
	 * 1. from Back
	 *       a. PollfromLast : if current element is larger than existing ones
	 *       b. PeekfromLast : to compare elements
	 *       c. OfferfromLast: insert current if the element is minimum than exisiting ones
	 * 2. from front
	 *      a. PollfromFirst:  if the element is no more in the window frame
	 *      b. PeekfromFirst: to get the largest element
	 *           
	 * @param arr: input array
	 * @param w : window size
	 * @return: max value in contiguous window sizes
	 */
	public static void findMixima(int[] arr, int w) {
		int size = arr.length;

		// Dequeue will hold the indexes of the input arr
		Deque<Integer> deq = new LinkedList<>();

		// Initialisation step, max element is inserted at the front. 
		//Remove elements from rear if the incoming element is greater than rear elements
		//until rear element is greater than incoming element
		for (int i = 0; i < w; i++) {
			
			//Step 3
			while (!deq.isEmpty() && arr[i] > arr[deq.peekLast()]) {
				deq.pollLast();
			}
			//Step 4
			deq.offerLast(i);
		}
		
		for (int i = w; i < size; i++)
		{
			//Step 1
			//Get the highest element from the front, (elements are in decending order)
			System.out.print("   "+arr[deq.peekFirst()]);

			//Step 2
			// remove elements from front if they are not in window frame
			while (!deq.isEmpty() && deq.peekFirst() <= i - w)
				deq.pollFirst();
			
			//Step 3
			// Poll from back until the elements in the queue are smaller than
			// current element
			while (!deq.isEmpty() && arr[i] > arr[deq.peekLast()])
				deq.pollLast();
			 
			//Step 4
			deq.offerLast(i); //push the current index to the last

		}
		//Maximum of Last window
		System.out.print("   "+arr[deq.peekFirst()]);
	}

	public static void main(String[] args) {
		//int[] arr= {7, 3, 11, 8, 9, 10, 2, 12, 23};
		int[] arr= {9, 6, 11, 8, 10, 5, 4, 13, 80, 15};
		int windowSize=4;
		System.out.println("Input: "+ Arrays.toString(arr));
		System.out.print("Output : ");
		findMixima(arr, windowSize);
	}
}
