package com.vw;

public class PrintThread implements Runnable{

	@Override
	public void run() {
		PrintingTask pt = new PrintingTask();
		pt.print();
		
	}
	

}
