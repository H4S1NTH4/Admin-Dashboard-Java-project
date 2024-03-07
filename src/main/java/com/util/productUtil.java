package com.util;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class productUtil {

	    public static int getProductCount() {
	        int count = 0;
	        
	        try (Connection con = ConnectDB.getConnection();
	             Statement stmt = con.createStatement()) {
	            
	            String sql = "SELECT COUNT(*) FROM productmanagement";
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            if (rs.next()) {
	                count = rs.getInt(1);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return count;
	    }
	}

	

