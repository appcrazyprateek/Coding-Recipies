package blog.dp.knapsack;

public class KnapSack2 {
	 
	 int[] values;
	 int[] weights;
	 int capacity;  //max capacity allowed in knapsack
	 int numObjects;
	 Integer[][] matrix;  // matrix to for easy looks ups
	 
	 
	 
	 public KnapSack2(int[] values, int[] weights, int capacity) {
	   this.values=values;
	   this.weights=weights;
	   this.capacity=capacity;
	   this.matrix=new Integer[capacity+1][values.length + 1 ];
	   this.numObjects=values.length -1  ;
	 }
	 
	 /**
	  * KnapSack procedure, using table loopups to enhance performance
	  * @return max profit with given capacity
	  */
	 public int knapSack(int currentCapacity, int item) {
	  
	  if(item > numObjects) 
	  {
	   matrix [ currentCapacity ] [ item ] = 0;
	   return matrix [ currentCapacity ] [ item ]  ;
	  }
	  
	  if(currentCapacity < weights[item])  {   // current item is greater than remaing capacity , skip this current item
	   
	   if(matrix[currentCapacity] [item + 1] == null)
	    matrix[currentCapacity] [item + 1 ] = knapSack(currentCapacity, item+1) ;

	   return matrix[currentCapacity] [item + 1 ] ;
	  }
	  else
	  {
	   if(matrix[currentCapacity] [ item +1 ] == null)
	    matrix [currentCapacity ] [ item + 1] =  knapSack(currentCapacity, item+1) ;
	   
	   if(matrix [ currentCapacity - weights[item] ] [ item +1 ] == null)
	    matrix [ currentCapacity - weights[item] ] [ item +1 ] = knapSack(currentCapacity - weights[item], item+1);

	   return max(matrix [currentCapacity ] [ item + 1] , 
	            values[item] + matrix [ currentCapacity - weights[item] ] [ item +1 ] ) ;
	  }
	 }
	 
	 /**
	  * @return max value
	  */
	 private int max(int a , int b) {
	  return a > b ? a : b ;
	 }
	}
	//---------------------------------
