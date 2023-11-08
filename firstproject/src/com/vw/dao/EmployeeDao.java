package com.vw.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import com.vw.model.Employee;
import com.vw.util.MyDbConnection;

public class EmployeeDao {

	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet resultSet;
	Scanner scn  = new Scanner(System.in);
	CallableStatement cs;
	ResultSetMetaData rsmd;
	
	public void createEmp(Employee emp) {
		try {
			con = MyDbConnection.getMyDbConnection();
			ps = con.prepareStatement("insert into employee values(?,?)");
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void showEmp() {
		try {
			con = MyDbConnection.getMyDbConnection();
			stmt =con.createStatement();
			resultSet =stmt.executeQuery("select * from employee");
			
			while(resultSet.next()) {
				System.out.println("Empno :" +resultSet.getInt(1));
				System.out.println("Ename :" + resultSet.getString(2));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void updateEmp(Employee e) {
		try {
			con = MyDbConnection.getMyDbConnection();
			ps = con.prepareStatement("update employee set ename=? where empno=?");
			
			ps.setString(1, e.getEname());
			ps.setInt(2, e.getEmpno());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated successfully !!!");

		} catch (SQLException sqlex) {

			sqlex.printStackTrace();
		}

		
	}

	public void deleteEmp() {
		try {
			con = MyDbConnection.getMyDbConnection();
			System.out.println("Enter the Employee number");
			int eno =scn.nextInt();
			ps = con.prepareStatement("delete from employee where empno=?");
			ps.setInt(1, eno);
			int noofrows = ps.executeUpdate();
			System.out.println("Employee "+ eno + " deleted successfully !!!");

		} catch (SQLException sqlex) {

			sqlex.printStackTrace();
		}
		
	}

	public void insertEmpUsingPro(Employee emp) {
		try {
			con = MyDbConnection.getMyDbConnection();
			cs = con.prepareCall("call insertEmp(?,?)");
			cs.setInt(1, emp.getEmpno());
			cs.setString(2, emp.getEname());
			cs.execute();
			System.out.println("Employee " + emp.getEmpno() +" inserted using procedure !!!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}

	public void getEmpMetaDataUsingRsmd() {
		try {
			con = MyDbConnection.getMyDbConnection();
			stmt =con.createStatement();
			resultSet =stmt.executeQuery("select * from employee");
			rsmd = resultSet.getMetaData();
			System.out.println(rsmd.getColumnCount());
			
			while(resultSet.next()) {
				HashMap<String, Object> hm = new HashMap<>();
				for(int i=1; i< rsmd.getColumnCount();i++) {
					hm.put(rsmd.getColumnName(i),resultSet.getObject(i));
				}
				System.out.println(hm);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}












