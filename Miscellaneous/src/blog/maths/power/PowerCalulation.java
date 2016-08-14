package blog.maths.power;


/* Function to calculate x raised to the power y */
public class PowerCalulation {

	public static void main(String[] args) {

		System.out.println(cal(2, 3));
		System.out.println(calulate(2, 3));
		System.out.println(power(3,5));
	}


	public static int calulate(int base, int power)
	{
		if(power==0)
			return 1;
		else
			return base * calulate(base,power-1);
	}
	
	static int power(int base, int exp)
	{
		int result = 1;
		while(exp > 0)
		{
			if(exp%2 == 1)
			{
				result *= base; 
				exp --;
			}
				base = base*base;
				exp = exp /2;
		}
		return result;
		
	}
	
	public static int cal(int base,int power)
	{
		if(power==0)
			return 1;
		else
		{
			int result=1;
			for(int i=1;i<=power;i++)
				result*=base;
			return result;
		}
	}

}
