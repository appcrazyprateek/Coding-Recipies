package blog.rml.questions;

public class Prob1 {

	public static void main(String[] args) {
		Prob1 t= new Prob1();
		System.out.println(t.solve(40, 3));
			
	}

	int solve(int n, int m) {
		return safePosition(n, m, 1);
	}
	int safePosition(int n, int m, int startingPoint) {
		if(n == 1)
			return 1;
		int newSp = (startingPoint + m - 2) % n + 1;

		int survivor = safePosition(n - 1, m, newSp);
		if (survivor < newSp) {
			return survivor;
		} else
			return survivor + 1;
	} 
}
