package blog.kInSortedArrays;

/**
 * Find the Kth largest element in Sorted Arrays 
 * @author PRATEEK
 */
public class KthSmallestInSortedArrays {

	public static void main(String[] args) {
	
		int[] A= {0,1,3,4,5,6,8,11};
		int[] B= {2,7,9,10,12};
		int k=7;
		int num=findKthSmallest(A,B,k,0,A.length-1,0,B.length-1);
		System.out.println(num);
	}
	
	public static int findKthSmallest(int A[],int B[],int k, int aStart,int aEnd,int bStart,int bEnd)
	{
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
				
		if(aLen==0)
			return B[bStart+k];

		if(bLen==0)
			return A[aStart+k];
		
		if(k==0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart] ;
		
		int i= aLen * k /(aLen + bLen) ;
		int j = k-1 - i  ;
		
		i=i+aStart;
		j=j+bStart;

		if(A[i] > B[j])
		{
			k = k - (j-bStart +1 );
			aEnd = i;
			bStart=j+1;
			
		}
		else
		{
			k = k - (i-aStart +1 );
			aStart=i+1;
			bEnd= j;
			
		}
		return findKthSmallest(A,B,k,aStart,aEnd,bStart,bEnd);
	}
}
