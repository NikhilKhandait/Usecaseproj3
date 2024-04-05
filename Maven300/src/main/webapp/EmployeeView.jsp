<%@page import="co.rays.proj3.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="EmployeeCtl" method="post">
	
	
	
	
	<%
		EmployeeDTO dto = (EmployeeDTO) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<%
		if (dto != null) {
	%>
	<h1 align="center">Update Employee</h1>
	<%
		} else {
	%>
	<h1 align="center">Add Employee</h1>
	<%
		}
	%>
	<%
		if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
		}
	%>
		<table align="center">
			<input type="hidden" name="id"
				value="<%=(dto != null) ? dto.getId() : ""%>">
			<tr>
				<th>Employee Name :</th>
				<td><input type="text" name="name"
					value="<%=(dto != null) ? dto.getName() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>DOB :</th>
				<td><input type="<%=dto != null ? "text" : "date"%>" name="date"
					value="<%=(dto != null) ? dto.getDob() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>Company :</th>
				<td><input type="text" name="company"
					value="<%=(dto != null) ? dto.getCompany() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>Department :</th>
				<td><input type="text" name="dept"
					value="<%=(dto != null) ? dto.getDepartment() : ""%>"></td>
			</tr>
			&nbsp;
			<tr>
				<th>Salary :</th>
				<td><input type="text" name="salary"
					value="<%=(dto != null) ? dto.getSalary() : ""%>"></td>
			</tr>

			&nbsp;
			<tr>
				<th></th>
				<td><input type="submit" name="operation"
					value="<%=(dto != null) ? "Update" : "save"%>"> <!-- <input
					type="reset"></td> -->
			</tr>
		</table>
	</form>
</body>
</html>