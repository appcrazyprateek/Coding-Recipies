package blog.queue.withstacks;
import java.util.Stack;
/**
 * Testing Versioning.. 
 * Implement Queue operations using two stacks..
 * @author Prateek
 */
public class QueueWithStacks  {

	private Stack<Integer> stack1 = new Stack<Integer>(); // for enqeue operations
	private Stack<Integer> stack2 = new Stack<Integer>();

	/**
	 * Enqueue Operation
	 * @throws InterruptedException : to given delay between operations so that it prints on console
	 */
	public void enqueue(Integer item) throws InterruptedException {
		Thread.sleep(10);
		System.out.println("Enqueue: " + item);
		stack1.push(item);
	}

	/**
	 * Dequeue Operation
	 * @return FIFO element
	 */
	public Integer dequeue() throws InterruptedException {
		Thread.sleep(10);
		if(stack2.isEmpty())
		{
			if(!stack1.isEmpty())
			{
				while(!stack1.isEmpty())
				{
					stack2.push(stack1.pop());
				}
			}
			else
			{
				System.err.println("Stack is Empty");
				return -1;
			}
		}
		int item=stack2.pop();
		System.err.println("Dequeue: " + item);
		return item;
	}

	public static void main(String[] args) throws InterruptedException {
		QueueWithStacks obj=new QueueWithStacks();
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.enqueue(4);
		obj.enqueue(5);
		obj.enqueue(6);
		obj.enqueue(7);
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
	}
}
