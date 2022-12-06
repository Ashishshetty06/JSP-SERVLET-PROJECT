package com.alvas.proj.conntroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvas.proj.dao.StudentCrud;
import com.alvas.proj.dto.Student;

@WebServlet(value = "/Register")
public class SaveStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// System.out.println("Enter the operation to be performed \n1)save data
		// \n2)Display all data\n3)Update");
		// Scanner sc = new Scanner(System.in);
		// int ch = sc.nextInt();
		// switch (ch) {
		// case 1: {
		Student student = new Student();
		student.setName(req.getParameter("name"));
		student.setEmail(req.getParameter("email"));
		student.setPhone(Long.parseLong(req.getParameter("pno")));

		StudentCrud sCrud = new StudentCrud();
		Student student2 = sCrud.savestudent(student);
		PrintWriter out = resp.getWriter();
		if (student2 != null) {
			out.print("data saved");
		} else {
			out.print("data not saved");
		}
		// break;
		// }
		// case 2: {
		// StudentCrud sCrud = new StudentCrud();
		// List<Student> students = sCrud.getAlldetails();
		// RequestDispatcher dispatcher =
		// req.getRequestDispatcher("getall.jsp");
		// dispatcher.forward(req, resp);
		//
		// break;
		// }
		// case 3: {
		//
		// }
		// }

	}
}