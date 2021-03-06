package com.multithreading.threads;

/**
 * Below code can have too many loop holes on why the result never gets to 20,000.
 * 1) t1 and t2 threads need to be allowed to finish before printing count. We do that by join() method called on threads.
 * 2) Above will help improve a bit but then variable count needs to be volatile so each thread picks up latest data from shared object.
 * 3) We need to synchronize the operations done by creating one or more locks. This will stop threads interleaving and fix all issues. 
 * We can fix # 3 issue above by creating another synchronized method increment() which increments count variable and have threads call that.
 *
 */
public class JoinOnThreadDemo {

	// volatile makes the threads read latest values of a variable before doing any operations
	private volatile int count;
	private Object lock = new Object();

	public static void main(String[] args) {
		
		new JoinOnThreadDemo().doWork();
		
	}
	
	public void incrementCount() {
		synchronized (lock) {
			count++;	
		}
	}

	public void doWork() {

		Thread t1 = new Thread(() -> {
			for (int i=0; i<10000; i++) {
				//count++;
				incrementCount();
			}	
		});
		
		Thread t2 = new Thread(() -> {
			for (int i=0; i<10000; i++) {
				//count++;
				incrementCount();
			}	
		});
		
		// join() method on threads helps makes the main thread wait till a thread finishes executing
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Will expect this to be 200, right? You will likely get very different results because threads need to finish first!
		System.out.println("count: " + count);

	}

}
