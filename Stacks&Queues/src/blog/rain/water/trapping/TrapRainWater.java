package blog.rain.water.trapping;

import java.util.Stack;

public class TrapRainWater {

	public static void main(String[] args) {
		//int[] bars = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int[] bars = {3, 0, 0, 2, 0, 4};
		System.out.println(trapWaterUsingBrute(bars));
		System.out.println(trapWaterUsingDP(bars));
		System.out.println(trapWaterUsingStack(bars));
		System.out.println(trapWaterUsingPointers(bars));
	}
	

	//Using the two pointer based approach to trap water
	static int trapWaterUsingPointers(int[] height) {
		if(height == null || height.length < 3) 
	     		return 0;
		
		int l = 0, r = height.length-1; // Two pointers which will switched for movement 
		int lmax = height[0] , rmax = height[height.length-1];
		
		int trappedWater = 0;
		
		while (l < r) {
			if (height[l] < height[r]) {
				if (height[l] >= lmax) {  
					lmax = height[l]; //increment but dont count water
				} else {
					trappedWater += lmax - height[l];
				}
				l++;
			} else {
				if (height[r] >= rmax) {
					rmax = height[r];  //decrement but dont count water
				} else {
					trappedWater += rmax - height[r];
				}
				r--;
			}
		}
		return trappedWater;
	}
	
     //Stack based Approach to Trap rain water problem solution
     static int trapWaterUsingStack(int[] bars) {
    	 if(bars == null || bars.length < 3) 
     		return 0;
    	 
    	 Stack<Integer> stack = new Stack<>();
    	 stack.push(0);
    	 
    	 int len = bars.length, waterTrapped = 0;
    	 for(int i=1; i < len ; i++)
    	 {
    		 while(!stack.isEmpty() && bars[stack.peek()] < bars[i]) {
    			 int top = stack.pop();
    			 if(!stack.isEmpty()) {
    				 int dist = stack.isEmpty() ?  0 : i - stack.peek() - 1 ;
    				 int effectiveHeight = Math.min(bars[i], bars[stack.peek()]) - bars[top];
        			 waterTrapped += dist * effectiveHeight;
    			 }
    		 }
    		 stack.push(i);
    	 }
    	 return waterTrapped;
     }
     
     
 	// Brute Force Approach
 	static int trapWaterUsingBrute(int[] bars) {
 		int len = bars.length;
 		int trappedWater = 0;
 		for (int i = 1; i < len - 1; i++) {
 			int lmax = 0, rmax = 0;

 			for (int j = i - 1; j >= 0; j--)
 				lmax = Math.max(lmax, bars[j]);

 			for (int j = i + 1; j < len; j++)
 				rmax = Math.max(rmax, bars[j]);

 			trappedWater += Math.max(0, Math.min(lmax, rmax) - bars[i]);
 		}
 		return trappedWater;
 	}
     
      //Dynamic Programming Apporach to Trap rain water problem solution
      static int trapWaterUsingDP(int[] bars) {
     	if(bars == null || bars.length < 3) 
     		return 0;
     	
     	int len = bars.length, trappedWater = 0;
     	int[] left = new int[len];
     	int[] right = new int[len];
     	
     	//NB. for left most bar lmax would be 0, so counter is stated with 1,
     	for(int i=1;i<len;i++) 
     		left[i] = Math.max(left[i-1], bars[i-1]);
     	
     	// similarly for right most bar rmax would be 0 at len-1. 
     	for(int i= len -2 ;i >= 0;i--) 
     		right[i] = Math.max(right[i+1], bars[i+1]);
     	
     	
     	for(int i=0;i<len;i++)
     		trappedWater += Math.max(0, Math.min(left[i], right[i]) - bars[i]);
     	
     	return trappedWater;
     }
      
}
