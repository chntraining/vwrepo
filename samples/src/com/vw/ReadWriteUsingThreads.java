package com.vw;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class ReaderThread implements Runnable {
	private final BlockingQueue<String> queue;

	public ReaderThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.println("Enter data (or exit)");
			if (scn.hasNextLine()) {
				String input = scn.next();
				if ("exit".equals(input)) {
					try {
						queue.put(input);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
					break;
				}
	
				try {
					queue.put(input);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
		
			}
		}

	}

}

class WriterThread implements Runnable {

	private final BlockingQueue<String> queue;

	public WriterThread(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			FileWriter fw = new FileWriter("secfile.txt");
			while (true) {
				String data = queue.take();
				if ("exit".equals(data)) {
					break;
				}
				fw.write(data + "\n");
			}
			fw.close();
			System.out.println("Data is written in the file ");
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}

	}

}

public class ReadWriteUsingThreads {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

		Thread readerThread = new Thread(new ReaderThread(queue));
		readerThread.start();
		Thread writerThread = new Thread(new WriterThread(queue));
		writerThread.start();

		try {
			readerThread.join();
			writerThread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
