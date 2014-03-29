package blog.sorting.radix;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Radix Sort
 * @author Prateek
 */
public class RadixSort {
	Map<Integer,ArrayList<Integer>> bucket;
	
	public void init(){
		bucket = new LinkedHashMap<Integer,ArrayList<Integer>>();
		for(int i=0;i<10;i++){
			bucket.put(i, new ArrayList<Integer>());
		}
	}
	
	public void radixSort(int[] arr , int maxDigits){
		int placeVal= 1 ;
	    
		for(int j=0;j<maxDigits ; j++)
		{
			for(int i=0;i<arr.length;i++){
				int num = (arr[i]/placeVal)%10 ;
				
				ArrayList<Integer> list=bucket.get(num);
				list.add(arr[i]);
				bucket.put(num, list);
				
			}	
		}
		
		
	}
	
	public static void main(String[] args) {
		
	}
}
