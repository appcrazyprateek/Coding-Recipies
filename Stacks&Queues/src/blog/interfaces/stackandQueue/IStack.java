package blog.interfaces.stackandQueue;

public interface IStack {
	
	void push(int num) throws Exception;
	
	int pop() throws Exception;
	
	int peek();
	
	boolean isEmpty();
	
	boolean isFull();
	
	void print();

}
