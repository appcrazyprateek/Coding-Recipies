package blog.randomnumber;

import java.util.Random;

public class RandomNumber {
	
		  public static final void main(String... aArgs){
			  System.out.println("Generating 10 random integers in range 0..99.");
		    
		    //note a single Random object is reused here
		    Random randomGenerator = new Random();
		    for (int idx = 1; idx <= 5; ++idx){
		      int randomInt = randomGenerator.nextInt(100);
		      System.out.println("Generated : " + randomInt);
		    }
		  }
}
