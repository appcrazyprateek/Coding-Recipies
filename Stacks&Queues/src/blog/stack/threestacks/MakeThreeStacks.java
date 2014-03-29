package blog.stack.threestacks;

import java.util.Arrays;

/**
 * divide the array into three stacks
 * @author Prateek
 */
public class MakeThreeStacks {

	private int stackSize=5;
	private	int[] tops={-1,-1,-1};
	private int[] arr=new int[stackSize * 3];

	/**
	 * Push operation
	 * @param stackNum : specifies the stack number
	 * @return: insertion status
	 * @throws InterruptedException 
	 */
	public boolean push(int stackNum, int item) throws InterruptedException{
		if(stackNum==0 || stackNum==1 || stackNum==2){
			int index= stackNum * stackSize + tops[stackNum] + 1;
			if(tops[stackNum] < stackSize -1 ){
				tops[stackNum]++;
				arr[index]=item;
				Thread.sleep(10);
				System.out.println(Arrays.toString(arr));
				return true;
			}
			else{
				System.err.println("Stack Full");
				return false;
			}
		}
		else
		{
			System.out.println("Invalid Stack Number");
			return false;
		}
	} 

	/**
	 * Pop operation
	 * @param stackNum: specifies the stack number
	 * @return the poped item
	 * @throws InterruptedException 
	 */
	public int pop(int stackNum) throws InterruptedException{
		if(stackNum==0 || stackNum==1 || stackNum==2){
			if(tops[stackNum]==-1)		{
				System.err.println("Stack is Empty");
				return -1;
			}
			int index= stackNum * stackSize + tops[stackNum];
			tops[stackNum]--;
			int item= arr[index];
			arr[index]=0;
			Thread.sleep(10);
			System.out.println(Arrays.toString(arr));
			return item;
		}
		else
		{
			System.out.println("Invalid Stack");
			return -9999;
		}
	}

	/**
	 * Peek operation
	 * @param stackNum: specifies the stack number
	 * @return top element of the specified stack
	 */
	public int peek(int stackNum){
		if(stackNum==0 || stackNum==1 || stackNum==2){
		if(tops[stackNum]==-1)		{
			System.out.println("Stack is Empty");
			return -1;
		}

		int index= stackNum * stackSize + tops[stackNum];
		return arr[index];
		}
		else
		{
			System.out.println("Invalid Stack");
			return -99999;
		}
	}


	public static void main(String[] args) throws InterruptedException {
		MakeThreeStacks stack=new MakeThreeStacks();
		stack.push(1, 1);
		stack.push(3, 2);
		stack.push(0, 3);
		stack.push(1, 4);
		stack.push(2, 5);
		stack.push(2, 6);
		stack.push(3, 7);
		stack.pop(0);
		stack.pop(1);
		stack.pop(0);
		stack.pop(2);
	}
}
