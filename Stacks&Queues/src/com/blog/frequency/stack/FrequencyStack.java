package com.blog.frequency.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/maximum-frequency-stack/
public class FrequencyStack {
	//Frequency Map, Number and its corresponding count
    private Map<Integer,Integer> freq = new HashMap<>();
    private Map<Integer,Stack<Integer>> bucketStack = new HashMap<>();

    //Freq of an item in the stack which is most number of times
    int maxfreq = 0;
 
    public void push(int val) {
       //Step 1 : Update the Freq Map. 
    	if(freq.containsKey(val))
            freq.put(val,freq.get(val)+1);
        else
            freq.put(val,1);
        
        int count = freq.get(val);
        
        //Check if Bucket is created or not for that count
        if(!bucketStack.containsKey(count))
            bucketStack.put(count,new Stack<Integer>());

        //Get the stack from bucket and push the number
        bucketStack.get(count).push(val);
        
        //Step 3: Max Freq
        maxfreq = Math.max(count, maxfreq);
    }
    
    
    public int pop() {
    	
    	if(maxfreq < 1)
    		return Integer.MIN_VALUE;
    	
    	//Step 1 : GO to the bucket and remove element from stack
        int item = bucketStack.get(maxfreq).pop();
        
        //Step 2: Update freq Map by reducing by 1
        freq.put(item,freq.get(item) - 1);
        
        //Step 3:
        //if the bucket now has no elements in the stack., reduce Max Freq.
        if(bucketStack.get(maxfreq).isEmpty())
            maxfreq--;
        
        return item;
    }
    
    public static void main(String[] args) {
    	FrequencyStack obj = new FrequencyStack();
    	
    	obj.pushItem(5);
    	obj.pushItem(7);
    	obj.pushItem(5);
    	obj.pushItem(7);
    	obj.pushItem(4);
    	obj.pushItem(5);
    	
    	obj.popItem();
    	obj.popItem();
    	obj.popItem();
    	obj.popItem();
	}
    
    public void pushItem(int val)
    {
    	push(val);
    	System.out.println("Push --> " + val);
    }
    
    public void popItem() {
    	int val = pop();
    	System.out.println("Pop --> " + val);
    }
}