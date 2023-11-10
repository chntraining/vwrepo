package com.vw;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsing8 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("bat", "cat", "rat", "", "Eagle", "Lion", "", "Elephant");
		System.out.println("List of Strings " + strList);

		
		long count =strList.stream().filter(str->str.length() == 3).count();
		System.out.println("StringsWithLength3 " + count);
		
		long escount =strList.stream().filter(str-> str.isEmpty()).count();
		System.out.println("EmptyStringscount " + escount);
		
		
		List fstr =strList.stream().filter(str-> !str.isEmpty()).collect(Collectors.toList());
		System.out.println("StringsWithoutEmptyStrings " + fstr);
		
		String cstr =strList.stream().filter(str-> !str.isEmpty()).collect(Collectors.joining(" , "));
		System.out.println("Stringswithhypen " + cstr);
		
		List<Integer> intList = Arrays.asList(3, 8, 7, 4, 1, 9, 6, 2);
		System.out.println("List of integers " + intList);

		
		IntSummaryStatistics stat = intList.stream().mapToInt(num -> num).summaryStatistics();
		System.out.println(stat.getSum());
		System.out.println(stat.getMin());
		System.out.println(stat.getMax());
		System.out.println(stat.getAverage());
		System.out.println(stat.getCount());
		
		
		

	}

}
