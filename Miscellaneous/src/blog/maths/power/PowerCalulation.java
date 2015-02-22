package blog.maths.power;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* Function to calculate x raised to the power y */
public class PowerCalulation {

/*	public static void main(String[] args) {

		System.out.println(cal(2, 3));
		System.out.println(calulate(2, 3));
	}*/


	public static int calulate(int base, int power)
	{
		if(power==0)
			return 1;
		else
			return base * calulate(base,power-1);
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
