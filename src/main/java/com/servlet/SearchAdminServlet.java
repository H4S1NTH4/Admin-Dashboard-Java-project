package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.admin;
import com.util.adminDBUtil;

/**
 * Servlet implementation class SearchAdminServlet
 */
@WebServlet("/SearchAdminServlet")
public class SearchAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String query = request.getParameter("query");
	        
	        List<admin> searchResults = adminDBUtil.searchAdmins(query);
	        request.setAttribute("search_results", searchResults);
	        
	        

	        RequestDispatcher dis = request.getRequestDispatcher("AllAdminServlet");

	        dis.forward(request, response);
	    }
	}

	
	
	
	

