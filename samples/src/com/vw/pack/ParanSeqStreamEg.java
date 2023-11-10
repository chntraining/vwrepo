package com.vw.pack;

import java.util.Arrays;
import java.util.List;

public class ParanSeqStreamEg {

	private static void extendTime() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		long startTimeSeq = System.currentTimeMillis();
		seqTask(numbers);
		long stopTimeSeq = System.currentTimeMillis();
		System.out.println("Seq -Time Taken " + (stopTimeSeq - startTimeSeq));

		long startTimePar = System.currentTimeMillis();
		parTask(numbers);
		long stopTimePar = System.currentTimeMillis();
		System.out.println("Par -Time Taken " + (stopTimePar - startTimePar));

	}

	private static void parTask(List<Integer> numbers) {
		numbers.parallelStream().forEach(num -> {
			extendTime();
			System.out.println("Seq " + num);
		});

	}

	private static void seqTask(List<Integer> numbers) {
		numbers.stream().forEach(num -> {
			extendTime();
			System.out.println("Seq " + num);
		});
	}

}
