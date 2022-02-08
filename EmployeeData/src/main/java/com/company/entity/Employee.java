package com.company.entity;

import java.sql.Date;

public class Employee {
	
	private int EmpID,Age,GrossSal,NetSalary,Total_TaxPaid,Basic_Sal,HRA,MonthLeavesCount,Provident_Fund,Professional_Tax;
	private int Income_Tax,HIS;
	private String EmpName,Department,Grade;
	private Date date;
	
	
	
	public Employee(int empID, int age, int grossSal, String empName, String department, String grade,Date date) {
		super();
		EmpID = empID;
		Age = age;
		GrossSal = grossSal;
		EmpName = empName;
		Department = department;
		Grade = grade;
		this.date = date;
		
		
	}
	public int getEmpID() {
		return EmpID;
	}
	public void setEmpID(int empID) {
		EmpID = empID;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getGrossSal() {
		return GrossSal;
	}
	public void setGrossSal(int grossSal) {
		GrossSal = grossSal;
	}
	public int getNetSalary() {
		return NetSalary;
	}
	public void setNetSalary(int netSalary) {
		NetSalary = netSalary;
	}
	public int getTotal_TaxPaid() {
		return Total_TaxPaid;
	}
	public void setTotal_TaxPaid(int total_TaxPaid) {
		Total_TaxPaid = total_TaxPaid;
	}
	public int getBasic_Sal() {
		return Basic_Sal;
	}
	public void setBasic_Sal(int basic_Sal) {
		Basic_Sal = basic_Sal;
	}
	public int getHRA() {
		return HRA;
	}
	public void setHRA(int hRA) {
		HRA = hRA;
	}
	public int getMonthLeavesCount() {
		return MonthLeavesCount;
	}
	public void setMonthLeavesCount(int monthLeavesCount) {
		MonthLeavesCount = monthLeavesCount;
	}
	public int getProvident_Fund() {
		return Provident_Fund;
	}
	public void setProvident_Fund(int provident_Fund) {
		Provident_Fund = provident_Fund;
	}
	public int getProfessional_Tax() {
		return Professional_Tax;
	}
	public void setProfessional_Tax(int professional_Tax) {
		Professional_Tax = professional_Tax;
	}
	public int getIncome_Tax() {
		return Income_Tax;
	}
	public void setIncome_Tax(int income_Tax) {
		Income_Tax = income_Tax;
	}
	public int getHIS() {
		return HIS;
	}
	public void setHIS(int hIS) {
		HIS = hIS;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
