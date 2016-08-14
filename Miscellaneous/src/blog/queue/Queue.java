package blog.queue;

import java.util.Arrays;

/**
 * Queue Implementation
 * @author Prateek
 */
public class Queue {
	
	private static int DEFAULT_CAPACITY = 5;
	
	int front;
	int rear;
	int arr[];

	public Queue() {
		arr = new int[DEFAULT_CAPACITY];
		Arrays.fill(arr, -1);
		front = 0;
		rear = 0;
	}

	public Queue(int size) {
		DEFAULT_CAPACITY=size;
		arr = new int[DEFAULT_CAPACITY];
		Arrays.fill(arr, -1);
		front = 0;
		rear = 0;
	}
	
	/**
	 * Inserts data
	 */
	public void enqueue(int data) {
		rear = (rear) % (DEFAULT_CAPACITY);
		if (arr[rear] == -1) {
			arr[++rear] = data;
			System.out.println("Pushed: " + arr[rear - 1]);
		} else 
			System.out.println("Queue is Full");
	}

	/**
	 * Removes data
	 */
	public void dequeue() {
		int val = arr[front];
		arr[front] = -1;
		front++;
		System.err.println("Poped: " + val);
	}

	/**
	 * Display elements in the queue
	 */
	public void display() {
		System.out.print("Queue is : \t");
		int i = front;
		while (i <= DEFAULT_CAPACITY) {
			System.out.print(arr[i]+"\t");
			i = (i + 1) % DEFAULT_CAPACITY;
			if (i == rear)
				break;
		}
	}
}
