package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.sessionCheck;
import com.util.CountUtil;


/**
 * Servlet implementation class homeServlet
 */
@WebServlet("/homeServlet")
public class homeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}
		else if(sessionCheck.check(session,"Owner")) 
		{
			
		
		        int productCount = CountUtil.getCount("productmanagement");
		        request.setAttribute("productCount", productCount);
		        
		        int adminCount = CountUtil.getCount("admindata");
		        request.setAttribute("adminCount", adminCount);
		        
		        int customerCount = CountUtil.getCount("customer");
		        request.setAttribute("customerCount", customerCount);
		        
		        int inquiryCount = CountUtil.getCount("inquiry");
		        request.setAttribute("inquiryCount", inquiryCount);
		        

		        int completedOrderCount = CountUtil.getCount("orders","status","=","\"complete\"");
		        request.setAttribute("completedOrderCount", completedOrderCount);
		      
		        int pendingOrderCount = CountUtil.getCount("orders","status","=","\"pending\"");
		        request.setAttribute("pendingOrderCount", pendingOrderCount);
		      
		        
		        RequestDispatcher dis = request.getRequestDispatcher("Home.jsp");
		        dis.forward(request, response);
		    
	
	}// end else if
		
		else 
		{
			String referer = request.getHeader("Referer");
		    response.sendRedirect(referer + "?error=access-denied");
			
		}
		
		
	}//end doGet
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doGet(request, response);
	}



}
