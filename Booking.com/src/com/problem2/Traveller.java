package com.problem2;

public class Traveller extends Thread {
  
	static boolean isIntterpt = false;
	
	@Override
	public void run() {
		while (!isIntterpt) {
			
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("ashdhashdhasd");
		}

	}
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
	
		
		
		StringBuilder sb1 = new StringBuilder("Amit");
		StringBuilder sb2 = new StringBuilder("Amit");
		String s = "Amit";
		System.out.println(sb1.equals(s));
		
		
		System.out.println(s.substring(3));
		
		
		
	
		
		int[] a = new int[4];
		
		Thread t  = new Traveller();
		t.start();
		Thread.sleep(5);
		isIntterpt = true;
		t.join();
	}
}
