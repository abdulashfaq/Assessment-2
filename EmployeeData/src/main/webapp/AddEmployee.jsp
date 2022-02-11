<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!Doctype html>
<html lang="en">
<head>
<title>Employee Registration</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">
<script type="text/javascript">
		function valid()
		{
			var empid = document.forms["myForm"]["EmpId"].value;
			var age = document.forms["myForm"]["Age"].value;
			var sal = document.forms["myForm"]["GrossSal"].value;
			var search = document.forms["myform"]["search"].value;
			if(!(/^[0-9]+$/.test(empid)) || empid <= 0)
		    {
		    	alert("Please Enter Numeric Characters and greater than 0 for Id. ")
		    }
			if(!(/^[0-9]+$/.test(age)) || age <= 18  || age >= 100)
		    {
		    	alert("Please Enter Numeric Characters for Age. above 18 and below 100")
		    }
			if(!(/^[0-9]+$/.test(sal)))
		    {
		    	alert("Please Enter Numeric Characters for Gross Salary.")
		    }
			
			var reg = /^([a-zA-Z]+\s)*[a-zA-Z]+$/;
			var reg2 = ^[a-zA-Z0-9]+\z;
			if(!(EmpName.value.match(reg)))
		    {
			    alert("Please Enter Chracters only for Name.");
		    }
			if(!(search.value.match(reg2))){
				alert("please enter Numbers or Characters.")
			}
		}
	</script>
</head>
<body>
	<div class="bgcontainer">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div>
				<a class="navbar-brand" href="index.jsp"> <img
					src="https://pbs.twimg.com/profile_images/1412430664620822530/SlhUV9_5_400x400.jpg"
					style="width: 90px; height: 60px" />
				</a>
			</div>
			<div class="collapse navbar-collapse navsearch"
				id="navbarSupportedContent">
				<form name="myform" onsubmit="valid()"
					action="${pageContext.request.contextPath}/operation"
					class="form-inline my-2 my-lg-0 ml-auto" method="get">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="AddEmployee.jsp">Add Employee</a></li>
					</ul>
					<input class="form-control mr-sm-2" type="search" name="search"
						placeholder="Employee ID or Name" aria-label="Search" /> <input
						type="hidden" name="form" value="searchOperation" /> <input
						class="btn btn-outline-success my-2 my-sm-0" type="submit"
						value="Search" />

				</form>
			</div>
		</nav>
	</div>
	<section class="ftco-section">
		<div class="container">

			<div class="row justify-content-center ">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">
						<b>Employee Registration</b>
					</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="wrap d-md-flex">
						<div class="text-wrap p-4 p-lg-5 d-flex img"
							style="background-image: url(images/bg.jpg);">
							<div class="text w-100">
								<h2 class="mb-4">Welcome to Tata Consultancy Services.</h2>
							</div>
						</div>
						<div class="login-wrap p-4 p-md-5">
							<div class="row justify-content-center py-md-5">
								<div class="col-lg-9">
									<div class="social-wrap">
										<h3 class="mb-3 text-center">Sign up with Employee
											details</h3>
									</div>
									<form action="${pageContext.request.contextPath}/operation"
										name="myForm" onsubmit="valid()" class="signup-form"
										method="post">
										<div class="row">

											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="name">Employee ID</label> <input
														type="number" class="form-control" name="EmpId" required>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="name">Full Name</label> <input
														type="text" class="form-control" name="EmpName" required>
												</div>
											</div>

											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="name">Age</label> <input
														type="number" class="form-control" name="Age" required>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="name">Date of Joining</label> <input
														type="date" class="form-control" name="DOJ" required>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="email">Department</label><br /> <select
														style="width: 250px;" name="Dept" class="form-select"
														id="Dept" required>
														<option value="IT">IT</option>
														<option value="BPS">BPS</option>
														<option value="IS">IS</option>
													</select>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="password">Grade</label><br /> <select
														style="width: 250px;" class="form-group" name="Grade"
														id="Grade" required>
														<option value="C1Y">C1Y</option>
														<option value="C1">C1</option>
														<option value="C2">C2</option>
														<option value="C2A">C2A</option>
														<option value="C3B">C3B</option>
													</select>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label" for="password">Gross Salary</label> <input
														type="number" class="form-control" name="GrossSal"
														required>
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<input type="hidden" name="form"
														value="addemployeeOperation"> <input type="submit"
														class="btn btn-primary submit p-3" value="Submit">
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>

