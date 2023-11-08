package com.vw.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.vw.dao.EmployeeDao;
import com.vw.model.Employee;

public class EmployeeController implements EmployeeInterface{
	
	Employee emp;
	List<Employee> emplist = new ArrayList<Employee>();
	Scanner scn = new Scanner(System.in);
	EmployeeDao dao = new EmployeeDao();
	
	public void addEmployee() {
		emp = new Employee();
		System.out.println("Enter your EID");
		int empno = scn.nextInt();
		emp.setEmpno(empno);
		
		System.out.println("Enter your name");
		String ename = scn.next();
		emp.setEname(ename);
		emplist.add(emp);
		dao.createEmp(emp);
		System.out.println("Employee Added Successfully !!!");
	}
	
	public void viewEmployee() {
		//System.out.println(emplist);
		// System.out.println(emp.getEmpno()+ " " + emp.getEname());
//		Iterator itt = emplist.iterator();
//		while(itt.hasNext()) {
//			System.out.println(itt.next());
//		}
		emplist.forEach(System.out::println);
		
		dao.showEmp();
	}

	public void sortEmpByName() {
		//Collections.sort(emplist,Employee.nameComparator);
		
		
//		Iterator itt = emplist.iterator();
//		while(itt.hasNext()) {
//			System.out.println(itt.next());
//		}
		
		Collections.sort(emplist,(e1,e2)-> e1.getEname().compareTo(e2.getEname()));
		emplist.forEach(System.out::println);
	}

	public void serializeEmp() {
		try {
			FileOutputStream fos = new FileOutputStream("vw.txt");
			ObjectOutputStream  oos = new ObjectOutputStream(fos);
			oos.writeObject(emp);
			System.out.println("Serialized Emp...");
			
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}

	public void deserializeEmp() {
		try {
			FileInputStream fis = new FileInputStream("vw.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Employee  emp = (Employee) ois.readObject();
			System.out.println(emp);
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}

	public void updateEmployee() {
		Employee e = new Employee();
		System.out.println("Enter the Employee number");
		int eno =scn.nextInt();
		
		System.out.println("Enter the emp name");
		String en = scn.next();
		
		e.setEmpno(eno);
		e.setEname(en);
		dao.updateEmp(e);
		
	}

	public void deleteEmployee() {
		dao.deleteEmp();
		
	}

	public void insertEmployeeUsingProcedure() {
		
		dao.insertEmpUsingPro(emp);
		
	}

	public void getEmpMetaData() {
		
		dao.getEmpMetaDataUsingRsmd();
	}

	public void readDbUsingMutliThreads() {
		MyThread mt  = new MyThread();
		Thread t1 = new Thread(mt,"Thread 1");
		Thread t2 = new Thread(mt,"Thread 2");
		
		t1.start();
		t2.start();
		
		
	}

}
