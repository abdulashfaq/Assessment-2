package com.company.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;

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
	public List<Employee> searchEmployee(DataSource datasource,String search) {
		List<Employee> listEmployees = new ArrayList<>();
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		search = "%"+search+"%";
		try {
			connect = datasource.getConnection();
			if(StringUtils.isNumeric(search)) {
				String query = "select t1.*,t2.GrossSal,t2.NetSalary,t3.Income_Tax From employee as t1 join salary as t2 on t1.EmpID = t2.EmpId "
						+ " join saldeduction as t3 "
						+ " on t3.Empid = t1.EmpID "
						+ " where t1.EmpID = ?"
						+ " order by EmpID;";
				stmt = connect.prepareStatement(query);
				stmt.setInt(1, Integer.parseInt(search));
				rs = stmt.executeQuery();
				while(rs.next()) {
					listEmployees.add(new Employee(rs.getInt("EmpId"),rs.getInt("Age"),rs.getFloat("NetSalary"),
							rs.getFloat("GrossSal"),rs.getFloat("Income_Tax"),rs.getString("EmpName"),
							rs.getString("Department"),rs.getString("Grade"),rs.getDate("DateOfJoining")));
				}
				
			}
			else {
				String query = "select t1.*,t2.GrossSal,t2.NetSalary,t3.Income_Tax From employee as t1 join salary as t2 on t1.EmpID = t2.EmpId "
						+ " join saldeduction as t3 on t3.Empid = t1.EmpID "
						+ " where t1.EmpName like ? "
						+ " order by EmpId;";
				stmt = connect.prepareStatement(query);
				stmt.setString(1, search);
				rs = stmt.executeQuery();
				while(rs.next()) {
					listEmployees.add(new Employee(rs.getInt("EmpId"),rs.getInt("Age"),rs.getFloat("NetSalary"),
							rs.getFloat("GrossSal"),rs.getFloat("Income_Tax"),rs.getString("EmpName"),
							rs.getString("Department"),rs.getString("Grade"),rs.getDate("DateOfJoining")));
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				rs.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listEmployees;
	}
	public List<Employee> showEmployee(DataSource datasource, int empID) {
		List<Employee> listEmployees = new ArrayList<>();
		Connection connect = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connect = datasource.getConnection();
				String query = "select t1.*,t2.GrossSal,t2.NetSalary,t3.Income_Tax From employee as t1 join salary as t2 on t1.EmpID = t2.EmpId "
						+ " join saldeduction as t3 "
						+ " on t3.Empid = t1.EmpID "
						+ " where t1.EmpID = ?"
						+ " order by EmpID;";
				stmt = connect.prepareStatement(query);
				stmt.setInt(1, empID);
				rs = stmt.executeQuery();
				while(rs.next()) {
					listEmployees.add(new Employee(rs.getInt("EmpId"),rs.getInt("Age"),rs.getFloat("NetSalary"),
							rs.getFloat("GrossSal"),rs.getFloat("Income_Tax"),rs.getString("EmpName"),
							rs.getString("Department"),rs.getString("Grade"),rs.getDate("DateOfJoining")));
				}
				
			}
			
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				rs.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listEmployees;
	}
}
