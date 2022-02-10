package com.company.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.sql.DataSource;

import com.company.entity.Employee;

public class EmployeeModel {
	
	public boolean addEmployee(DataSource datasource,Employee employee) {
		Connection  connect = null;
		PreparedStatement statement,stmt,stmt2;
		statement=stmt=stmt2=null;
		CalculateDeductions calculate = new CalculateDeductions();
		
		try {
			connect = datasource.getConnection();
			int EmpId =employee.getEmpID();
			String EmpName = employee.getEmpName();
			int Age = employee.getAge();
			Date doj = employee.getDate();
			String Department = employee.getDepartment();
			String Grade = employee.getGrade();
			
			String query = "INSERT INTO employee (EmpID, EmpName, Age, DateOfJoining, Department, Grade) VALUES (?,?,?,?,?,?);";
			statement = connect.prepareStatement(query);
			statement.setInt(1, EmpId);
			statement.setString(2, EmpName);
			statement.setInt(3, Age);
			statement.setDate(4, doj);
			statement.setString(5, Department);
			statement.setString(6, Grade);
			
			calculate.calculateIncomeTax(employee);
			calculate.calculateProfessionalTax(employee);
			calculate.calculateProvidentFund(employee);
			calculate.calculateTotalTax(employee);
			calculate.calculateHis(employee);
			calculate.calculateBasicSalary(employee);
			calculate.calculateHra(employee);
			calculate.calculateNetSalary(employee);
			
			float Basic_Sal = employee.getBasic_Sal();
			float NetSalary = employee.getNetSalary();
			float HRA = employee.getHRA();
			float Total_TaxPaid = employee.getTotal_TaxPaid();
			float GrossSal = employee.getGrossSal();
			float Provident_Fund = employee.getProvident_Fund();
			float Professional_Tax = employee.getProfessional_Tax();
			float Income_Tax = employee.getIncome_Tax();
			float HIS = employee.getHIS();
			int MonthlyLeaves = employee.getMonthLeavesCount();
			
			String query2 = "INSERT INTO salary (EmpId, NetSalary, GrossSal, Total_TaxPaid, Basic_Sal, HRA, MonthleavesCount, date) VALUES (?,?,?,?,?,?,?,?);";
			stmt = connect.prepareStatement(query2);
			stmt.setInt(1, EmpId);
			stmt.setFloat(2,  NetSalary);
			stmt.setFloat(3, GrossSal);
			stmt.setFloat(4, Total_TaxPaid);
			stmt.setFloat(5, Basic_Sal);
			stmt.setFloat(6, HRA);
			stmt.setInt(7, MonthlyLeaves);
			stmt.setDate(8, doj);
			
			String query3 = "INSERT INTO saldeduction (Empid, Provident_Fund, Professional_Tax, Income_Tax, HIS, date) VALUES (?,?,?,?,?,?);";
			stmt2 = connect.prepareStatement(query3);
			stmt2.setInt(1, EmpId);
			stmt2.setFloat(2, Provident_Fund);
			stmt2.setFloat(3, Professional_Tax);
			stmt2.setFloat(4, Income_Tax);
			stmt2.setFloat(5, HIS);
			stmt2.setDate(6, doj);
			
			statement.execute();;
			stmt.execute();
			stmt2.execute();
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				statement.close();
				stmt.close();
				stmt2.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public boolean searchEmployee(DataSource datasource,String search) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = datasource.getConnection();
			String query = "Select name ";
			return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
