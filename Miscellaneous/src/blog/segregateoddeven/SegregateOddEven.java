package blog.segregateoddeven;

public class SegregateOddEven {

	 static int arr[] = {12, 13, 45,8 , 9, 90, 40};
	 
	public static void main(String[] args) {
		segregate();
		display();
		
	}
	
	public static void display()
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + "     ");
	}
	public static void segregate()
	{
		int left=0,right=arr.length-1;
		while(left<right)
		{
			while(left<right && arr[left]%2==0)
			{
				left++;
			}
			
			
			while(left<right && arr[right]%2==1)
			{
				right--;
			}
			
			if(left<right)
			{
				swap(left,right);
				left++;
				right--;
			}
		}
	}
	
	public static void swap(int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
}
