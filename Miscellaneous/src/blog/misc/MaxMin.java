package blog.misc;


/*
 return minimum and maximum in an array. You program should make minimum number of comparisons.
*/
public class MaxMin {

	int pair[]=new int[2];
	public static void main(String[] args) {
		int arr[] = {1000, 11, 445, 1, 330, 3000,200, 123, 4567};

		MaxMin m=new MaxMin();
		Pair p=m.getMaxMin(arr, 0, arr.length-1);

		System.out.println("Min Element :"+p.min);
		System.out.println("Max Element :"+p.max);
	}

	public  Pair getMaxMin(int arr[] , int low , int high )
	{
		Pair mml,mmr;
		int mid;
		Pair minmax=new Pair();
		
		if(high==low)
		{
			minmax.min=arr[low];
			minmax.max=arr[low];
			return minmax;

		}
		else if(low+1==high)
		{
			if(arr[low] > arr[high])
			{
				minmax.min=arr[high];
				minmax.max=arr[low];
				return minmax;	
			}
			else
			{
				minmax.min=arr[low];
				minmax.max=arr[high];
				return minmax;		
			}
		}

		mid=(low+high)/2;
		mml=getMaxMin(arr,low,mid);
		mmr=getMaxMin(arr,mid+1,high);

		 /* compare minimums of two parts*/
		  if(mml.min < mmr.min)
		    minmax.min = mml.min;
		  else
		    minmax.min = mmr.min;    
		 
		  /* compare maximums of two parts*/
		  if(mml.max > mmr.max)
		    minmax.max = mml.max;
		  else
		    minmax.max = mmr.max;
		  
		return minmax;

	}

	class Pair
	{
		int min;
		int max;
	}

}
