package com.vw;

public class ThreadRunnableEg  implements Runnable{

	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}		
	}

	public static void main(String[] args) {
		System.out.println("Main Started");
		ThreadRunnableEg mt = new ThreadRunnableEg();
		Thread t  = new Thread(mt);
		t.start();
		System.out.println("Main Ends");

	}

}
