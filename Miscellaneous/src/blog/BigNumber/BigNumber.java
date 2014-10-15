package blog.BigNumber;

import java.util.Arrays;


public class BigNumber {

	private boolean isPositive=true;
	private long[] bigArray = null;
	private String num ;
	
	//private static int chunkSize = String.valueOf(Long.MAX_VALUE).length()-2;
	private static int chunkSize = 3;
	
	public BigNumber(String s) throws Exception {
		
		if(s==null || s.trim().equals(""))
			throw new Exception("Invalid Number");
		
		if(s.charAt(0)=='-')
		{
			isPositive=false;
			s = s.substring(1);
		}
		
		
		int len = s.length();
		int numChunks = len/chunkSize;
		if(len%chunkSize!=0)
			numChunks++;
		
			bigArray = new long[numChunks];
			int i=len;
			int c = bigArray.length-1;
			for(; i >= chunkSize ;i-=chunkSize)
				bigArray[c--]=Long.parseLong(s.substring(i-chunkSize, i));
			if(i>0)
				bigArray[c]=Long.parseLong(s.substring(0, i));
			
			num=s;
	}
	
	
	public BigNumber add(BigNumber b)
	{
		BigNumber result ;
		BigNumber smaller ;
		if(this.num.length() > b.num.length())
		{
			result = this;
			smaller = b;
		}
		else
		{
			result = b;
			smaller = this;
		}
		
		//Perform Addition
		long carry = 0L;
		int j= smaller.bigArray.length;
		int i= result.bigArray.length;
		for(;i>0 && j>0;i--,j--)
		{
			result.bigArray[i] += smaller.bigArray[j] + carry;
			
			//Get CARRY
			//carr
		}
		
		if(carry!=0)
		{
			result.bigArray[i] +=carry;
		}
		
		return b;
	}
	
	
	@Override
	public String toString() {
	
		return Arrays.toString(bigArray);
	}
	
	public static void main(String[] args) throws Exception {
		BigNumber b = new BigNumber("12345578");
		System.out.println(b);
	
	}
}
