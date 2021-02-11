package blog.test;

import java.util.Stack;

public class Test {

	public static void main(String[] args) {
		
		Test o = new Test();
		o.f(1);
	}
	
	static int n;
	
	int f(int n) {
		if(n == 10)
			return n;
			
		System.out.println(n+"-->");
		int x = f(n+1);
		System.out.println(n+"-->" + x);
		return x;
		
		
		
	}
}
