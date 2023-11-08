package com.vw;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class Person {
	private int num;
	private String name;

	public Person() {
		super();

	}

	public Person(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + "]";
	}
	
	public void printName(Person per) {
		System.out.println(per.getName());
	}
	
	public static void staticMethod(Person per) {
		System.out.println("From Static Method" + per.getNum());
	}

	public static void main(String[] args) {
		List<Person> plist = Arrays.asList(
				new Person(20, "Pradeep"), 
				new Person(21, "Vimal"), 
				new Person(24, "Arun"));
		
		Person person = new Person(50,"Asha");
		
		//person.printName();
		//Object Merthod Reference
		Consumer<Person> objectMr=person::printName;
		objectMr.accept(person);
		
		//Method Reference for static method
		Consumer<Person> objectSMr=Person::staticMethod;
		objectSMr.accept(person);
		
		//Method Reference for a COnstructor
		Supplier<Person> perSupplier = Person::new;
		Person newPerson = perSupplier.get();
		newPerson.setName("Kunal");
		System.out.println(newPerson.getName());
		
		
		//plist.forEach(li -> System.out.println(li));
		plist.forEach(System.out::println);
		
		//Collections.sort(plist, (p1, p2) -> p1.getNum() - p2.getNum());
		
		Collections.sort(plist, 
				(p1, p2) -> Integer.compare(p1.getNum(),p2.getNum()));
		plist.forEach(System.out::println);

	}

}
