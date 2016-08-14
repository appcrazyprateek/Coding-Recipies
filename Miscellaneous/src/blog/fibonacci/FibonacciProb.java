package blog.fibonacci;

public class FibonacciProb {

	private static int output1 = 0;
	private static int asciiConstant = 65;
	private static int[] intArr=new int[26] ;

	public static void main(String args[]){
		String input1 = "HELLO" ;
		letter(input1);
	}

	private static void letter(String input1) {
	
		generateFibArray();
		
		for (int i = 0; i<input1.length(); i++){
			output1 = output1 + getValueForChar(input1.charAt(i));
		}

		System.out.println("The sum is : "+output1);
	}
	private static void generateFibArray(){
		intArr[0] = 0;
		intArr[1] = 1;

		for(int i=2;i<26;i++){
			intArr[i] = intArr[i-1] + intArr[i-2];
		}
	}

	private static int getValueForChar(char c){
		int iFibValue = intArr[c-asciiConstant];
		return iFibValue;
	}

}
