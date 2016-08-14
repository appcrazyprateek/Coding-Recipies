package blog.maths.atoi;
/**
 * Convert a String to an integer
 */
public class ATOI {
	
	public static void main(String[] args) {
		
		System.out.println(atoi(" -88297 248252140B12 37"));
		System.out.println(atoi(" 75 6 "));
		System.out.println(atoi("+349A756"));
	}

	public static int atoi(String in) {
		int radix = 10;
		int limit = Integer.MAX_VALUE;
		int multiplicationLimit = limit / radix;
		
		if(in==null || (in=in.trim()).equals(""))
			return 0;
		
		int result=0, i =0 , len = in.length();
		boolean isPositive=true;
		
		if (in.charAt(0) == '-') {
			i++;
			isPositive = false;
		} else if (in.charAt(0) == '+') 
			i++;
		
		while(i<len){
			char c =  in.charAt(i++);
			if(c >= '0' && c <= '9')
			{
				int digit  =  (c - '0');
				if(result < multiplicationLimit) 
					result = result * radix + digit;
				else   //result overflowing
				{
					if(isPositive)
						return Integer.MAX_VALUE;
					else
						return Integer.MIN_VALUE;
				}
			}
			else
			  break;
		}
		
		if(!isPositive)
			result=-result;

		return result;
	}
}
