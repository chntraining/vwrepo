package com.vw.controller;

import com.vw.dao.EmployeeDao;

public class MyThread implements Runnable {

	EmployeeDao dao = new EmployeeDao();

	public synchronized void dothis() {
		dao.showEmp();
	}

	@Override
	public void run() {
		dothis();

	}

}
