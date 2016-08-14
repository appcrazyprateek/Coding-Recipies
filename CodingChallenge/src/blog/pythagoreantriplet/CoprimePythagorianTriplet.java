package blog.pythagoreantriplet;

import java.util.HashSet;
import java.util.*;

public class CoprimePythagorianTriplet {

	public static void main(String[] args) {
		
		int a = 12;
		int b= 5;
		int c=13;
		boolean isCoprimeTriplet = false;
		
		
		isCoprimeTriplet = isPythagoreanTriplet(a,b,c) && isCoprime(a,b,c) ;
		if(isCoprimeTriplet)
			System.out.println("YES");
		else 
			System.out.println("NO");
	}

	private static boolean isPythagoreanTriplet(int a, int b, int c) {
		int a2 = a*a, b2 = b*b, c2 = c*c;

		if(a >= Math.max(b, c))
		   return a2==b2+c2 ? true : false;
		else if (b >= Math.max(a, c))
			 return b2==a2+c2 ? true : false;
		else if (c >= Math.max(a, b))
			 return c2==b2+a2 ? true : false;
		return false;
	}

	private static boolean isCoprime(int a, int b, int c) {
		Set<Integer> hash  = new HashSet<Integer>();

		int i=2;
		boolean flag = true;
		for(;i<=a/2;i++)
		{
			if(a%i==0)
			 hash.add(i);
		}
		hash.add(a);
		
		i=2;
		for(;i<=b/2;i++)
		{
			if(b%i==0)
			flag= hash.add(i);
			
			if(flag==false)
				return false;
		}
		flag = hash.add(b);
		if(flag==false)
			return false;
		
		i=2;
		for(;i<=c/2;i++)
		{
			if(c%i==0)
			 hash.add(i);
			if(flag==false)
				return false;
		}
		flag = hash.add(b);
		if(flag==false)
			return false;
		
		return true;
	}
}
