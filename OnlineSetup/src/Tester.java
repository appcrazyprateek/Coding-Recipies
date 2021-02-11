

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Tester {
	
	public static void main(String[] args) throws InterruptedException {
		//headRecursion(1);
		//tailRecursion(1);
		  Random k = new Random();
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        System.out.println(k.nextInt(10));
	        
	        Collections.sort(null);
		
	}
	
	// 100, 99, 
	static void headRecursion(int n) {
		if(n > 5)
			return;
		
		headRecursion(n+1);
		System.out.println("Head----> " + n);
	}
	
	
	// 1, 2, 3, 4,5 
	static void tailRecursion(int n) {
		if(n > 5)
			return;
		
		System.out.println("tail----> " + n);
		tailRecursion(n+1);
	}
		
}
