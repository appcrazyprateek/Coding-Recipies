package blog.dp.lcs;

/**
 * Longest Common Sequence
 * @author Prateek Rathore
 */
 public class LongestCommonSequnece {

	/**
	 * LongestCommonSequnece Subroutine
	 */
	public static int lcs(String s1, String s2){

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int[][] LCS = new int[Y.length +1 ][X.length +1 ];

		for(int i=1;i<=Y.length;i++)
		{
			for(int j=1;j<=X.length;j++)
			{
				if(Y[i -1 ]== X[j-1])
					LCS[i][j] = 1 + LCS[i-1][j-1];
				else
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}

		// Start Trace Back
		StringBuilder sb= new StringBuilder();
		int i=Y.length ;
		int j=X.length ;

		while(i > 0 && j>0)
		{
			//System.out.println(i + " " + j);
			if(Y[i-1] == X[j-1])
			{
				sb = sb.append(X[j-1]);
				i--;
				j--;
			}
			else
			{
				if(LCS[i][j-1]> LCS[i-1][j])  
					j--;
				else
					i--;
			}
		}

		System.out.println(sb.reverse());
		return LCS[Y.length][X.length];
	}
	
	public static void main(String[] args) {
		/*String s1= "ADBAVCEB";
		String s2= "ABACEB";*/

		String s1= "PRATEEK";
		String s2= "RATHORE";

		/*String s1= "DYNAMIC";
		String s2= "PROGRAMMING";*/
		
		/*String s1= "DILTOPAGALHAI";
		String s2= "PAGALPANTIHAI";*/
		
		System.out.println(lcs(s1.toUpperCase(),s2.toUpperCase()));
	}
}
