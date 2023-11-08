package com.vw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEg {

	public static void main(String[] args) {
		int[] intArr= {10,8,3,6,1,9,7};
		Arrays.sort(intArr);
		System.out.println(Arrays.toString(intArr));
		
		
		String[] strArr= {"Akhil","Zaina","John"};
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
		
		List<String> strList = new ArrayList<String>();
		strList.add("Manish");
		strList.add("Tara");
		strList.add("Yogesh");
		strList.add("Bala");
		Collections.sort(strList);
		System.out.println(strList);
		
		Employee[] empArr = new Employee[3];
		empArr[0] = new Employee(11, "Raja", 40000);
		empArr[1] = new Employee(15, "Savitha", 35000);
		empArr[2] = new Employee(12, "Ashish", 50000);
		
		
		Arrays.sort(empArr);
		System.out.println(Arrays.toString(empArr));
		
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(11, "Raja", 40000));
		empList.add(new Employee(25, "Savitha", 35000));
		empList.add(new Employee(12, "Ashish", 50000));
		Collections.sort(empList);
		System.out.println(empList);
		
		
		List<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(new Employee(101, "Rajam", 40000));
		empList2.add(new Employee(205, "Savi", 35000));
		empList2.add(new Employee(120, "Anish", 50000));
		Collections.sort(empList2,Employee.nameComparator);
		System.out.println(empList2);
		
		
		Collections.sort(empList2,Employee.salComparator);
		System.out.println(empList2);
	}

}
