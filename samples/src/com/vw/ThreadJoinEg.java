package com.vw;

class Task implements Runnable {
	
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name  + " started ...");
			try {
				for (int i = 1; i <= 5; i++) {
					System.out.println(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(name  + " ends ...");
	}
}
public class ThreadJoinEg {
	
	public static void main(String[] args) {
		System.out.println("Main started ...");
		Task t = new Task();
		Thread t1 = new Thread(t,"Thread 1");
		Thread t2 = new Thread(t,"Thread 2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		System.out.println("Main ends ...");

	}

}
