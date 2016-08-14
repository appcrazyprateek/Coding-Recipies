package blog.replacewithrestproduct;

import java.util.Arrays;
/**
 * Replace each element by product of rest of array, 
 * Constraint: division operation can't be used
 * @author PRATEEK
 *
 */
public class ReplaceWithProduct {

	static int[] arr = {2 , 4, 1, 2, 3};
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solve(arr)));
	}
	
	/**
	 * Replace element with product of other elements in the array
	 */
	public static int[] solve(int[] arr)
	{
		if(arr!=null)
		{
			int size =arr.length;
			int[] leftCummulative = new int[size] , righttCummulative = new int[size];
			
			//Left cumulative Multiplication Calculation
			int i=1;
			leftCummulative[0] = 1;
			for(; i<size ; i++)
				leftCummulative[i] =  arr[i-1]  * leftCummulative[i-1];
			
			
			//Right cumulative multiplication calculation
			i=size-1;
			righttCummulative[i]=1;
			for( ; i>0 ; i--)
				righttCummulative[i-1]  =  arr[i] * righttCummulative[i];
			
			//Populating array with result
			for(i=0 ; i<size ; i++) 
				arr[i] = leftCummulative[i] * righttCummulative[i];
		}
		
		return arr;
	}
	
}
