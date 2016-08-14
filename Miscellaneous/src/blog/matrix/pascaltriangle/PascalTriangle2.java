package blog.matrix.pascaltriangle;

public class PascalTriangle2 {


	public static void main(String[] args) {
		PascalTriangle2 b=new PascalTriangle2();
		b.printTriangle(5);
		//b.print(5);
	}

	public void printTriangle(int n)
	{
		for(int line=0;line<n;line++)
		{
			for(int i=0;i<=line;i++)
			{
				System.out.print(calculateBinomial(line,i)+"\t");
			}
			System.out.println();
		}
	}



	/* 2nd Method
	 C(line, i)   = line! / ( (line-i)! * i! )
C(line, i-1) = line! / ( (line - i + 1)! * (i-1)! )
We can derive following expression from above two expressions.
C(line, i) = C(line, i-1) * (line - i + 1) / i

So C(line, i) can be calculated from C(line, i-1) in O(1) time
	 */
	public void print(int n)
	{
		
		for(int line=1;line<=n;line++)
		{
			int result =1;
			for(int i=1;i<=line;i++)
			{
				System.out.print(result+"\t");
				result=result*(line-i)/i;
				
			}
			System.out.println();
		}

	}
	public int calculateBinomial(int n, int r)
	{
		int result=1;

		if(r>n-r)
			r=n-r;
		for(int i=0;i<r;++i)
		{
			result*=(n-i);
			result/=(i+1);
		}
		return result;
	}
}
