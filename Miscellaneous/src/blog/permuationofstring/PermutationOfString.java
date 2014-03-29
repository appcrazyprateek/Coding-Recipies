package blog.permuationofstring;
// Permutation of a String with duplicates
/**
 * @author Prateek
 */
 public class PermutationOfString{

	private char[] str=null; // to hold string data

	/**
	 * Takes the initial input
	 */
	public void printPermutations(String text){
		str=text.toCharArray();
		permutate(0,text.length()-1);
	}
	
	/**
	 * Subroutine to compute permutations
	 * @param index
	 * @param len
	 */
	private void permutate( int index, int len )
	{
		if( index == len )
			System.out.println((str));

		for(int i = index; i <= len; i++ )
		{
			if(!match(index, i)){ 
			swap(index, i );	
			permutate(index + 1 , len);
			swap( index, i );   
			}
		}
	}

	/**
	 * to check if any character matches between i and j
	 * @return if any characted match found
	 */
	private  boolean match(int i, int j) {
		if(i == j) 
			return false;
		else
			for(;i<j ; i++)
				if(str[i]==str[j])
					return true;
		return false;
	}
	
	public static void main(String[] a)	{
		String text="ABCD";
		PermutationOfString obj=new PermutationOfString();
		obj.printPermutations(text) ;
	}

	private  void swap(int a, int b)	{
		char temp=str[a];
		str[a]=str[b];
		str[b]=temp;
	}
}