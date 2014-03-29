package adobe.test;

public class Fib {

	public static void main(String[] args) {
		fib(0,1);
	}
	
	public static void fib(int a,int b)
	{
		int c= 0;
		while(c<10)
		{
			System.out.println(a);
			b = a+ (a =b);
			
			c++ ;
		}
	}
	
}
