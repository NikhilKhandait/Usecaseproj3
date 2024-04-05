package co.rays.proj3.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rays.proj3.dto.EmployeeDTO;
import co.rays.proj3.model.EmployeeModel;

@WebServlet("/EmployeeCtl")
public class EmployeeCtl extends HttpServlet {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		if (id != null) {
			dto = model.findByPK(Integer.parseInt(id));
			req.setAttribute("dto", dto);
		}
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setName(req.getParameter("name"));
		dto.setCompany(req.getParameter("company"));
		dto.setDepartment(req.getParameter("dept"));
		dto.setSalary(Integer.parseInt(req.getParameter("salary")));

		try {
			dto.setDob(sdf.parse(req.getParameter("date")));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String id = req.getParameter("id");
		String op = req.getParameter("operation");
		EmployeeModel model = new EmployeeModel();
		if (op.equalsIgnoreCase("update")) {
			dto.setId(Integer.parseInt(id));
			model.update(dto);
			req.setAttribute("dto", dto);
			req.setAttribute("msg", "Employee updated successfully");
		}
		if (op.equalsIgnoreCase("save")) {
			req.setAttribute("dto", dto);
			model.add(dto);
			req.setAttribute("msg", "Employee added successfully");
		}
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeView.jsp");
		rd.forward(req, resp);

	}
}
