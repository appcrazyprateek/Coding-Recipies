package blog.count.bits;

public class CountBits {

	
	public static void main(String[] args) {
		CountBits obj = new CountBits();
		int count = obj.numSetBits(00000101);
		System.out.println(count);
	}
	
	public int numSetBits(long num) {
		
		int count = 0;
		while(num > 0){
			if ( (num & 1) != 0)
		            count++;
			num >>= 1;
		}
		return count;
	}
}
