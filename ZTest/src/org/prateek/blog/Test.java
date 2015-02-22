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
		 
		 //Test client
		 public static void main(String[] args) {
		// char[] input = {'A', 'B', 'A', 'C', 'C', 'C', 'Ç'};
			 char[] input = {'A', 'C', 'B', 'C', 'C', 'E', 'Ç'};
		 System.out.println(find(input));
		 }
}
