package blog.bits.misc;

public class CountSetBits {

	public static void main(String[] args) {
		checkIfPowerOf2(17);
	}
	
	static boolean checkIfPowerOf2(int x) {
		return x!=0 && ((x&(x-1)) == 0); 
	}
	
	public void countSetBits(int n) {
		
	}
}
	