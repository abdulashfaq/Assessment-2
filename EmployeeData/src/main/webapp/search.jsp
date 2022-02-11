<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<Strong>Listing Employees</Strong>
<table border="1">
			<thead>
				<th>Employee ID </th>
				<th>Employee Name </th>
				<th>Age </th>
				<th> Date of Joining</th>
				<th> Department</th>
				<th> Grade </th>
				<th> Gross Salary</th>
				<th> Net Salary</th>
				<th> Income Tax</th>
			</thead>
			<%
			List<Employee> listEmployee = (List)request.getAttribute("listEmployee");
			for(int i=0;i<listEmployee.size(); i++){
				out.print("<tr>");
				out.print("<td>"+listEmployee.get(i).getEmpID()+"</td>");
				out.print("<td>"+listEmployee.get(i).getEmpName()+"</td>");
				out.print("<td>"+listEmployee.get(i).getAge()+"</td>");
				out.print("<td>"+listEmployee.get(i).getDate()+"</td>");
				out.print("<td>"+listEmployee.get(i).getDepartment()+"</td>");
				out.print("<td>"+listEmployee.get(i).getGrade()+"</td>");
				out.print("<td>"+listEmployee.get(i).getGrossSal()+"</td>");
				out.print("<td>"+listEmployee.get(i).getNetSalary()+"</td>");
				out.print("<td>"+listEmployee.get(i).getIncome_Tax()+"</td>");
				out.print("</tr>");
			}
			%>
			</table>
</body>
</html>