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
 <link rel ="stylesheet" href = "index.css"/>



<script type="text/javascript">
function valid()
{
	var empid = document.forms["myForm"]["EmpId"].value;
	var age = document.forms["myForm"]["Age"].value;
	var sal = document.forms["myForm"]["GrossSal"].value;
	if(!/^[0-9]+$/.test(empid) || empid <= 0)
    {
    	alert("Please Enter Numeric Characters and greater than for Id. ")
    }
	if(!/^[0-9]+$/.test(age) || age <= 18  || age >= 100)
    {
    	alert("Please Enter Numeric Characters for Age. above 18 and below 100")
    }
	if(!/^[0-9]+$/.test(sal))
    {
    	alert("Please Enter Numeric Characters for Gross Salary.")
    }
	
	var reg = /^[A-Za-z]+$/;
	if(EmpName.value.match(reg))
    {
     	return true;
    }
  	else
    {
	    alert("Please Enter Chracters only for Name.");
	    return false;
 	}
}
</script>
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
    <form action="${pageContext.request.contextPath}/operation" class="form-inline my-2 my-lg-0 ml-auto" method="get">
	     <input class="form-control mr-sm-2" type="search"
	      placeholder="Search" aria-label="Search" name = "search">
	      <input type="hidden" name="form" value="searchOperation">
	     <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value ="Search">
    </form>
   </div>
  </nav>
  <h1 class="heading">Enter the Employee details.</h1>

  <form name="myForm" onsubmit="return valid()" action="${pageContext.request.contextPath}/operation"
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
        name="EmpId" id="EmpId" size="40" required></br></td>
      </div>
     </tr>
     <tr>
      <td align="right"><label for="id"><br>
       <b>
         <h2>EmployeeName:</h2></td>
      </b>
      </label>
      </td>
      <td><input type="text" placeholder="Enter Name" name="EmpName" id="EmpName"
       size="40" required></br></td>
     </tr>
     <tr>
      <td align="right"><label for="id"><br>
       <b>
         <h2>Age:</h2></td>
      </b>
      </label>
      </td>
      <td><input type="text" placeholder="Enter Age" name="Age" id="Age"
       size="40" required></br></td>
     </tr>
     <tr>
      <td align="right"><label for="id"><br>
       <b>
         <h2>Date of Joining:</h2></td>
      </b>
      </label>
      </td>
      <td><input type="date" placeholder="YYYY-MM-DD" name="DOJ" id="DOJ"
       size="40" required></br></td>
     </tr>
     <tr>
      <td align="right"><label for="id"><br>
       <b>
         <h2>Department:</h2></td>
      </b>
      </label>
      </td>
      <td><select placeholder="Select your department." name="Dept" style ="width:250px" id="Dept" required> 
       
        <option value="IT">IT</option>
        <option value="BPS">BPS</option>
        <option value="IS">IS</option>
       </select> </br></td>
     </tr>
     <tr>
      <td align="right"><label for="id"><br>
       <b>
         <h2>Grade:</h2></td>
      </b>
      </label>
      </td>
      <td><select  placeholder="Select your Grade." style ="width:250px" name="Grade" id="Grade"  required> 
       
	        <option value="C1Y">C1Y</option>
	        <option value="C1">C1</option>
	        <option value="C2">C2</option>
	        <option value="C2A">C2A</option>
	        <option value="C3B">C3B</option>
       </select> </br></td>
     </tr>
     <tr>
      <td align="right"><label for="id"><br>
       <b>
         <h2>GrossSalary:</h2></td>
      </b>
      </label>
      </td>
      <td><input type="text" placeholder="Enter Salary" name="GrossSal" id="GrossSal"
       size="40" required></br></td>
     </tr>
     <tr>
      <td><input type="hidden" name="form" value="addemployeeOperation">
       <input type="submit" value="Submit" style ="align: center"></td>
     </tr>
    </div>
   </table>
  </form>
 </div>

</body>

</html>