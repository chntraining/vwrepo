package com.vw;

interface MyInterface{
	 int x =80;
	 void display();
	 //Default Method
	 public default void showText() {
		 System.out.println("Good Afternoon");
	 }
}

public class MyClass implements MyInterface{

	public static void main(String[] args) {
		MyClass mc = new MyClass();
		mc.display();
		mc.showText();

	}

	@Override
	public void display() {
		System.out.println("From Display");
		
	}

}
