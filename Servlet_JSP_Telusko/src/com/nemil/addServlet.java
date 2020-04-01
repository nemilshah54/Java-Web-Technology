package com.nemil;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addServlet extends HttpServlet
{
	public void service( HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int a  =  Integer.parseInt(req.getParameter("num1"));
		int b  =  Integer.parseInt(req.getParameter("num2"));
		
		int c = a +b;
		
		res.getWriter().println ("Final is " +c);
		
		
	}
}
