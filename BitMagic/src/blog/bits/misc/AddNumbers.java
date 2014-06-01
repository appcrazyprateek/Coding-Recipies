package blog.bits.misc;

/**
 * Add two numbers without '+' operator refer:
 * http://en.wikipedia.org/wiki/Adder_%28electronics%29#Half_adder
 * 
 * @author PRATEEK
 */
public class AddNumbers {
	public static int add1(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}
		
		return a;
	}

	public static int add2(int a, int b) {
		if (b == 0)
			return a;
		else
			return add2(a ^ b, (a & b) << 1);
	}

	public static int add3(int a,int b){
		int carry= a & b;
		int sum= a ^ b;
		
		carry = 2* carry;
		
		sum = sum ^ carry;
		
		return sum;
		
	}
	
	public static int add4(int a,int b){
		return ( 2*( a & b) ) ^ (a ^ b);
		
	}
	
	public static void main(String[] args) {
		int val1=add1(5, 6);
		int val2=add2(5, 6);
		int val3=add3(5, 6);
		int val4=add4(5, 6);
		
		System.out.println(val1 + "  "+val2 + "  "+val3 + "  "+val4 + "  ");
	}
}
