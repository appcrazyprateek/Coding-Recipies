package blog.sorting.quicksort;

import java.util.Stack;

public class IterativeQuickSort {

	Object b;
	public static void main(String[] args) {
		 int[] arr={ 3,1,4,5,2 };
		IterativeQuickSort obj = new IterativeQuickSort();
		
		System.out.println(obj);
		//obj.sort(arr);
		
	}

	private void sort(int[] arr, int low , int high ) {
		int pivot = arr[high];
		Stack stack = new Stack();
		stack.push(low);
		stack.push(high);
		
		partition( arr,  low ,  high);
	}

	private void partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		
		for(int i=low; i< high;i++){
			
		}
		
		
		
		
		
	}
	
	@Override
	public String toString() {
		return "hello";
	}
	
	
	
	
}
