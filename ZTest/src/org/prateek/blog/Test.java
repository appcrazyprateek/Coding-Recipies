package org.prateek.blog;

public class Test {

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

}
