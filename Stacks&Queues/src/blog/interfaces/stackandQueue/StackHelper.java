package blog.interfaces.stackandQueue;

public class StackHelper {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack(10);
		s.push(5);
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		s.push(6);
		s.push(7);
		s.pop();
		s.pop();
	}
}
