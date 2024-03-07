package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.admin;
import com.service.sessionCheck;
import com.util.adminDBUtil;
import com.util.productUtil;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		

		
		
		List<admin> admindetails = adminDBUtil.validate(username, password);
		
		if (admindetails.isEmpty()) 
		{
			response.sendRedirect("login.jsp?error=true");
			return;  //  end servlet execution 
		}
		else
		{	admin loggedInAdmin = admindetails.get(0);
			String category = loggedInAdmin.getcategory();
			
			HttpSession session = request.getSession();  
	        session.setAttribute("username", username);
	        session.setAttribute("category", category);


			request.setAttribute("admin_data", admindetails);

			if(sessionCheck.check(session,"Owner"))
			{
				RequestDispatcher dis = request.getRequestDispatcher("homeServlet");
				dis.forward(request, response);
			}
			else if(sessionCheck.check(session,"Product Management"))
			{
				RequestDispatcher dis = request.getRequestDispatcher("productMng.jsp");
				dis.forward(request, response);
			}
			else if(sessionCheck.check(session,"Customer Relationships"))
			{
				RequestDispatcher dis = request.getRequestDispatcher("disaraa");
				dis.forward(request, response);
			}
			else if(sessionCheck.check(session,"Order & Delivery Management"))
			{
				RequestDispatcher dis = request.getRequestDispatcher("addAdmin.jsp");
				dis.forward(request, response);
			}
			
		
		}
	}protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    // you can forward or redirect them to the appropriate location
	   RequestDispatcher rd = request.getRequestDispatcher("addAdmin.jsp");
	    rd.forward(request, response);
	}


}
