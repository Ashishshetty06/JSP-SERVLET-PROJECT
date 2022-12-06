package com.alvas.proj.conntroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvas.proj.dao.StudentCrud;
import com.alvas.proj.dto.Student;
@WebServlet(value="/view")
public class GetallStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentCrud sCrud = new StudentCrud();
		List<Student> students = sCrud.getAlldetails();
		if (students.size() > 0) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("getall.jsp");
			req.setAttribute("list", students);
			dispatcher.forward(req, resp);
		}

	}
}
