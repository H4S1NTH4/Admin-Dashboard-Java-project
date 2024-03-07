package com.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.admin;

public class adminDBUtil {

    public static List<admin> validate(String username, String password) {
        ArrayList<admin> ob = new ArrayList<>();

        // Use the separate class to get the connection
        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement()) {
            
            String sql = "SELECT * FROM admindata WHERE username= '" + username + "' AND password = '" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String userU = rs.getString(5);
                String passU = rs.getString(6);
                String category = rs.getString(8);

                admin c = new admin(id, name, email, phone, userU, passU,category);
                ob.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ob;
    }
    public static List<admin> getallAdmins() {
        ArrayList<admin> ob = new ArrayList<>();

        // Use the separate class to get the connection
        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement()) {
            
            String sql = "SELECT * FROM admindata";
            ResultSet rs = stmt.executeQuery(sql);
            
            
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String userU = rs.getString(5);
                String passU = rs.getString(6);
                String category = rs.getString(8);
                byte[] image = rs.getBytes("image");  


                admin c = new admin(id, name, email, phone, userU, passU,image,category);
                ob.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ob;
    }
    
    public static List<admin> searchAdmins(String query) {
        ArrayList<admin> ob = new ArrayList<>();

        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement()) {
            
            String sql = "SELECT * FROM admindata WHERE name LIKE '%" + query + "%' OR email LIKE '%" + query + "%' OR id = "+ query +"  ";     
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
            	int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String phone = rs.getString(4);
                String userU = rs.getString(5);
                String passU = rs.getString(6);
                String category = rs.getString(8);
                byte[] image = rs.getBytes("image");  

                admin c = new admin(id, name, email, phone, userU, passU,image,category);
                ob.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ob;
    }
	public static int getAdminCount() {
		
		int count = 0;
        
        try (Connection con = ConnectDB.getConnection();
             Statement stmt = con.createStatement()) {
            
            String sql = "SELECT COUNT(*) FROM admindata";
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
