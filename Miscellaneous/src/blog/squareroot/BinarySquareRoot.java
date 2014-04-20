package blog.squareroot;

public class BinarySquareRoot {

	public static void main(String[] args) {
		int out = findSquareRoot(64);
		System.out.println(out);
		
		 out = findSquareRoot(38);
			System.out.println(out);
			

			 out = findSquareRoot(99);
				System.out.println(out);
			
			
			out = test(64);
			System.out.println(out);
			
			 out = test(38);
				System.out.println(out);
				
				out = test(99);
				System.out.println(out);
	}

	public static int findSquareRoot(int num) {
		int low = 0, mid = 0, high = num;

		while (high > low) {
			mid = (high + low) / 2;
			System.out.println("main");
			if ((mid * mid >= num) && ((mid - 1) * (mid - 1) < num))
				return mid-1;

			else if (mid * mid < num) 
				low = mid + 1;
			
			else 
				high = mid - 1;
			
		}
		return mid -1 ;
	}

	
	public static int test(int n)
	{
		int low = 0, mid = 0, high = n;
				  high = n+1;
				  while (high -low > 1)
				  {
					  System.out.println("Test");
					  mid = (low+high) / 2 ;
				    if (mid*mid <= n)
					      low = mid;
					    else
					      high = mid ;
					  
				  }
				    
				  return low;
	}
}
