package blog.median.sortedarrays;

public class FindMedian {

	public static void main(String[] args) {
		
		int[] i1={1,2,3,4,5};
		int[] i2={1,2};
	System.out.println(median(i1, i2));
	}

	
	public static int median(int input1[],int input2[])
	{
		// Lenth of auxillary Array
		int totLen=input1.length+input2.length;
		int temp[]=new int[totLen] ; 
		
		// merging sorted arrays
		int i = 0, j = 0, k = 0;
	    while (i < input1.length && j < input2.length)
	    {
	        if (input1[i] < input2[j])
	        {
	            temp[k] = input1[i];
	            i++;
	        }
	        else
	        {
	            temp[k] = input2[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < input1.length)
	    {
	        temp[k] = input1[i];
	        i++;
	        k++;
	    }

	    while (j < input2.length)
	    {
	        temp[k] = input2[j];
	        j++;
	        k++;
	    }
		
	    //if odd return middle element
		if(totLen%2 !=0)
		{
			return temp[(totLen)/2];
		}
		else // if even return average of middle elements
		{
			float  medianFloat = (float) ((temp[(totLen-1)/2] + temp[(totLen-1)/2 + 1])/2.0) ;
			int medianInteger=((temp[(totLen-1)/2] + temp[(totLen-1)/2 + 1])/2) ;
			
			if(medianFloat-medianInteger >= 0.5)
				medianInteger++;
			
			return  medianInteger;
		}
	}
}
