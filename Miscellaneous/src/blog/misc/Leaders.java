package blog.misc;

/*
Write a program to print all the LEADERS in the array. An element is leader if it is greater than
 all the elements to its right side. 
 For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2. 
  
  
 */
public class Leaders {

	public static void main(String[] args) {
		int arr[] ={16, 17, 4, 3, 5, 2};
		printLeaders(arr);
	}
	
	public static void printLeaders(int arr[])
	{
		System.out.println(arr[arr.length-1]);
		for(int j=arr.length-2 ; j>=0;j--)
		{
		   if(arr[j] < arr[j+1])
			  System.out.println(arr[j+1]);
		}
	}
}
