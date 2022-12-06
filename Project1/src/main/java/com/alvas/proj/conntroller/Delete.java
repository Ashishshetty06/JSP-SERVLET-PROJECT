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
@WebServlet(value="/delete")
public class Delete extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentCrud studentCrud= new StudentCrud();
		boolean b=studentCrud.delete(id);
		if(b){
			RequestDispatcher dispatcher= req.getRequestDispatcher("view");
			dispatcher.forward(req, resp);
		}else{
			PrintWriter out=resp.getWriter();
			out.print("no student found to delete");
		}
		
	}
}
