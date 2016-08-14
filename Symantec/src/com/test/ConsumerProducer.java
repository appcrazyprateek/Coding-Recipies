package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Processor implements Runnable{

	private BlockingQueue<Runnable> queue ; 
	public Processor(BlockingQueue<Runnable> queue) {
		this.queue=queue;
	}

	@Override
	public void run() {
		
		while(true)
		{
			Runnable task;
			try {
				task = queue.take();
				if(task!=null)
					task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public BlockingQueue<Runnable> getQueue() {
		return queue;
	}
	
}

public class ConsumerProducer {

	private BlockingQueue<Runnable> queue = new  LinkedBlockingQueue<Runnable>();

	public ConsumerProducer(int numThreads)
	{
		 for(int i=0;i<numThreads;i++)
		 {
			 Runnable thread = new Processor(queue);
			 Thread t = new Thread(thread);
			 t.start();
		 }
	}
	
	private void addTask(Runnable task) {
		queue.offer(task);
	}
}
