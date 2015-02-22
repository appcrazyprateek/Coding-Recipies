package blog.math.atoi;
/**
 * Convert a String to an integer
 */
public class ATOI {
	
	public static void main(String[] args) {
		
		int val = atoi("-4545");
		System.out.println(val);
	}

	private static int atoi(String in) {
		
		if(in==null || (in=in.trim()).equals(""))
			return 0;
		
		int num=0, i =0 , len = in.length();
		boolean isPositive=true;
		
		if(in.charAt(0)== '-')
		{
			i++;
			isPositive=false;
		}
		
		while(i<len){
			char c =  in.charAt(i++);
			if(c >= '0' && c <= '9')
				num = num*10 + (c - '0');  //tricky: otherwise 48 offset will be added
			else
				return 0;
		}
		
		if(!isPositive)
			num=-num;

		return num;
	}
}
