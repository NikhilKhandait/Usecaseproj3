<%@page import="co.rays.proj3.dto.EmployeeDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dto" class="co.rays.proj3.dto.EmployeeDTO"
		scope="request"></jsp:useBean>
	<form action="EmployeeListCtl" method="post">
		<h1 align="center">Employee List</h1>
		<%
			List list = (List) request.getAttribute("list");
			Iterator it = list.iterator();
			int index = 1;
			String msg = (String) request.getAttribute("msg");
			if (msg != null) {
		%>
		<h3 align="center" style="color: red"><%=msg%></h3>
		<%
			}
		%>
		&nbsp;&nbsp;&nbsp;
		<table align="center">

			 <tr >
<td>Employe Name</th>
<td><input type="text" name="name">
<input type="submit" name="operation" value="search"></td>
</tr>

			 <tr>
				<th>DOB</th>
				<td><select name="id">
						<option >--------select---------</option>
						<%
							Iterator it1 = list.iterator();
							while (it1.hasNext()) {
								EmployeeDTO d = (EmployeeDTO) it1.next();
						%>
						<option value="<%=d.getId()%>"><%=d.getDob()%></option>
						<%
							}
						%>
				</select></td>
				<td><input type="submit" name="operation" value="Search"></td>
			</tr> 
			
		</table>
		&nbsp;
		<table align="center" width="100%" cellpadding=7px border="2">
			<tr align="center"  bgcolor="aqua">
				<th>Select</th>
				<th>S.NO</th>
				<th>Employee Name</th>
				<th>DOB</th>
				<th>Company</th>
				<th>Department</th>
				<th>Salary</th>
				<th>Edit</th>

			</tr>
			<%
				while (it.hasNext()) {
					dto = (EmployeeDTO) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox"  name="ids" value="<%=dto.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getDob()%></td>
				<td><%=dto.getCompany()%></td>
				<td><%=dto.getDepartment()%></td>
				<td><%=dto.getSalary()%></td>
				
				<td><a href="EmployeeCtl?id=<%=dto.getId()%>">[edit]</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<table align="center">
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="delete"></td>
				<th></th>
				<td><input type="submit" name="operation" value="new"></td>
				<td><input type="reset"></td>
			</tr>
		</table>
		
	</form>
</body>
</html>