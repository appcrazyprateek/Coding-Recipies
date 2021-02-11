
public class Tets {

	public static void main(String[] args) {
		int[] arr = {3, 3, 2, 1, 4, 1, 2};
		
		int result = 0;
		for(int val : arr) {
			result ^=  val; 
		}
		System.out.println(result);
	}
}
