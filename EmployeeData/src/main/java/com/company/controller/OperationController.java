package com.company.controller;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import com.company.entity.Employee;
import com.company.model.EmployeeModel;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Resource(name="jdbc/project")
    private DataSource datasource;
   
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String search = req.getParameter("search");
		List<Employee> listEmployee = new ArrayList<>();
		listEmployee = new EmployeeModel().searchEmployee(datasource,search);
		req.setAttribute("listEmployee", listEmployee);
		req.setAttribute("title", "List of users");
		req.getRequestDispatcher("search.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		switch (operation) {
		case "addemployeeoperation":
			Employee employee = new Employee(Integer.parseInt(request.getParameter("EmpId")),Integer.parseInt(request.getParameter("Age")),Float.parseFloat(request.getParameter("GrossSal")),request.getParameter("EmpName"),request.getParameter("Dept"),request.getParameter("Grade"),Date.valueOf(request.getParameter("DOJ")));
	        addemployeeOperation(employee);
			request.getRequestDispatcher("success.jsp").forward(request, response);
	        break;
		default:
			errorPage(request, response);
			break;
		}
		
	}	
	private void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}

	private void addemployeeOperation(Employee employee) {
		try {
			new EmployeeModel().addEmployee(datasource, employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
