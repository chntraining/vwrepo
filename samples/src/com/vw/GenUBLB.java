package com.vw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenUBLB {
	
	//Integer is the Lowerbound
	public static void addNumToList(List<? super Integer> list) {
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		System.out.println(list);
	}
	//Number is the Upperbound
	public static void sumAllNumber(List<? extends Number> list) {
		double d =0;
		for(Number n : list) {
			d=d+n.doubleValue();
		}
		System.out.println(d);
	}
	
	

	public static void main(String[] args) {
		List<Object> list1 = new ArrayList<>();
		addNumToList(list1);
		List<Integer> list2 = new ArrayList<>();
		addNumToList(list2);
		
		
		List<Integer> list3 = Arrays.asList(1,2,3);
		sumAllNumber(list3);
		List<Double> list4 = Arrays.asList(5.1,6.1,2.2);
		sumAllNumber(list4);

	}

}
