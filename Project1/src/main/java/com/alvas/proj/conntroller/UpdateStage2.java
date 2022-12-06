package com.alvas.proj.conntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.Id;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvas.proj.dao.StudentCrud;
import com.alvas.proj.dto.Student;
@WebServlet(value="/updatestage2")
public class UpdateStage2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student= new Student();
		student.setSid(Integer.parseInt(req.getParameter("id")));
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setPhone(Long.parseLong(req.getParameter("pno")));
		
		StudentCrud studentCrud=new StudentCrud();
		Student student2= studentCrud.update(student, student.getSid());
		if(student2!=null){
			RequestDispatcher dispatcher=req.getRequestDispatcher("view");
			dispatcher.forward(req, resp);
		}
		else{
			PrintWriter out=resp.getWriter();
			out.print("No id found to update");
		}
	}
}
