package blog.dp.knapsack;

/**
 * The KnapSack problem
 * @author r.prateek
 */
public class KnapSack1 {
	
	int[] values;
	int[] weights;
	int capacity;		//max capacity allowed in knapsack
	int numObjects;
	
	
	public KnapSack1(int[] values, int[] weights, int capacity)	{
			this.values=values;
			this.weights=weights;
			this.capacity=capacity;
			this.numObjects=values.length -1  ;
	}
	
	/**
	 * KnapSack procedure
	 * @return max profit with given capacity
	 */
	public int knapSack(int currentCapacity, int item)	{
		if(item > numObjects)
			return 0;
		
		if(currentCapacity < weights[item])     // current item is greater than remaing capacity , skip this current item
			return knapSack(currentCapacity, item+1);
		
		else
		{ 
            //System.out.println(1);
			int choice1 = knapSack(currentCapacity, item+1) ; // current item not chosen
			int choice2 = values[item] + knapSack(currentCapacity - weights[item], item+1);  // item chosen and knapsack called for other object with decreased remaining capacity 
			return max(choice1 , choice2);
		}
	}
	
	/**
	 * @return max value
	 */
	private int max(int a , int b)	{
		return a > b ? a : b ;
	}
}
