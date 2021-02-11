/**
 * 
 */
package blog.array.printduplicates;

/**
 * @author rpratee
 *
 */
public class FindDuplicates {

	
	public static void main(String args[]) {
		FindDuplicates duplicateInArray = new FindDuplicates();
		int a[] = {1,2,3,4,5,6,6,8,9,3,6,2,7,9,2};
		duplicateInArray.findDulicate(a);;

	}

	public void findDulicate(int a[]) {

		int arr_size = a.length; 
		int r = arr_size-1;
		int l = 0; 
		int count = 0;

		while (l<arr_size-1) {

			if(a[l]==a[r]) {
				++l;
				swap(l,r,a);
				r = arr_size-1;
				count++;
			}else if(r>l){
				r--;
			}
			if(l== r) {
				if(count>0) {
					System.out.println(a[l]);
				}
				count = 0 ;
				r = arr_size-1;
				l++;
			}
		}
	}
	
	void swap(int i, int j , int arr[]) {
	    	int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
	}
}
