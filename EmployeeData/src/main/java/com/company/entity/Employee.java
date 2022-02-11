package com.company.entity;

import java.sql.Date;

public class Employee {

	private int EmpID, Age, MonthLeavesCount;
	private float Basic_Sal, NetSalary, HRA, Total_TaxPaid, GrossSal, Provident_Fund, Professional_Tax, Income_Tax,HIS;
	private String EmpName, Department, Grade;
	private Date date;

	public Employee(int empID, int age, float f, String empName, String department, String grade, Date date) {
		EmpID = empID;
		Age = age;
		GrossSal = f;
		EmpName = empName;
		Department = department;
		Grade = grade;
		this.date = date;

	}
	
	public Employee(int empID, int age, float netSalary, float grossSal, float income_Tax, String empName,
			String department, String grade, Date date) {
		EmpID = empID;
		Age = age;
		NetSalary = netSalary;
		GrossSal = grossSal;
		Income_Tax = income_Tax;
		EmpName = empName;
		Department = department;
		Grade = grade;
		this.date = date;
	}

	public Employee(int empID, int age, int grossSal, int netSalary, int total_TaxPaid, int basic_Sal, int hRA,
			int monthLeavesCount, int provident_Fund, int professional_Tax, int income_Tax, int hIS, String empName,
			String department, String grade, Date date) {

		EmpID = empID;
		Age = age;
		GrossSal = grossSal;
		NetSalary = netSalary;
		Total_TaxPaid = total_TaxPaid;
		Basic_Sal = basic_Sal;
		HRA = hRA;
		MonthLeavesCount = monthLeavesCount;
		Provident_Fund = provident_Fund;
		Professional_Tax = professional_Tax;
		Income_Tax = income_Tax;
		HIS = hIS;
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

	public int getMonthLeavesCount() {
		return MonthLeavesCount;
	}

	public void setMonthLeavesCount(int monthLeavesCount) {
		MonthLeavesCount = monthLeavesCount;
	}

	public float getBasic_Sal() {
		return Basic_Sal;
	}

	public void setBasic_Sal(float d) {
		Basic_Sal = d;
	}

	public float getNetSalary() {
		return NetSalary;
	}

	public void setNetSalary(float netSalary) {
		NetSalary = netSalary;
	}

	public float getHRA() {
		return HRA;
	}

	public void setHRA(float hRA) {
		HRA = hRA;
	}

	public float getTotal_TaxPaid() {
		return Total_TaxPaid;
	}

	public void setTotal_TaxPaid(float total_TaxPaid) {
		Total_TaxPaid = total_TaxPaid;
	}

	public float getGrossSal() {
		return GrossSal;
	}

	public void setGrossSal(float grossSal) {
		GrossSal = grossSal;
	}

	public float getProvident_Fund() {
		return Provident_Fund;
	}

	public void setProvident_Fund(float provident_Fund) {
		Provident_Fund = provident_Fund;
	}

	public float getProfessional_Tax() {
		return Professional_Tax;
	}

	public void setProfessional_Tax(float professional_Tax) {
		Professional_Tax = professional_Tax;
	}

	public float getIncome_Tax() {
		return Income_Tax;
	}

	public void setIncome_Tax(float income_Tax) {
		Income_Tax = income_Tax;
	}

	public float getHIS() {
		return HIS;
	}

	public void setHIS(float hIS) {
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
