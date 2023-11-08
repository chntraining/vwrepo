package com.vw;

import java.util.Comparator;

//Model  -- POJO
public class Employee implements Comparable<Employee> {

	private int empno;
	private String ename;
	private int salary;

	public Employee() {
		super();
		System.out.println("Employee Contructor");
	}

	public Employee(int empno, String ename, int salary) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee e) {

		return this.empno - e.empno;
	}

//	Employee e = new Employee();
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {

			return e1.ename.compareTo(e2.ename);
		}

	};
	
	public static Comparator<Employee> salComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {

			return e1.salary - e2.salary;
		}

	};

}
