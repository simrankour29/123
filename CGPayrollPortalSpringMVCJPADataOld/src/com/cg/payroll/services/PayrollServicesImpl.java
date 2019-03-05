package com.cg.payroll.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailNotfoundException;
@Component("payrollServices")
public class PayrollServicesImpl implements PayrollServices {
	
	@Autowired
	private AssociateDAO associateDao;

	@Override
	public int acceptAssociateDetails(String firstName, String lastName, String emailId, String department,
			String designation, String pancard, int yearlyInvestmentUnder8oC, int basicSalary, int epf, int companyPf,
			int accountNumber, String bankName, String ifscCode) {
		Associate associate=new Associate(yearlyInvestmentUnder8oC,accountNumber, firstName,lastName,department,designation,pancard,emailId,new Salary(basicSalary, epf, companyPf), new BankDetails(accountNumber, bankName, ifscCode));
		associate = associateDao.save(associate);
		return  associate.getAssociateId();
	}
	@Override

	public double calculateGrossSalary(int associateId) throws AssociateDetailNotfoundException {
		Associate associate =getAssociateDetails(associateId);
		associate.salary.setHra((associate.salary.getBasicSalary()*30/100));
		associate.salary.setConveyenceAllowance((associate.salary.getBasicSalary()*30/100));
		associate.salary.setOtherAllowance((associate.salary.getBasicSalary()*35/100));
		associate.salary.setPersonalAllowance(associate.salary.getBasicSalary()/5);
		associate.salary.setGrossSalary(associate.salary.getBasicSalary()+associate.salary.getConveyenceAllowance()+associate.salary.getHra()+associate.salary.getOtherAllowance()+associate.salary.getPersonalAllowance());
		return associate.salary.getGrossSalary();
	}
	public double calculateNetSalary(int associateId) throws AssociateDetailNotfoundException{
		Associate associate=getAssociateDetails(associateId);
       double taxableAmount =(calculateGrossSalary(associateId)-associate.getYearlyInvestmentUnder80C());
		return (taxableAmount- calculateTax(associateId)+associate.salary.getEpf()+associate.salary.getCompanyPf()+associate.getYearlyInvestmentUnder80C());
	}
	public double calculateTax(int associateId) throws AssociateDetailNotfoundException {
		double taxAmount =0;
		Associate associate=getAssociateDetails(associateId);
		double taxableAmount =(calculateGrossSalary(associateId)-associate.getYearlyInvestmentUnder80C());
		while(taxableAmount>250000) {
			if(taxableAmount>250000&&taxableAmount<=500000) {
				taxableAmount = taxableAmount - 250000;
				taxAmount = taxAmount+taxableAmount/10;		
			}
			if(taxableAmount>500000&&taxableAmount<=1000000) {
				taxableAmount=taxableAmount-500000;
				taxAmount =taxAmount+taxableAmount/20;
			}
			if(taxableAmount>1000000) {
				taxableAmount = taxableAmount-1000000;
				taxAmount=taxAmount+taxableAmount/30;
			}
		}
		return taxAmount;
	}
	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailNotfoundException {
		return associateDao.findById(associateId).orElseThrow(()-> new AssociateDetailNotfoundException("no associate found"));
		
	}
	@Override
	public List<Associate> getAllAssociatesDetails() {
		return associateDao.findAll();
	}
	
}