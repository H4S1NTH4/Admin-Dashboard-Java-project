package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountUtil {

	public static int getCount(String query) 
	{
		int count = 0;
        
        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement()) {
            
            String sql = "SELECT COUNT(*) FROM " +query+ "";
            
            
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                count = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return count;
		
	}
	public static int getCount(String query,String column,String condition,String value) 
	{
		int count = 0;
        
        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement()) {
         
            String sql = "SELECT COUNT(*) FROM " + query + " WHERE " + column + " " + condition + " " + value + "";

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
