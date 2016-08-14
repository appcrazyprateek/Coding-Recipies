package blog.bt.segmentTree;

import java.util.Arrays;

//TODO:


//https://sites.google.com/site/mytechnicalcollection/algorithms/trees/segment-tree
//http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
//http://se7so.blogspot.in/2012/12/segment-trees-and-lazy-propagation.html
public class SegmentTree {

	static int[] tree= new int[200];
	
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
		constructSegmentTree(arr, 0, 0, arr.length-1);	
		
		System.out.println(Arrays.toString(tree));
	}

	private static int constructSegmentTree(int[] arr , int start , int curr , int end) {
		
		if(start==end)
			tree[curr]=arr[start];

		int mid = (start + end)/2 ;
		return tree[curr] = constructSegmentTree(arr, start, 2*curr+1, mid) 
				      + constructSegmentTree(arr, mid, 2*curr+2, end);
	}
	
}
