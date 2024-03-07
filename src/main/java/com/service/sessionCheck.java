package com.service;

import javax.servlet.http.HttpSession;

public class sessionCheck {

	public static boolean check(HttpSession session ,String logincat) 
	{
		
		String category = (String) session.getAttribute("category");
	
		if(logincat.equals(category))
		{
			return true;
		}
		
		
		else
		{
			return false;

		}
		

		
	}
	
	
	
	
	

}
