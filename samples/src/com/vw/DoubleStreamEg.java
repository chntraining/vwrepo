package com.vw;

import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

public class DoubleStreamEg {

	public static void main(String[] args) {
		double[] values = { 1.1, 2.2, 3.3, 4.4, 5.5  };
		DoubleStream.of(values).forEach(System.out::println);

		double sum = calculateSum(values);
		System.out.println("Sum : " + sum);

		DoubleStream fval = filterValues(values, 3.0);
		fval.forEach(System.out::println);
		
		double avg = calcAvg(values);
		System.out.println("Avg : " + avg);

		DoubleSummaryStatistics stats = calculateStats(values);
		System.out.println("stats : " + stats);

	}

	private static DoubleSummaryStatistics calculateStats(double[] values) {
		
		return DoubleStream.of(values).summaryStatistics();
	}

	private static double calcAvg(double[] values) {
	
		return DoubleStream.of(values).average().orElse(0.0);
	}

	private static DoubleStream filterValues(double[] values, double d) {

		return DoubleStream.of(values).filter(v -> v > d);
	}

	private static double calculateSum(double[] values) {

		return DoubleStream.of(values).sum();
	}
	
	

}
