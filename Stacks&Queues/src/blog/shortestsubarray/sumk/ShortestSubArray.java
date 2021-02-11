package blog.shortestsubarray.sumk;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k
 * @author rpratee
 *
 */
public class ShortestSubArray {

	public int shortestSubarray(int[] arr, int k) {
		int n = arr.length;
		int minLen = n + 1;
		int[] prefixSum = new int[n+1];
		prefixSum[0] = 0;
		for (int i = 0; i < n; i++) {
			prefixSum[i+1] = prefixSum[i] + arr[i];
		}
		
		Deque<Integer> dq = new LinkedList<>();
		for (int i = 0; i < n + 1; i++) {
			while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.getLast()]) {
				dq.pollLast();
			}

			while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.getFirst()] >= k) {
				int curLen = i - dq.pollFirst();
				minLen = Math.min(minLen, curLen);
			}
			dq.addLast(i);
		}
		return minLen == n + 1 ? -1 : minLen;
	}
}
