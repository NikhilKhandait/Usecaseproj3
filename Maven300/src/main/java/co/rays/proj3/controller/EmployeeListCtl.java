package co.rays.proj3.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.rays.proj3.dto.EmployeeDTO;
import co.rays.proj3.model.EmployeeModel;


@WebServlet("/EmployeeListCtl")
public class EmployeeListCtl extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	EmployeeDTO dto = new EmployeeDTO();
	EmployeeModel model = new EmployeeModel();
	List list = model.search(dto);
	req.setAttribute("list", list);
	RequestDispatcher rd = req.getRequestDispatcher("EmployeeListView.jsp");
	rd.forward(req, resp);
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		String[] ids = req.getParameterValues("ids");
		EmployeeDTO dto = new EmployeeDTO();
		EmployeeModel model = new EmployeeModel();
		if (op.equalsIgnoreCase("delete")) {
			
			
			if(ids!=null && ids.length > 0) {
				for(String id:ids) {
					EmployeeDTO deletedto = new EmployeeDTO();
					deletedto.setId(Integer.parseInt(id));
					model.delete(deletedto);
					req.setAttribute("msg","Record delete sucessfully");
				}
			}else {
				req.setAttribute("msg","Select Atleast one record");
			}
		}
		if(op.equalsIgnoreCase("new")){
			resp.sendRedirect("EmployeeCtl");
			return;
		}
		if(op.equals("search")){
	
			dto.setName(req.getParameter("name"));
		}
		if(op.equals("Search")){
			
			dto.setId(Integer.parseInt(req.getParameter("id")));
		}
		List list=model.search(dto);
		req.setAttribute("list",list);
		RequestDispatcher rd = req.getRequestDispatcher("EmployeeListView.jsp");
		rd.forward(req, resp);
	}
	}

