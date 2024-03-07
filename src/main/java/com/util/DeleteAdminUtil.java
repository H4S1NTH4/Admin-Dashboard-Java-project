package com.util;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class DeleteAdminUtil {

	
	 public static boolean deleteAdmin(int id) {
	        boolean isSuccess = false;
	        try (Connection con = ConnectDB.getConnection();
	             PreparedStatement stmt = con.prepareStatement("DELETE FROM admindata WHERE id = ?")) {
	            stmt.setInt(1, id);
	            isSuccess = stmt.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return isSuccess;
	    }
}
