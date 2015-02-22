import barclays.test.Solution;


public class Compliment {
	public static void main(String[] args) {}

	static String getWinner(int input1)
	{
		int i=1;
		int n= input1;
		while(n!=0)
		{
			if(n%2==0)
				n=n/2;
			else
			{
				int len= n+"".length();
				String temp= n+"";
				if(len%2==1)
				{
					n--;
				}
				else
				{
					long v1 = Long.parseLong(temp.substring(0, len/2));
					long v2 = Long.parseLong(temp.substring(len/2));
					if(v1>v2)
						n++;
					else
						n--;
				}
				
			}
			//System.out.println("N :" + n);
			i++;
		}
		
		//System.out.println(i);
		String lastVal = i%2==0 ? "Tushar" : "Ankush";
		return lastVal;
		
	}
	
	
	static int getIntegerCompliment(int n)
	{
		String s = Integer.toBinaryString(n);
		long i = Long.parseLong(s, 2);
	    long i2 = i ^ ((1L << s.length()) - 1);
	    String s2 = Long.toBinaryString(i2);
	    while (s2.length() < s.length()) s2 = '0' + s2;
	   // System.out.println(s2);
	    return Integer.parseInt(s2,2);
	}
}
