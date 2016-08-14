package com.indix;

import java.util.Arrays;

public class Tester {
	
	public static void main(String[] args) throws InterruptedException {
		testCase1();
		Thread.sleep(100);
		testCase2();
		Thread.sleep(100);
		testCase3();
		Thread.sleep(100);
		testCase4();
		
	}
	
	public static void testCase1()
	{ 
		int low = 1;
		int high = 20;
		int[] blocked= {18,19};
		int[] view = {15,14,17,1,17};
		TVRemote obj= new TVRemote(low, high, blocked, view);
		int clicks= obj.solve(low, high, view);
		System.err.println("******Test Case 1 *******");
		System.out.println("low :"+low +"    high : "+high);
		System.out.println("Blocked : " + Arrays.toString(blocked));
		System.out.println("Channels : " + Arrays.toString(view));
		System.out.println("Clicks : "+clicks);
		
	}
	
	public static void testCase2()
	{ 
		int low = 103;
		int high = 108;
		int[] blocked= {104};
		int[] view = {105,106,107,103,105};
		TVRemote obj= new TVRemote(low, high, blocked, view);
		int clicks= obj.solve(low, high, view);
		System.err.println("******Test Case 2 *******");
		System.out.println("low :"+low +"    high : "+high);
		System.out.println("Blocked : " + Arrays.toString(blocked));
		System.out.println("Channels : " + Arrays.toString(view));
		System.out.println("Clicks : "+clicks);
	}
	
	public static void testCase3()
	{ 
		int low = 1;
		int high = 100;
		int[] blocked= {78,79,80,3};
		int[] view = {10,13,13,100,99,98,77,81};
		TVRemote obj= new TVRemote(low, high, blocked, view);
		int clicks= obj.solve(low, high, view);
		System.err.println("******Test Case 3 *******");
		System.out.println("low :"+low +"    high : "+high);
		System.out.println("Blocked : " + Arrays.toString(blocked));
		System.out.println("Channels : " + Arrays.toString(view));
		System.out.println("Clicks : "+clicks);
	}
	
	public static void testCase4()
	{ 
		int low = 1;
		int high = 200;
		int[] blocked= {};
		int[] view = {1,100,1,101};
		TVRemote obj= new TVRemote(low, high, blocked, view);
		int clicks= obj.solve(low, high, view);
		System.err.println("******Test Case 4 *******");
		System.out.println("low :"+low +"    high : "+high);
		System.out.println("Blocked : " + Arrays.toString(blocked));
		System.out.println("Channels : " + Arrays.toString(view));
		System.out.println("Clicks : "+clicks);
	}
	
}
