package blog.stack.withqueue;

import java.util.LinkedList;
import java.util.Queue;

import blog.interfaces.stackandQueue.IStack;
/**
 * Implement Stack using Queues
 * @author Prateek
 */
public class StackwithQueues implements IStack<Integer>  {

	//for pushing data
	private Queue<Integer> queue1 = new LinkedList<Integer>();

	// used for reversing the data of queue1 and flipping of queues
	private Queue<Integer> queue2 = new LinkedList<Integer>();

	/**
	 * Push operation of Stack
	 * Item pushed into Queue1
	 */
	@Override
	public void push(Integer item) {
		System.out.println("Push : "+item);
		queue1.offer(item);
	}

	/**
	 * Pop operation of Stack
	 * last item of queue1 is returned, 
	 * order is reversed using queue2
	 */
	@Override
	public Integer pop() {
		Integer item=null;
		if(!queue1.isEmpty())
		{
			while (!queue1.isEmpty()) 
			{
				 item=queue1.poll();
				if(!queue1.isEmpty())
					queue2.add(item);
			}
			flip();
		}
		else
			System.out.println("Stack is Empty");
		System.out.println("Poped : "+ item);
		return item;
	}

	/**
	 * Peek operation, similar to pop , 
	 * with slight modification
	 */
	@Override
	public Integer peek() {
		Integer item=null;
		while (!queue1.isEmpty()) {
			 item=queue1.poll();
				queue2.add(item);
		}
		flip();
		System.out.println("Peek : "+ item);
		return item;
	}

	@Override
	public boolean isEmpty() {
		return queue1.isEmpty();
	}

	/**
	 * Flipping of Queues
	 */
	public void flip(){
		Queue<Integer> tQueue=  queue1;
		queue1=queue2;
		queue2 = tQueue;
	}

	public static void main(String[] args) {
		StackwithQueues obj=new StackwithQueues();
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.peek();
		obj.pop();
		obj.pop();
		obj.peek();
		obj.pop();
		obj.pop();
		obj.pop();
		
	}

}
