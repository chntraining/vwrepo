package com.vw;
class ThreadA {
	
	public synchronized void print1to10() {
		
			try {
				for (int i = 1; i <= 5; i++) {
					System.out.println(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		
	}
}

class ThreadB extends Thread{
	ThreadA ta;
	
	public ThreadB(ThreadA ta) {
		this.ta =ta;
	}

	public void run() {
		ta.print1to10();
	}
}


public class MyThread  {
	
	public static void main(String[] args) {
		System.out.println("Main Started");
		
		ThreadA ta = new ThreadA();
		
		ThreadB mt1 = new ThreadB(ta);
		mt1.start();

		ThreadB mt2 = new ThreadB(ta);
		mt2.start();

		System.out.println("Main Ends");
	}

}
