package com.telusko.prac;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class prac extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		int i = Integer.parseInt(req.getParameter("no1"));
		int j = Integer.parseInt(req.getParameter("no2"));
		
		//print statement
		PrintWriter out = res.getWriter();
		out.println("result is : " + (i*j));
		out.close();
		
	}

}
