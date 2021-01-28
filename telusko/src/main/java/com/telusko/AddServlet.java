package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res )throws IOException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		res.setContentType("text/html");
		int j = Integer.parseInt(req.getParameter("num2"));
		//printing statement
		PrintWriter out = res.getWriter();
		out.println("<B>The selected color is: " + (i+j)); 
		out.close(); 
	}
		
	}