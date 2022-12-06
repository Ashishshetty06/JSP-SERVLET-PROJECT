package com.alvas.proj.conntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvas.proj.dao.StudentCrud;
import com.alvas.proj.dto.Student;

import net.bytebuddy.implementation.attribute.AnnotationAppender.Target.OnType;

@WebServlet(value = "/update")
public class Updatestage1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		StudentCrud studentCrud = new StudentCrud();
		Student student = studentCrud.getbyid(id);
		if (student != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
			req.setAttribute("stu", student);
			dispatcher.forward(req, resp);
		}else{
			PrintWriter out=resp.getWriter();
			out.print("No Student found with given id");
		}

	}

}
