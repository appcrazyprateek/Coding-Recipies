import java.util.Arrays;
import java.util.Random;

public class Heapsort {

	public static void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = n / 2 - 1; i >= 0; i--) 
        	heapify(arr, n, i);
             
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
            // Move current root to end 
           swap(arr, i,0);
  
            // call max heapify on the reduced heap 
            heapify(arr, i, 0); 
        }
    } 
	
	static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
           swap(arr, i, largest);
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        }
        
    } 
	
	static void swap(int[] arr , int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	 public static void main(String args[]) 
	    { 
	        //int arr[] = {12, 11, 13, 5, 6, 7}; 
	        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
	        System.out.println("Unsorted Sorted array is---> " + Arrays.toString(arr));
	        
	        sort(arr); 
	  
	        System.out.println("Sorted array is---> " + Arrays.toString(arr)); 
	    } 

}
