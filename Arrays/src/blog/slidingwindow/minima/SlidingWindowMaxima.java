/**
 * 
 */
package blog.slidingwindow.minima;

import java.util.ArrayList;
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
	 * Dequeue was most suited DS in this problem
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
	public static ArrayList<Integer> findMixima(int[] arr, int w) {
		Integer[] result = new Integer[arr.length];
		int size = arr.length;

		// Dequeue will hold the indexes of the input arr
		Deque<Integer> deq = new LinkedList<Integer>();

		// Initialisation step, max element is inserted at the front
		for (int i = 0; i < w; i++) {
			while (!deq.isEmpty() && arr[i] >= arr[deq.peekLast()]) {
				deq.pollLast();
			}
			deq.offerLast(i);
		}

		for (int i = w; i < size; i++)
		{
			result[i - w] = arr[deq.peekFirst()]; // largest element is always
													// in front

			// Poll from back until the elements in the queue are smaller than
			// current element
			while (!deq.isEmpty() && arr[deq.peekLast()] < arr[i])
				deq.pollLast();
 
			// Poll elements from front if they are not in window frame
			while (!deq.isEmpty() && deq.peekFirst() <= i - w)
				deq.pollFirst();

			deq.offerLast(i); //push the current index to the last

		}
		result[size - w] = arr[deq.peekFirst()];

		return (ArrayList<Integer>) Arrays.asList(result);
	}

	public static void main(String[] args) {
		int[] arr= {1};
		int windowSize=1;
		System.out.println("Input: "+ Arrays.toString(arr));
	//	System.out.println("Output:"+ Arrays.toString(findMixima(arr, windowSize)));
		System.out.println(findMixima(arr, windowSize));
		
	}
}
