package org.prateek.blog;

public class Test {
/*
	public static void main(String[] args) {
		Test t= new Test();
		System.out.println(t.josephus(40, 3));

	}


	int josephus(int n, int k) {
		return josephus(n, k, 1);
	}

	int josephus(int n, int k, int startingPoint) {
		if(n == 1)
			return 1;
		int newSp = (startingPoint + k - 2) % n + 1;

		int survivor = josephus(n - 1, k, newSp);
		if (survivor < newSp) {
			return survivor;
		} else
			return survivor + 1;
	}
*/
	
	private static char find(char[] input){
		 
		String s = "";
		 char result = ' ';
		 int counter = 0;
		 int seek = 0;
		 for(int i = 0; i < input.length; i++){
		     if(counter == 0){
		        result = input[i];
		        counter++;
		     } else if(result == input[i]) {
		          counter++;
		     } else {
		          counter--;
		     }
		   }
		 
		 System.out.println("Countr :"+counter);
		 //If the element occurs half times than we will not consider it as a majority element.
		 //It should be more than half time.
		 int check = 0;
		 for(int i = 0; i < input.length; i++){  if(result == input[i]){  ++check;  }  }  if(check >= (input.length) >> 1){
		      return result;
		 }
		 return 0;
		 }
	
	/*
	static int[] findMissingAndDuplicate(int[] arr, int n) {

	      int[] result = new int[2];
	      for(int i=0;i<n;i++)
	      {
	         int val = Math.abs(arr[i]);
	         if(arr[val - 1] < 0)
	         {
	            result[0] = val;
	         }
	         arr[val - 1] = -1 * arr[val -1];
	      }

	      for(int i=0;i<n;i++) {
	         if(arr[i] > 0 && i!= result[0]-1)
	         {
	            result[1] = i+1;
	         }
	      }
	      return result;
	}
	
		 
		 //Test client
		 public static void main(String[] args) {
			 	int[] arr = {1, 4, 6, 9, 3, 7, 5, 2, 5};
			 	System.out.println(Arrays.toString(arr));
			 	int[] result = findMissingAndDuplicate(arr, 9);
			 	System.out.println("Duplicate Element : " + result[0] );
			 	System.out.println("Missing Element : " + result[1] );
			 	
		 }*/

	
	
		 //Test client
		 public static void main(String[] args) {
		// char[] input = {'A', 'B', 'A', 'C', 'C', 'C', '�'};
			 //char[] input = {'A', 'C', 'B', 'C', 'C', 'E', '�'};
		 //System.out.println(find(input));
		 /*int i = 4;
		 System.out.println("i<<1/Multiple   --> " + (i << 1));
		 System.out.println("i>>1/Divide   --> " + (i >> 1));
		 System.out.println("1 << i   --> " + (1 << i));*/
		 
			 int count = countSetBits(7);
			 System.out.println("Number Set Bit : " + count);
		 
		 
		 }
		 
		 
		 static int countSetBits(int n) {
			 int count = 0;
			 while(n > 0)   
			 {
				 n = n & (n-1);
				count++;
			 }
			 return count;
		 }
		 
		 boolean checkPowerOf2(int n)
		 {
			 if(n == 0)
				 return false;
			 
			 n = n & (n-1);
			 
			 if(n==0)
				 return true;
			 
			 
			 else 
				 return false;
			 
		 }
		 
		 
		 
		 
}
