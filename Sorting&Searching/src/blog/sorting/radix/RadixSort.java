package blog.sorting.radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Radix Sort
 * @author Prateek
 */
public class RadixSort {
	static Map<Integer,ArrayList<Integer>> bucket;
	
	public static void init(){
		bucket = new LinkedHashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<10;i++){
			bucket.put(i, new ArrayList<Integer>());
		}
	}
	//int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
	public static void radixSort(int[] arr , int maxDigits){
		init();
		for(int j=1;j<=maxDigits ; j++)
		{
			for(int i=0;i<arr.length;i++){
				int num = (int) (arr[i]%Math.pow(10, j)) ;
				
				num = (int) (num / Math.pow(10, j-1));
				
				ArrayList<Integer> list=bucket.get(num);
				list.add(arr[i]);
				bucket.put(num, list);
			}	
			copyFromBucketToArray(arr, bucket);
			init();
			System.out.println(Arrays.toString(arr));
			
			String s = "Prateek";
			char c = s.charAt(4);
		}
	}
	public static void copyFromBucketToArray(int[] arr, Map<Integer,ArrayList<Integer>> bucket) {
		int k=0;
		for(int i=0;i<10;i++) {
			List<Integer> list = bucket.get(i);
			for(int j=0;j<list.size();j++) {
				arr[k++]=list.get(j);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
		System.out.println("Unsorted --> " + Arrays.toString(arr));
		radixSort(arr, 3);
		System.out.println("Sorted --> " + Arrays.toString(arr));
	}
}
