package com.amazon.ecp;

/*
 *  Java Program to Implement Queue using Two Stacks
 */
 
import java.util.*;
 
/* Class queueUsingStack */
public class OptimisedImplementationOfQueueUsingStack
{
    Stack<Integer> s ;
    Stack<Integer> tmp ;
 
    /* Constructor */
    public OptimisedImplementationOfQueueUsingStack()
    {
        s = new Stack<Integer>();
        tmp = new Stack<Integer>();
    }
    /*  Function to insert an element to the queue */
    public void insert(int data)
    {
        /* if no element is present in stack s then
         * push the new element to stack s */
    	
    	s.push(data);
    	
    	
    }
    public void remove(){
    
    	int stack1 = s.size();
    	int stack2 = tmp.size();
    if(stack1==0 && stack2==0)
    {
    	System.out.println("stack is empty");
    }
    else if((stack1!=0) && (stack2==0))
    {
    	
    	for(int i=stack1-1;i>=0;i--)
    	{
    		tmp.push(s.pop());
    	}
    	tmp.pop();
    }
    else if((stack1==0)&& (stack2!=0))
    {
    	tmp.pop();
    }
    else if((stack1!=0) && (stack2!=0))
    {
    	tmp.pop();
    }
    }
    
    public void display()
    {
        System.out.print("\nQueue = ");
        int l = s.size();
        int m = tmp.size();
        if (l == 0 && m==0)
            System.out.print("Empty\n");
        else if(l!=0 && m==0)
        {
            /* Printing from last index as if inserted in a Queue */            
            for (int i = l - 1; i >= 0; i--)
                System.out.print(s.get(i)+" ");                
            System.out.println();
        }
        else if(m!=0 && l==0){
        	/* Printing from last index as if inserted in a Queue */            
            for (int i = m - 1; i >= 0; i--)
                System.out.print(tmp.get(i)+" ");                
            System.out.println();
        }
        else if(l!=0 && m!=0)
        {
        	for (int i = l - 1; i >= 0; i--)
                System.out.print(s.get(i)+" ");                
            System.out.println();
            for (int i = m - 1; i >= 0; i--)
                System.out.print(tmp.get(i)+" ");                
            System.out.println();
        	
        }
    }
    
    public static void main(String[] args) {
    	OptimisedImplementationOfQueueUsingStack st= new OptimisedImplementationOfQueueUsingStack();
    	st.insert(1);
    	st.insert(2);
    	st.insert(3);
    	st.insert(4);
    	
    	st.display();
    	System.out.println("----------------------------------------------------");
    	
    	st.remove();
    	st.display();
    	System.out.println("----------------------------------------------------");
    	st.remove();
    	st.display();
    	System.out.println("----------------------------------------------------");
    	st.insert(5);
    	st.insert(6);
    	st.display();
    	System.out.println("----------------------------------------------------");
    	
    	st.remove();
    	st.remove();
    	st.display();
    	
    	st.remove();
    	st.display();
    	
    	st.insert(7);
    	st.insert(8);
    	st.display();
    	
    	st.remove();
    	st.display();
    	
    	st.remove();
    	st.display();
    	
    	st.remove();
    	st.display();
    	
    	st.remove();
    	st.display();
	}
    
}