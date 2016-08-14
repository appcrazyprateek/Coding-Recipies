package org.prateek.blog;

class SharedResource {
	static int count= 0;
	public static synchronized void staticShow(){
		System.out.println(Thread.currentThread().getName()+" : Static Starts ");
		count++;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : Static Ends ");
	}
	
	public synchronized void instanceShow(){
		System.out.println(Thread.currentThread().getName()+" : Instance Starts ");
		count++;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" : Instace Ends ");
	}
}


public class Locking implements Runnable{
	int i=0; 
	public static void main(String[] args) {
		Thread t1= new Thread(new Locking(),"1");
		t1.run();
		Thread t2= new Thread(new Locking(),"2");
		t1.run();
		
		System.out.println(SharedResource.count);
	}
	
	public synchronized void myStatic() throws InterruptedException
	{
		Thread.sleep(2000);
		i++;
	}
	
	public synchronized void myInstance1() throws InterruptedException{
		i++;
	}

	@Override
	public void run() {
		if(Thread.currentThread().getName().equalsIgnoreCase("1"))
			try {
				myStatic();
				myInstance1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
}
