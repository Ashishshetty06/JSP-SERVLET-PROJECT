package com.alvas.proj.conntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value ="/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		if (((req.getParameter("email").equals("ashishs02010@gmail.com")) && (req.getParameter("password").equals("1234")))) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("myname", "ashish");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
			dispatcher.include(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("Email or password invalid");
			RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
			dispatcher.include(req, resp);
		}
	}
}
