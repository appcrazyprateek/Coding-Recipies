package blog.matrix.misc;


public class Matrix {

	public static void main(String[] args) {
		
		int N=4;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				int k=i^j;
				if(j==(N-1))
					System.out.println(k);
				else
					System.out.print(k);
			}
		}
	}
	
}
