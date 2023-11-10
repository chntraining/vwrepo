package com.vw;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEg {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("apple","banana","chikoo","cherry","grapes","cherry","dates");
		System.out.println("List of Fruits " + strList);
		
		
		System.out.println("List of Fruits " + strList.stream().filter(str -> str.length() == 5).collect(Collectors.toList()));

		List<String> ucstr = strList.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println("Upper str " + ucstr);
	
		List<String> sucstr = strList.stream()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Sorted Upper str " + sucstr);
		
		String confrunames = strList.stream().reduce((f1, f2) -> f1 + " # " +f2).orElse("");
		System.out.println("confrunames " + confrunames);
		
		int totallengthofwords = strList.stream().map(String::length).reduce(0, Integer::sum);
		System.out.println("totallengthofwords " + totallengthofwords);
		
		String firstword = strList.stream().filter(word -> word.startsWith("c")).findFirst().orElse("");
		System.out.println(firstword);
		
		List<String> fruitswithoutduplicates = strList.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println("fruitswithoutduplicates " + fruitswithoutduplicates);
	}

}
