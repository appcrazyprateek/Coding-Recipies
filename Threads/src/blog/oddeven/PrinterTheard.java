package blog.oddeven;

import java.util.concurrent.atomic.AtomicInteger;

public class PrinterTheard {




}


class EvenThread implements Runnable
{
	AtomicInteger num;
	Object lock;
	int max;
	
	public EvenThread(int max,Object lock,AtomicInteger num) {
		this.lock= lock;
		this.max=max;
		this.num=num;
	}
	
	@Override
	public void run() {
		display();
	}

	private void display() {
		while(num.get() < max)
		{
			if(num.get() % 2 ==0)
			{
				System.out.println(Thread.currentThread().getName()+" : " +    num.getAndIncrement());
				synchronized (lock) {
					notifyAll();
				}
			}
			else
			{
				synchronized (lock) {
					try{
						wait();
					}
					catch (InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
	}
}
