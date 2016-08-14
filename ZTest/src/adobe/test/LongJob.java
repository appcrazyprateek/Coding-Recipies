package adobe.test;

public class LongJob {

	private static boolean intTask= false;
	
	private static class MyTask extends Thread {
		
		public void run(){
			while(!intTask){
				for(int i=0; i<10000000 ;i++)
				{
					//System.out.println(i);
					
				}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t= new MyTask();
		t.start();
		
		Thread.sleep(2000);
		intTask = true;
		
		t.join();
	}
}
