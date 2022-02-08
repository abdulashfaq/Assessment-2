package com.company.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Date;

import javax.sql.DataSource;
import com.company.entity.Employee;
import com.company.model.EmployeeModel;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name="jdbc/project")
    private DataSource datasource;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "addemployeeoperation":
		
			Employee employee = new Employee(Integer.parseInt(request.getParameter("EmpId")),Integer.parseInt(request.getParameter("Age")),Integer.parseInt(request.getParameter("GrossSal")),request.getParameter("EmpName"),request.getParameter("Dept"),request.getParameter("Grade"),Date.valueOf(request.getParameter("DOJ")));
	        addemployeeOperation(employee);
	        
        break;
		default:
			errorPage(request, response);
			break;
		}
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}

	private void addemployeeOperation(Employee employee) {
		new EmployeeModel().addEmployee(datasource, employee);
		return;
	}

}
