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

/**
 * Servlet implementation class AllAdminServlet
 */
@WebServlet("/AllAdminServlet")
public class AllAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}
		else if(sessionCheck.check(session,"Owner")) 
		{

		List<admin> admindetails = adminDBUtil.getallAdmins();
		
		request.setAttribute("admin_data", admindetails);

		RequestDispatcher dis = request.getRequestDispatcher("/adminaccount.jsp");
		dis.forward(request, response);
	
		}//end else if
		else 
		{
			String referer = request.getHeader("Referer");
		    response.sendRedirect(referer + "?error=access-denied");
			
		}
	}//end do get

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
