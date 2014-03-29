package blog.misc;

import java.util.Scanner;

public class RotateArray {
	private static int arr[]={1,2,3,4,5,6,7};

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Number by which u want to rotate");
		int n=s.nextInt();


		rotateArray(n);
		display();
	}

	public static void rotateArray(int n)
	{
		for(int i=0;i<n;i++)
		{
			rotateByOne();
		}
	}

	public static void rotateByOne()
	{
		int temp=arr[0];
		for(int i=0;i<=arr.length-2;i++)
		{
			arr[i]=arr[i+1];
		}
		arr[arr.length-1]=temp;
	}


	private static void display()
	{
		System.out.println("Roated Array Is");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
	}
}
