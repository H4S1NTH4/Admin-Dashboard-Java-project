package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdminUpdateUtil {
	

    // ... validate method ...

    public static boolean updateAdmin(int id, String newName, String newEmail,String newPhone,String newUsername,String newCategory) {
        boolean isSuccess = false;
        try (Connection con = ConnectDB.getConnection();
             PreparedStatement stmt = con.prepareStatement("UPDATE admindata SET name = ?,email=? ,phone=? ,username=?,"
             		+ " category=? WHERE id = ?")) {
            stmt.setString(1, newName);
            stmt.setString(2, newEmail);
            stmt.setString(3, newPhone);
            stmt.setString(4, newUsername);
            stmt.setString(5, newCategory);
            stmt.setInt(6, id); 


            
            isSuccess = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
    
}