package com.vw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamUsing7 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("bat", "cat", "rat", "", "Eagle", "Lion", "", "Elephant");
		System.out.println("List of Strings " + strList);
		long count = 0;
		count = getStringsWithLength3(strList);
		System.out.println("StringsWithLength3 " + count);

		count = getEmptyStringCount(strList);
		System.out.println("getEmptyStringCount " + count);

		List filteredStr = getStringsWithoutEmptyString(strList);
		System.out.println("getStringsWithoutEmptyString " + filteredStr);

		List<Integer> intList = Arrays.asList(3, 8, 7, 4, 1, 9, 6, 2);
		System.out.println("List of integers " + intList);

		int sum = getSumOfNumbers(intList);
		System.out.println("Sum  of integers " + sum);

		int min = getMinValue(intList);
		System.out.println("min  number" + min);

		int max = getMaxValue(intList);
		System.out.println("max  number" + max);
	}

	private static int getMaxValue(List<Integer> intList) {
		int max = intList.get(0);
		for (int i = 1; i < intList.size(); i++) {
			Integer num = intList.get(i);
			if (num.intValue() > max) {
				
				max = num.intValue();
			}
		}

		return max;
	}

	// 1,3,8,7,4,9,6,2
	private static int getMinValue(List<Integer> intList) {
		int min = intList.get(0);
		for (int i = 1; i < intList.size(); i++) {
			Integer num = intList.get(i);
			if (num.intValue() < min) {
				min = num.intValue();
			}
		}

		return min;
	}

	private static int getSumOfNumbers(List<Integer> intList) {
		int sum = intList.get(0);

		for (int i = 1; i < intList.size(); i++) {
			sum += intList.get(i);
		}

		return sum;
	}

	private static List getStringsWithoutEmptyString(List<String> strList) {
		List filteredStr = new ArrayList<>();

		for (String str : strList) {
			if (!str.isEmpty()) {
				filteredStr.add(str);
			}
		}

		return filteredStr;
	}

	private static long getEmptyStringCount(List<String> strList) {
		long count = 0;

		for (String str : strList) {
			if (str.isEmpty()) {
				count++;
			}
		}

		return count;
	}

	private static long getStringsWithLength3(List<String> strList) {
		long count = 0;

		for (String str : strList) {
			if (str.length() == 3) {
				count++;
			}
		}

		return count;
	}

}
