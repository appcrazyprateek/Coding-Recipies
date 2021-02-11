package blog.interfaces.stackandQueue;

public class Stack implements IStack {
	
	private int[] arr;
	private int top = -1;
	
	private static final int DEFAULT_CAPACITY = 5; 
	
	public Stack() {
		this.arr = new int[DEFAULT_CAPACITY];
	}
	
	public Stack(int size) {
		this.arr = new int[size];
	}
	
   /*
    * (non-Javadoc)
    * @see blog.interfaces.stackandQueue.IStack#push(int)
    */
	@Override
	public void push(int num) throws Exception {
		if(isFull()) {
			//throw new Exception("Stack overflow exception");
			doubleCapacity();
		}
		arr[++top] = num;
		System.out.println("Adding Item :" + num);
	}

	@Override
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is Underflow");
		}
		System.out.println("Removed Item : " + arr[top]);
		return arr[top--];
	}

	private void doubleCapacity() {
		int capacity = arr.length * 2;
		int[] cloneArray = new int[capacity];
		System.arraycopy(arr, 0, cloneArray, 0, arr.length);
		arr = cloneArray;
	}
	
	@Override
	public boolean isEmpty() {
		return top == -1 ? true : false;
	}

	@Override
	public int peek() {
		return arr[top];
	}
	
	public boolean isFull() {
		return top == arr.length -1; 
	}

	@Override
	public void print() {
		if(top == -1) {
			System.out.println("No elements in the stack!!");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.println(arr[i]);
		}
	}
}
