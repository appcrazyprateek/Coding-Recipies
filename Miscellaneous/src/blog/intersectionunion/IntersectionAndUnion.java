package blog.intersectionunion;

import java.util.Arrays;
/**
 * Intersection and Union of Arrays
 * @author Prateek
 */
public class IntersectionAndUnion {

	private int[] arr1;
	private int[] arr2;

	public IntersectionAndUnion(int[] arr1, int[] arr2) {
		this.arr1 =arr1;
		this.arr2 =arr2;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
	}

	public static void main(String[] args) {
		int[] arr1={7, 5, 4, 3, 1};
		int[] arr2= {2, 3, 5, 6};

		IntersectionAndUnion obj=new IntersectionAndUnion(arr1 , arr2);

		System.out.println("Union List: ");
		obj.union();

		System.out.println("Intersection List: ");
		obj.intersection();
	}

	/**
	 * Union Of arrays
	 */
	public void union()	{
		int i=0,j=0;
		while(i < arr1.length && j < arr2.length)
		{
			if(arr1[i] < arr2[j])
				System.out.print(arr1[i++]);
			else if(arr1[i] > arr2[j])
				System.out.print(arr2[j++]);
			else{
				System.out.print(arr1[i++]);
				j++;
			}
			System.out.print("\t");
		}

		if(arr2.length > arr1.length)
			for(;j<arr2.length;System.out.println(arr2[j]),j++);
		else if(arr2.length < arr1.length)
			for( ; i<arr1.length;System.out.println(arr1[i]),i++);
	}

	/**
	 * Intersection of Arrays
	 */
	public void intersection()	{
		int i=0;
		int j=0;
		while(i < arr1.length && j < arr2.length)
		{
			if(arr1[i] < arr2[j])
				i++;
			else if(arr1[i] > arr2[j])
				j++;
			else
			{
				System.out.print(arr1[i++] + "\t");
				j++;
			}
		}
	}
}
