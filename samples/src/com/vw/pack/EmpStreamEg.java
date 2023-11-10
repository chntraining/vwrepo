package com.vw.pack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmpStreamEg {

	public static void main(String[] args) {
		Employee[] emparr = { new Employee("Sachin", "Tendulkar", "IT", 50000),
				new Employee("Amir", "Khan", "HR", 45000), 
				new Employee("MS", "Dhoni", "Sales", 60000),
				new Employee("Virat", "Koli", "Sales", 55000),
				new Employee("Karan", "Yadhav", "IT", 35000)

		};

		List<Employee> emplist = Arrays.asList(emparr);
		System.out.println(emplist);

		boolean result = emplist.stream().anyMatch(emp -> emp.getDept().matches("IT"));
		if (result) {
			System.out.println("Employees available");
		} else {
			System.out.println("NO Employees in this Dept");
		}

		Predicate<Employee> p1 = em -> (em.getSalary() > 40000 && em.getSalary() < 60000);
		emplist.stream().filter(p1)
		.sorted(Comparator.comparing(Employee::getFname))
		.forEach(System.out::println);
		
		
	    Map<String, List<Employee>> groupByDept=emplist.stream().collect(Collectors.groupingBy(Employee::getDept));
		System.out.println(groupByDept);
		
		groupByDept.forEach((dep,empInDept)->{
			System.out.println(" ** "+dep + "**");
//			Iterator<Employee> i = empInDept.iterator();
//			while(i.hasNext()) {
//				System.out.println(i.next());
//			}
			empInDept.forEach(System.out::println);
			
		});

	}

}
