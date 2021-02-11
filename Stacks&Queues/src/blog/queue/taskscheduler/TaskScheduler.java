package blog.queue.taskscheduler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Leetcode : 
   621. Task Scheduler
   https://leetcode.com/problems/task-scheduler/
 * @author Prateek
 *
 */
public class TaskScheduler {

	public static int getMinCount(char[] tasks, int k) {
		if (k == 0)
			return tasks.length;

		// this will record the count the task which appears maximum number of times
		int maxCount = 0;
		Map<Character, Integer> hash = new HashMap<>();

		// Step 1: Store in a map, character and its count
		for (char c : tasks) {
			// store character and its count
			int count = hash.getOrDefault(c, 0);
			hash.put(c, count++);

			// update max count
			maxCount = Math.max(maxCount, count);
		}

		// Step 2 : find the number of tasks with max count
		int maxCountTasks = 0;
		for (char c : hash.keySet()) {
			if (hash.get(c) == maxCount)
				maxCountTasks++;
		}

		// Step 3 : Calculate min time
		int result = (maxCount - 1) * (k + 1) + maxCountTasks;

		// Step 4 : this is an edge case where result from the above
		return Math.max(result, tasks.length);
	}

	public static void main(String[] args) {
		char[] tasks = {'A', 'B', 'C', 'A' , 'C' , 'D' , 'B' , 'A' , 'A'};
		int k = 3;
		//char[] task = {'A' , 'A' , 'B' , 'C' , 'D' , 'E', 'F' };
		//int k = 2;
		int ans = getMinCount(tasks, k);
		System.out.println("minimum interval is " + ans + " for input :" + Arrays.toString(tasks));
	}
}
