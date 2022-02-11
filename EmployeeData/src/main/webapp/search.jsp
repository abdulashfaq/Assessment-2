<%@ page import="java.util.List" %>
<%@ page import="com.company.entity.Employee" %>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
	<link rel="stylesheet" href="index.css"/>
	<script type="text/javascript">
		function valid()
		{
			var search = document.forms["myform"]["search"].value;
			var reg = ^[a-zA-Z0-9]+\z;
			if(search.value.match(reg))
		    {
				alert("only characters and numbers are allowed");
		    }
		}
	</script>
</head>

<body>
    <div class="bgcontainer">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div>
            <a class="navbar-brand" href="index.jsp">
                    <img src="https://pbs.twimg.com/profile_images/1412430664620822530/SlhUV9_5_400x400.jpg" class="image" />
            </a>
        </div>
            <div class="collapse navbar-collapse navsearch" id="navbarSupportedContent">
                <form onsubmit="valid()" name="myform" action="${pageContext.request.contextPath}/operation" class="form-inline my-2 my-lg-0 ml-auto" method="get">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AddEmployee.jsp">Add Employee</a>
                        </li>
                    </ul>
                        <input class="form-control mr-sm-2" type="search" name="search" placeholder="Employee ID or Name" aria-label="Search">
                        <input type="hidden" name="form" value="searchOperation">
	     				<input class="btn btn-outline-success my-2 my-sm-0" type="submit" value ="Search">
                </form>
            </div>
			
        </nav>
		<div style="background-color:#ffffff">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
						  <th scope="col" width="250px">Employee Id</th>
						  <th scope="col" width="250px">Employee Name</th>
						  <th scope="col" width="250px">Age</th>
						  <th scope="col" width="250px">Date Of Joining</th>
						  <th scope="col" width="250px"> Department</th>
						  <th scope="col" width="250px"> Grade </th>
						  <th scope="col" width="250px"> Gross Salary</th>
						  <th scope="col" width="250px"> Net Salary</th>
						  <th scope="col" width="250px"> Income Tax</th>
						</tr>
					</thead>
					<tbody>
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
					</tbody>
				</table>
			</div>
    </div>
</body>

</html>