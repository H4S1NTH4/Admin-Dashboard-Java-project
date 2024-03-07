package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.AdminUpdateUtil;

/**
 * Servlet implementation class UpdateAdmin
 */
@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
			        int id = Integer.parseInt(request.getParameter("adminId"));
		        String newName = request.getParameter("newName");
		        String newEmail = request.getParameter("newEmail");
		        String newPhone = request.getParameter("newPhone");
		        String newUsername = request.getParameter("newUsername");
		        String newCategory = request.getParameter("newCategory");



		        
		        
		        if(AdminUpdateUtil.updateAdmin(id, newName,newEmail,newPhone,newUsername,newCategory)) 
		        {
		            // success - redirect to viewadmins
		        	RequestDispatcher dis = request.getRequestDispatcher("AllAdminServlet");
					dis.forward(request, response);
				
		        } else 
		        {
		            // Redirect to error page or show error message
		        }
	}
}


