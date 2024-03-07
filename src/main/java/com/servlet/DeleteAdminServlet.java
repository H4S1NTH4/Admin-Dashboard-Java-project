package com.servlet;

import com.util.DeleteAdminUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("adminId"));

        boolean isSuccess = DeleteAdminUtil.deleteAdmin(id);
        
        if (isSuccess) {
            response.sendRedirect("AllAdminServlet");  // redirect to the list page to reflect deletion
        } else {
            // Handle the error. Redirect to an error page or display an error message.
            response.sendRedirect("errorPage.jsp");
        }
    }
}
