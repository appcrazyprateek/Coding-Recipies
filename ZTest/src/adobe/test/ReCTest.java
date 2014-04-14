package adobe.test;

public class ReCTest {

	static int j =0;
	public static void main(String[] args) {
		fun(0, 6);
	}
	
	public static  void fun(int i,int N)
	{
		if(i==N) {
			return ;
		}
		System.out.println("Before " + i);
		i++;
		fun(i,N);
		int k =i;
		if (i==6)
		

		
		
		for ( i = i/2;i<= 3; i++)
		System.out.println("After " + k);
	}
	
}
