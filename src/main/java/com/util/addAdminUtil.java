package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.admin;

public class addAdminUtil 
{
	

	    // Method to add an admin to the database
	    public static boolean addAdmin(admin newAdmin) {
	        
	        boolean isSuccess = false;

	        // Assuming you have a separate class named DBConnect (or similar) to handle the database connection
	        try (Connection con = ConnectDB.getConnection()) {

	            String sql = "INSERT INTO admindata(name, email, phone, username, password, image) VALUES (?, ?, ?, ?, ?, ?)";
	            
	            PreparedStatement stmt = con.prepareStatement(sql);
	            stmt.setString(1, newAdmin.getName());
	            stmt.setString(2, newAdmin.getEmail());
	            stmt.setString(3, newAdmin.getPhone());
	            stmt.setString(4, newAdmin.getUsername());
	            stmt.setString(5, newAdmin.getPassword());
	            stmt.setBytes(6, newAdmin.getadminImage()); 
	            // Assuming you've added an 'imagePath' attribute in the admin model
	            
	            int rowsInserted = stmt.executeUpdate();
	            if (rowsInserted > 0) {
	                isSuccess = true;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return isSuccess;
	    }
	}

	

