<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
</head>

<body>

	<div class="bg-container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">
				<div>
					<img
						src="https://pbs.twimg.com/profile_images/1412430664620822530/SlhUV9_5_400x400.jpg"
						class="image" />
				</div>
			</a>
			<div class="collapse navbar-collapse navsearch"
				id="navbarSupportedContent">
				<form class="form-inline my-2 my-lg-0 ml-auto">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</nav>
		<h1 class="heading">Enter the Employee details.</h1>

		<form action="${pageContext.request.contextPath}/operation"
			method="post">
			<table cellspacing="2" align="center" cellspacing="8" border="0">
				<div class="container">
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>EmployeeID:</h2></td>
						</b>
						</label>
						</td>
						<div>
							<td class="tst"><input type="text" placeholder="Enter ID"
								name="EmpId" size="40" required></br></td>
						</div>
					</tr>
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>EmployeeName:</h2></td>
						</b>
						</label>
						</td>
						<td><input type="text" placeholder="Enter Name" name="EmpName"
							size="40" required></br></td>
					</tr>
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>Age:</h2></td>
						</b>
						</label>
						</td>
						<td><input type="text" placeholder="Enter Age" name="Age"
							size="40" required></br></td>
					</tr>
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>Date of Joining:</h2></td>
						</b>
						</label>
						</td>
						<td><input type="text" placeholder="Enter DOJ" name="DOJ"
							size="40" required></br></td>
					</tr>
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>Department:</h2></td>
						</b>
						</label>
						</td>
						<td><input list="Department"
							placeholder="Select your department." name="Dept" size="40"
							required> <datalist id="Department">
								<option value="IT">
								<option value="BPS">
								<option value="IS">
							</datalist> </br></td>
					</tr>
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>Grade:</h2></td>
						</b>
						</label>
						</td>
						<td><input list="Grade" placeholder="Select your Grade."
							name="Grade" size="40" required> <datalist id="Grade">
								<option value="C1Y">
								<option value="C1">
								<option value="C2">
								<option value="C2A">
								<option value="C3B">
							</datalist> </br></td>
					</tr>
					<tr>
						<td align="right"><label for="id"><br>
							<b>
									<h2>GrossSalary:</h2></td>
						</b>
						</label>
						</td>
						<td><input type="text" placeholder="Enter Salary" name="GrossSal"
							size="40" required></br></td>
					</tr>
					<tr>
						<td><input type="hidden" name="form" value="addemployeeOperation">
							<input type="submit" value="Add User"></td>
					</tr>
				</div>
			</table>
		</form>
	</div>

</body>

</html>