package com.company.model;

import org.apache.log4j.*;

import com.company.entity.Employee;

public class CalculateDeductions {
	final Logger logger = Logger.getLogger(CalculateDeductions.class.getName());
	

	public void calculateIncomeTax(Employee employee) {
		logger.info("****Entering the Calculate Income Tax****");

		// {----Calculate Income Tax----}
		double yearlyCTC = employee.getGrossSal() * 12;
		if (yearlyCTC <= 250000) {
			employee.setIncome_Tax(0);
		} else if (yearlyCTC > 250000 && yearlyCTC <= 500000) {
			employee.setIncome_Tax((5 * employee.getGrossSal()) / 100);
		} else if (yearlyCTC > 500000 && yearlyCTC <= 1000000) {
			employee.setIncome_Tax((15 * employee.getGrossSal()) / 100);
		} else {
			employee.setIncome_Tax((20 * employee.getGrossSal()) / 100);
		}
		logger.info("****Exiting the Calculate Income Tax****");
	}

	public void calculateProfessionalTax(Employee employee) {
		logger.info("****Entering the Calculate Professional Tax****");
		// {----Calculate Professional Tax----}
		if (employee.getGrossSal() <= 18750) {
			employee.setProfessional_Tax(0);
		} else if (employee.getGrossSal() > 18750 && employee.getGrossSal() <= 25000) {
			employee.setProfessional_Tax(125);
		} else if (employee.getGrossSal() > 25000 && employee.getGrossSal() <= 33333) {
			employee.setProfessional_Tax(167);
		} else {
			employee.setProfessional_Tax(208);
		}
		logger.info("****Exiting the Calculate Professional Tax****");
	}

	public void calculateProvidentFund(Employee employee) {
		logger.info("****Entering the Calculate Provident Fund****");
		// {---- Set PF Contribution ----}
		employee.setProvident_Fund((12 * employee.getGrossSal()) / 100);
		logger.info("****Exiting the Calculate Professional Tax****");
	}

	public void calculateTotalTax(Employee employee) {
		logger.info("****Entering the Calculate Total Tax****");
		// {---- Set Total Tax Paid ----}
		employee.setTotal_TaxPaid(employee.getProfessional_Tax() + employee.getIncome_Tax());
		logger.info("****Exiting the Calculate Total Tax****");
	}

	public void calculateHis(Employee employee) {
		logger.info("****Entering the Calculate HIS****");
		// {---- Set HIS ----}
		employee.setHIS(2250);
		logger.info("****Exiting the Calculate HIS****");
	}

	public void calculateBasicSalary(Employee employee) {
		logger.info("****Entering the Calculate Basic Salary****");

		// {---- Set Basic Salary ----}
		employee.setBasic_Sal((float) ((employee.getGrossSal() - employee.getTotal_TaxPaid()
				- employee.getProvident_Fund() - employee.getHIS()) / 1.5));
		logger.info("****Exiting the Calculate Basic Salary****");
	}

	public void calculateHra(Employee employee) {
		logger.info("****Entering the Calculate HRA****");

		// {---- Set House Rent Allowances ----}
		employee.setHRA((float) (employee.getBasic_Sal() * 0.5));
		logger.info("****Exiting the Calculate HRA****");
	}

	public void calculateNetSalary(Employee employee) {
		logger.info("****Entering the Calculate Net Salary****");
		// {---- Set Net Salary ----}
		LeaveCountSetter lcs = new LeaveCountSetter();
		lcs.setLeaveCount(employee);
		if (employee.getMonthLeavesCount() < 5) {
			employee.setNetSalary(employee.getBasic_Sal() + employee.getHRA() - employee.getTotal_TaxPaid()
					- employee.getHIS() - employee.getProvident_Fund());
		} else {
			employee.setNetSalary((employee.getBasic_Sal() + employee.getHRA() - employee.getTotal_TaxPaid()
					- employee.getHIS() - employee.getProvident_Fund()) * (1 - (employee.getMonthLeavesCount() / 30)));
		}
		logger.info("****Exiting the Calculate Net Salary****");
	}
}
