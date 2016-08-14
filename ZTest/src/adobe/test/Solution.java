package adobe.test;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Solution {
	
	public static void main(String[] args) {
		int[][] matrix = { 
				/*{0, 0, 1, 1, 1, 1 },
				{0, 0, 0, 0, 1, 1 },
				{0, 0, 0, 1, 1, 1 },
				{0, 0, 0, 0, 0, 1 },
				{0, 0, 1, 1, 1, 1 },
				{0, 0, 0, 1, 1, 1 },
				{0, 0, 0, 1, 1, 1 }*/
				{0}
		};
		
		//maxOnes(matrix,matrix.length);
		//getNum(13);
		//isPallindrome(12321);
		
		System.out.println(multiplyNumbers(3,2));
	}
	
	 static int maxOnes(int[][] a, int N){
		
		int max = -1;
		int maxRow = -1;
		for(int i=0;i<a.length;i++)
		{
			for(int j=max+1;j<a[0].length;j++)
			{
				if(a[i][j]==0)
				{
					max++;
					maxRow = i;
				}
				else
					break;
			}
		}
		System.out.println(max+1);
		return max+1;
	}
	 
	 public static int pow(int M,int N){
	       if(M == 0 || N == 0){
	           return 0;
	       }
	       if(N > 0){
	           return (M + pow(M,N-1));
	       }
	       if(N < 0){
	           return -pow(M,-N);
	       }  
	       return 0;
	   }
	 
	 /*public static long multiple(int M,int N){
	      if(N==1)
	    	  return M;
	      
	      return multiple(sum(M,M), N-1);
	   }*/
	 
	 
	 static int summations=0;
	 static long sum(long a,long b){
	 summations++;
	 return a+b;
	 }
	 static int multiplyNumbers(int M, int N){
		 /*
		 For your reference, a function of the prototype int sum(int,int); has already been defined.
		 When you're going to sum 2 numbers, use the above function. 

		 For instance to sum up M & N, you can call the function sum(M,N) and it would return M+N. 

		 Please avoid the usage of '+' operator and use the function instead

		 */
		    
		    if(N==1)
		        return M;
		    else if(N%2==0)
		        return (int) sum(multiplyNumbers(M,N/2),multiplyNumbers(M,N/2));
		    else
		        return (int) sum(sum(multiplyNumbers(M,N/2),multiplyNumbers(M,N/2)),M);
		 }
	
	 
	static int isSumPossible(Vector <Integer>a , int N)
	 {
		
		 Set <Integer> hash= new HashSet<Integer>();
		 Iterator<Integer> itr = a.iterator();
		    while (itr.hasNext()){
		    	hash.add(itr.next());
		    }
		    
		    itr = hash.iterator();
		    int isSumPossible=0;
		    while(itr.hasNext())
		    {
		    	int val = itr.next();
		    	if(hash.contains(N-val))
		    	{
		    		isSumPossible=1;
		    		break;
		    	}
		    }
		   
		return isSumPossible;
	 }
	 
	 
	 
	 static int isPallindrome(int a)
	 {
		 char[] val = (a+"").toCharArray();
		 int len = val.length;
		 int isPallindrome = 1;
		 
		 for(int i=0,j=len-1;i<len/2;i++,j--)
		 {
			 if(val[i] == val[j])
				 continue;
			 else
				 isPallindrome=0;
		 }
		 //System.out.println(isPallindrome);
		 return isPallindrome;
	 }
	 
	 
	static String getNum(int num)
	{
		int len = (num+"").length();
		
		String initval = "";
		BigInteger divisor = new BigInteger(num+"");
		
		for(int i=0;i<len;i++)
		{
			initval+="1";
		}
		
		BigInteger b = new BigInteger(initval);
		boolean notDone = true;
		while(notDone)
		{
			b = new BigInteger(b.toString()+"1");
			BigInteger remainder = b.mod(divisor);
			if(remainder.equals(BigInteger.ZERO))
			{
				notDone=false;
			}
		}
		
		System.out.println(b.toString());
		return b.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	   /*public static void main(String args[] ) throws Exception {
	           
	           int count = Integer.parseInt(args[0]);
	           
	           for(int i=0;i<count;i++)
	           {
	        	   int[] nums= new int[2];
	        	   String[] line = args[i+1].split(" ");
	        	   int j=0;
	        	   for(String val:line)
		               nums[j++]=Integer.parseInt(val);
	        	   
	        	   int product = multiply(nums[0],nums[1]);
	    	       System.out.println(product);
	        	   
	           }
	   }

	   
	   public static int multiply(int x,int y){
	       if(x == 0 || y == 0){
	           return 0;
	       }
	       if(y > 0){
	           return (x + multiply(x,y-1));
	       }
	       if(y < 0){
	           return -multiply(x,-y);
	       }  
	       return 0;
	   }
	
*/


}