
public class StackOverflow {

	public static void main(String[] args) {
		f(1);
	}
	
	
	static void f(int n) {
		String x = "";
		for(int i=0 ; i < Integer.MAX_VALUE;i++){
			x += "";
		}
	}
}
