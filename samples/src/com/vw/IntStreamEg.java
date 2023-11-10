package com.vw;

import java.util.stream.IntStream;

public class IntStreamEg {
	
	public static void main(String[] args) {
		
		
		int[] values = {3,4,6,8,9,10,7,2,11};
		System.out.println(values);
		
		IntStream.of(values).forEach(System.out::println);
		
		System.out.println("COunt " + IntStream.of(values).count());
		System.out.println("Min " + IntStream.of(values).min().getAsInt());
		System.out.println("Max " + IntStream.of(values).max().getAsInt());
		System.out.println("sum " + IntStream.of(values).sum());
		System.out.println("avg " + IntStream.of(values).average().getAsDouble());
		
		System.out.println("**********************");
		IntStream.of(values).sorted().forEach(System.out::println);
		
		System.out.println("**********************");
		int[] val = {11,12,3,24,5};
		IntStream.of(val).filter(valu -> valu%2==0).forEach(System.out::println);
		
		System.out.println("**********************");
		System.out.println(IntStream.range(101, 315).count());
		System.out.println(IntStream.rangeClosed(1, 5).sum());
		
		
		System.out.println(IntStream.of(val).reduce(1, (x,y)->x+y));
	}

}     

//0+1 =1
//1+2 =3
//3+3 =6
//6+4 = 10
//10+5 =15






