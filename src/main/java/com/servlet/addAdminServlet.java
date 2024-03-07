package com.servlet;
import com.model.admin;
import com.util.addAdminUtil;
import com.util.adminDBUtil;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/addAdminServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB

public class addAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String name = request.getParameter("name");
        String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String category = request.getParameter("category");

		Part filePart = request.getPart("adminImage");
		
		byte[] imageBytes = null;
        try (InputStream is = filePart.getInputStream()) {
            imageBytes = is.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // add the admin object to the database
        admin newAdmin = new admin(name, email,phone ,username,password,imageBytes,category); 
        
        boolean isSuccess = addAdminUtil.addAdmin(newAdmin);
        // redirection
        if (isSuccess) {
            // If added successfully
            request.setAttribute("message", "Admin added successfully!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("AllAdminServlet");
            dispatcher.forward(request, response);
            
        } else {
            // If something went wrong
            request.setAttribute("message", "Failed to add admin! Try again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addAdmin.jsp"); // Assuming the current page is 'addAdmin.jsp'
            dispatcher.forward(request, response);
        }
		
		
		
	}

}
