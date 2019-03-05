package com.cg.payroll.client;

import com.cg.payroll.util.PayrollDBUtil;

public class TestMain {

	public static void main(String[] args) {
		PayrollDBUtil.getDBConnection();
		System.out.println("Connection is open");

	}

}