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
		PreparedStatement statement = null;
		try {
			connect = datasource.getConnection();
			int EmpId =employee.getEmpID();
			String EmpName = employee.getEmpName();
			int Age = employee.getAge();
			Date date = employee.getDate();
			String Department = employee.getDepartment();
			String Grade = employee.getGrade();
			
			String query = "INSERT INTO employee (EmpID, EmpName, Age, DateOfJoining, Department, Grade) VALUES (?,?,?,?,?,?);";
			statement = connect.prepareStatement(query);
			statement.setInt(1, EmpId);
			statement.setString(2, EmpName);
			statement.setInt(3, Age);
			statement.setDate(4, date);
			statement.setString(5, Department);
			statement.setString(6, Grade);
			
			
			return statement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
