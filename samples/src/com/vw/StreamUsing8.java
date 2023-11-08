package com.vw;

import java.util.Arrays;
import java.util.List;

public class StreamUsing8 {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("bat", "cat", "rat", "", "Eagle", "Lion", "", "Elephant");
		System.out.println("List of Strings " + strList);

		
		long count =strList.stream().filter(str->str.length() == 3).count();
		System.out.println("StringsWithLength3 " + count);

	}

}
