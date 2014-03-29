package adobe.test;

import java.util.ArrayList;
import java.util.List;

class base {
	@Override
	protected void finalize(){
		System.out.println("B");
	}
}


public class Test extends base{

	@Override
	protected void finalize(){
		System.out.println("D");
	}
	
	
	public void run(){
		
		try{
			Thread.sleep(1000);
		}
		catch(Exception e){
			
		}
		System.out.println("Hlll");
	}
	
	public static void main(String[] args) {
		
		int a = 	4;
		
		int b= 5;
		
		b= a + (a= b);
		
		System.out.println(a);
		System.out.println(b);
		
		
		System.out.println("==================");
		Test t= new Test();

		List<Integer> l1= new ArrayList<Integer>();
		l1.add(25);
		l1.add(35);
		
		List l2 = l1;
		l2.add("H");
		
		for(Object o: l2)
			System.out.println(o);
	}
	
}


