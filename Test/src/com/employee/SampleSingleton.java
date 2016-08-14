package com.employee;

public class SampleSingleton {

	public static final SampleSingleton instance = null;
	
	
	
	private SampleSingleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static SampleSingleton getInstance(){
			if(instance == null)
			{
				synchronized (SampleSingleton.class) {
					if(instance==null){
						
					}
				}
			}
		
		return null;
		
	}
	 
}
