package blog.queue.withstacks;
import java.util.Stack;
/**
 * Implement Queue operations using two stacks..
 * @author Parul
 */
public class QueueWithStacks  {

	private Stack<Integer> eStack = new Stack<Integer>(); // for enqeue operations
	private Stack<Integer> dStack = new Stack<Integer>(); // for deque operations

	/**
	 * Enqueue Operation
	 */
	public void enqueue(Integer item)  {
		System.out.println("Enqueue: " + item);
		eStack.push(item);
	}

	/**
	 * Dequeue Operation
	 * @return FIFO element
	 */
	public Integer dequeue() {
		if(dStack.isEmpty())
		{
			if(!eStack.isEmpty())
			{
				while(!eStack.isEmpty())
				{
					dStack.push(eStack.pop());
				}
			}
			else
			{
				System.out.println("Queue is Empty");
				return -1;
			}
		}
		int item=dStack.pop();
		System.out.println("Dequeue: " + item);
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
