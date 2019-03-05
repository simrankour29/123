package com.cg.payroll.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cg.payroll.services.PayrollServices;

public class MainClass {

	public static void main(String[] args) throws com.cg.payroll.exceptions.AssociateDetailNotfoundException{
	ApplicationContext context = new ClassPathXmlApplicationContext("payrollBeans.xml");
	PayrollServices services = (PayrollServices)context.getBean("payrollServices");

	
	
	int switchKey;
	Scanner sc = new Scanner(System.in);
	int flag=1;
	while(flag==1) {
	System.out.println("SELECT OPTION:");
	System.out.println("1-ADD  ASSOCIATE");
	System.out.println("2-GET NET SALARY OF EMPLOYEE");
	System.out.println("3-GET ASSOCIATE DETAILS");
	System.out.println("4-EXIT APPLICATION");
	switchKey = sc.nextInt();
	switch(switchKey) {
	case 1 : //System.out.println("******ADDING ASSOCIATE*****");
			 System.out.println("Enter first name");
			 String firstName = sc.next();
			 System.out.println("Enter last name");
			 String lastName = sc.next();
			 System.out.println("Enter department ");
			 String department = sc.next();
			 System.out.println("Enter the yearlyInvestmentUnder8oC:"); 
			 int yearlyInvestmentUnder80C = sc.nextInt();
			 System.out.println("Enter designation");
			 String designation = sc.next();
			 System.out.println("Enter pan card");
			 String pancard = sc.next();
			 System.out.println("Enter email");
			 String emailId = sc.next();
			 System.out.println("Enter investment under80C");
			 int investmentUnder = sc.nextInt();
			 System.out.println("Enter basic salary");
			 int basicSalary = sc.nextInt();
			 System.out.println("Enter the company HRA: "); 
				int hra=sc.nextInt();
			 System.out.println("Enter epf");
			 int epf = sc.nextInt();
			 System.out.println("Enter company pf");
			 int companyPf = sc.nextInt();
			 System.out.println("Enter account number");
			 int accountNumber = sc.nextInt();
			 System.out.println("Enter bank name");
			 String bankName = sc.next();
			 System.out.println("Enter ifsc code");
			 String ifscCode = sc.next();
			 int associateId = services.acceptAssociateDetails( firstName, lastName, emailId,
						 department, designation, pancard,
						 yearlyInvestmentUnder80C, basicSalary, epf, companyPf, accountNumber, bankName, ifscCode);

			 System.out.println("Associate created with id : " + associateId);
	     					
			 break;
	
	case 2 : System.out.println("*****NET SALARY*****");
			 System.out.println("Enter associate ID");
			 associateId  = sc.nextInt();
			 double netSalary = services.calculateNetSalary(associateId);
			 System.out.println("Net salary is :" + netSalary);
			 break;
	
	case 3 : System.out.println("*****GET ASSOCIATE DETAILS*****");
			 System.out.println("enter associate id");
			 associateId  = sc.nextInt();
			 System.out.println(services.getAssociateDetails(associateId).toString());
			 break;
	
	case 4 : flag=0;
			 break;
			 
	default : System.out.println("Wrong option ");
			 break;
	
	}
	
	}sc.close();
	
}
	

}