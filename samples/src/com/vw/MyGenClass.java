package com.vw;

public class MyGenClass<T1,T2> {
	T1 name;
	T2 value;
	
	

	public MyGenClass(T1 name, T2 value) {
		super();
		this.name = name;
		this.value = value;
	}
	
	public T1 getName() {
		return name;
	}

	public T2 getValue() {
		return value;
	}
	
	public static<A,T> void displayDataType(A a,T t) {
		System.out.println(a.getClass().getName());
		System.out.println(t.getClass().getName());
	}

	public static void main(String[] args) {
		MyGenClass<String,Integer> mg = new MyGenClass<String,Integer>("Deepikkaa",10);
		System.out.println(mg.getName()  + "  " +mg.getValue());
		
		MyGenClass<Integer,Float> mg1 = new MyGenClass<Integer,Float>(100,15.15f);
		System.out.println(mg1.getName()  + "  " +mg1.getValue());
		
		Employee emp = new Employee();
		displayDataType("Kushal", 12);
		displayDataType('c', true);
		displayDataType(emp,15);
	}

}
