package blog.maths.traillingzeros;

public class TraillingZerosInFactorial {

	public static void main(String[] args) {
		System.out.println(trailingZeroCount(33));
	}

	private static int trailingZeroCount(int num) {
		int count = 0;
		if(num > 0)
			for(int i=5;i>=1;i*=5)
			   count += num / i;	
		return count;
	}
	
}
