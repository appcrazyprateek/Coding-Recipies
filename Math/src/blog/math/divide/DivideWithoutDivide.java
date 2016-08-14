package blog.math.divide;

public class DivideWithoutDivide {
	public static void main(String[] args) {
		DivideWithoutDivide obj = new DivideWithoutDivide();
		System.out.println(obj.divide(100,-2));
		System.out.println(obj.divide(14,4));
	}
	
	public int divide(int dividend, int divisor) {
		if(divisor == 0)
			return Integer.MAX_VALUE;
		
		if (dividend == Integer.MIN_VALUE && divisor == -1)
		        return Integer.MAX_VALUE;
		
		return actualDivide(dividend,divisor);
	}
	
	/**
	 * 
	 * @param dividend : long variables instead on int so as to maintain precision
	 * @param divisor :  : long variables instead on int so as to maintain precision
	 * @return : division result
	 */
	public int actualDivide(long dividend , long divisor){
		
		boolean isPositive = true;
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
			 isPositive = false;
		
		dividend = Math.abs(dividend); //Make +ve if -ve
		divisor = Math.abs(divisor); //Make +ve if -ve
	    
		int result = (int) Math.floor(Math.exp(Math.log(dividend) - Math.log(divisor)));
		
		return isPositive ? result : -result;
		
	}
}
