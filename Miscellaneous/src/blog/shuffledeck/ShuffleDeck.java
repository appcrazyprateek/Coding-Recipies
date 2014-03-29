package blog.shuffledeck;

import java.util.Random;
/**
 * Shuffle Deck of Cards
 * @author r.prateek
 */
public class ShuffleDeck {
	private int[] arr;

	public ShuffleDeck(int[] input) {
		this.arr=input;
	}

	/**
	 * Shuffle subroutine
	 */
	public void shuffle(){
		 Random randomGenerator = new Random();
		for(int i=0;i<arr.length;i++){
			int rand =randomGenerator.nextInt(i+1);
			swap(i,rand);
		}
		System.out.print("After Shuffling:  ");
		print();
	}
	
	private void swap(int i,int j){
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	/**
	 * Print Cards
	 */
	public void print(){
		for(Integer i:arr)
			System.out.print(i + "\t");
	}
	
	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,10};
		
		ShuffleDeck shuffle= new ShuffleDeck(input);
		System.out.print("Before Shuffling: ");
		shuffle.print();
		System.out.println();
		shuffle.shuffle();
	}
}
