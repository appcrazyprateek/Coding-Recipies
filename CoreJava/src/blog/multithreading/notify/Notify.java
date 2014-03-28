package blog.multithreading.notify;

public class Notify {

	
	static class Job extends Thread {
        private int counter;

        @Override
        public void run() {
            synchronized(this) {
                for(int i = 0; i < 100000; i++)
                {	System.out.println(counter);
                    counter++;
                }
                    this.notify();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
       
    	 Job job = new Job();
        job.start();
        Thread.sleep(5);
        job.sleep(2000);
        synchronized(job) {
            job.wait();
        }
        
        System.out.println(job.counter);
    }
}
