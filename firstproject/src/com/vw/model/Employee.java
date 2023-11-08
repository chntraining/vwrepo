package com.vw.model;

import java.io.Serializable;
import java.util.Comparator;



//Model  -- POJO
public class Employee implements Serializable{

	private int empno;
	private String ename;

	public Employee() {
		super();
		System.out.println("Employee Contructor");
	}

	public Employee(int empno, String ename) {
		super();
		this.empno = empno;
		this.ename = ename;
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

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + "]";
	}
	
//	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
//
//		@Override
//		public int compare(Employee e1, Employee e2) {
//
//			return e1.ename.compareTo(e2.ename);
//		}
//
//	};
	
	

}
