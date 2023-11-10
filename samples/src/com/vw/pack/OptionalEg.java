package com.vw.pack;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEg {

	public static void main(String[] args) {

		List<String> strList = Arrays.asList("apple","banana","chikoo","cherry","grapes","cherry","dates");
		System.out.println("List of Fruits " + strList);
		
		String  str = getAllStringValues(strList);
		System.out.println("str " + str);
	}

	private static String getAllStringValues(List<String> strList) {
		
		Optional<String> str = strList.stream().filter(st -> st.startsWith("b")).findFirst();
		
		return str.isPresent() ? str.get() : "No String Present";
	}

}
