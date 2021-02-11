package blog.queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Queue Implementation
 * 
 * @author Prateek
 */
public class Queue {

	private static int DEFAULT_CAPACITY = 5;

	int size;
	int front;
	int rear;
	int arr[];

	public Queue() {
		this.size = DEFAULT_CAPACITY;
		this.arr = new int[size];
		this.front = -1;
		this.rear = -1;
		this.size = DEFAULT_CAPACITY;
		Arrays.fill(arr, -1);
	}

	public Queue(int size) {
		this.size = size;
		this.arr = new int[size];
		front = -1;
		rear = -1;
		Arrays.fill(arr, -1);
	}

	/**
	 * Inserts data
	 * 
	 * @throws Exception
	 */
	public void enqueue(int data) throws Exception {
		if (isFull())
			throw new Exception("Queue is Full!!"); // or do a resize
		else {
			rear = (rear + 1) % size;
			arr[rear] = data;
			if (front == -1)
				front = rear;
			System.out.println("Enque -->" + data);
		}
	}

	/**
	 * Removes data
	 * 
	 * @throws Exception
	 */
	public int dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is Empty!!");
		else {
			int val = arr[front];
			if (front == rear)
				front = rear = -1;
			else
				front = (front + 1) % size;
			System.out.println("Dequeue ---> " + val);
			return val;
		}
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return (rear + 1) % size == front;
	}

	/**
	 * Display elements in the queue
	 */
	public void display() {
		String s ;
		if (isEmpty()) {
			System.out.println("Queue is Empty");
		}
		System.out.print("Queue is ---> \t");
		int i = front;
		while (true) {
			System.out.print(arr[i] + "\t");
			if(i == rear)
				break;
			i = (i + 1) % size;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		Queue q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.dequeue();
		q.dequeue();
		q.enqueue(6);
		q.enqueue(7);
		q.display();
	}
}
