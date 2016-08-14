package blog.stack.twostacks;
/**
 * Implement two stacks in an array of given size
 * @author Prateek
 */
public class TwoStacks {

	//private enum STACKS  {STACK1,STACK2}
	private int[] arr; // array holding 2 stacks
	private int size; // capaccity of 2 stacks
	private int top1; // top pointer of 1st stack
	private int top2; //  top pointer of 2nd stack

	public TwoStacks(int capacity) {
		this.arr=new int[capacity];
		this.size= capacity;
		this.top1=-1;
		this.top2=capacity;
	}

	
	/**
	 * Push Operation
	 * @param stackNum 0: 1st stack  , 1: 2nd stack
	 * @param data : data to be pushed
	 * @throws InterruptedException 
	 */
	public void push(int stackNum, int data) throws InterruptedException{
		Thread.sleep(10);
		if(stackNum==1){
			pushToStack1(data);
		}
		else if(stackNum==2)
			pushToStack2(data);
		else
			System.out.println("Invalid Stack Number");
	}
	
	public int pop(int stackNum) throws InterruptedException{
		Thread.sleep(10);
		if(stackNum==1)
			return popFromStack1();
		else if (stackNum==2)
			return popFromStack2();
		else{
			System.err.println("Invalid Stack");
			return -1;
		}
	}
	
	public int peek(int stackNum) throws InterruptedException{
		Thread.sleep(10);
		if(stackNum==1)
			return peekFromStack1();
		else if (stackNum==2)
			return peekFromStack2();
		else{
			System.err.println("Invalid Stack");
			return -1;
		}
	}
	/**
	 * Stack maintained from Left hand side of array
	 * stack beng pushed to stack from left to right
	 */
	private void pushToStack1(int data){
		if(top1+1 < top2){
			arr[++top1]=data;
			System.out.println("S1 Pushed: "+data);
		}

		else
			System.err.println("Stack 1 Overflow");
	}

	/**
	 * Stack maintained from right hand side of array
	 * stack beng pushed to stack from right to left
	 * @param data
	 */
	private void pushToStack2(int data){
		if(top1 < top2-1){
			arr[--top2]=data;
			System.out.println("S2 Pushed: "+data);
		}
		else
			System.err.println("Stack 2 Overflow");
	}

	/**
	 * Element poped from left hand side stack
	 * @return top element of left stack 
	 */
	private int popFromStack1(){
		if(top1!=-1){
			int val=arr[top1--];
			System.out.println("S1 Poped: "+ val);
			return val; 
		}

		System.err.println("Stack 1 is Empty");
		return -1;

	}

	/**
	 * Element poped from right hand side stack
	 * @return top element of right stack
	 */
	private int popFromStack2(){
		if(top2!=size){
			int val=arr[top2++];
			System.out.println("S2 Poped: "+ val);
			return val;
		}
		System.err.println("Stack 2 is Empty");
		return -1;
	}

	/**
	 * Peek from stack1's top element
	 * @return
	 */
	public int peekFromStack1(){
		if(top1==-1){
			System.err.println("Stack is Empty");
			return -1;
		}
		return arr[top1];
	}

	/**
	 * Peek from stack2's top element
	 * @return
	 */
	public int peekFromStack2(){
		if(top2==size){
			System.err.println("Stack is Empty");
			return -1;
		}
		return arr[top2];
	}

	public static void main(String[] args) throws InterruptedException {
		TwoStacks obj=new TwoStacks(6);
		obj.push(1,1);
		obj.push(2,99);
		obj.push(1,2);
		obj.push(1,3);
		obj.push(2,98);
		obj.pop(2);
		obj.pop(2);
		obj.push(2,97);
		obj.push(1,4);
		
		obj.push(2,96);
		obj.push(1,5);
		
		obj.pop(1);
		obj.pop(2);
		
		obj.pop(2);
		obj.pop(2);
		
	}
}
