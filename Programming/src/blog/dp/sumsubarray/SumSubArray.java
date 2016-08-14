package blog.dp.sumsubarray;

public class SumSubArray {

	int[] subArray(int S , int[] arr){

		int start=0;
		int[] temp=new int[arr.length];
		int sum=0;
		for(int i=0;i<arr.length ;i++) 
		{
			sum+=arr[i];
			temp[i]=arr[i];

			if(sum > S)
			{
				sum=sum- temp[start++] ;
			}
		}
		print(start, temp);
		return arr;

	}
	
	void print(int start, int[] temp){
		
		for(int i=start;i<temp.length ; i++) {
			System.out.println(temp[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = { 5, 4, 1, 2 , 6, 7, 1,2} ;
		
		SumSubArray s=new SumSubArray();
		s.subArray(11, arr);
	}
}
