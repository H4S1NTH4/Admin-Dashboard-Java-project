package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.io.OutputStream;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;
import com.util.ConnectDB;
  

	

@WebServlet("/ImageDisplayServlet")
public class ImageDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imageId = request.getParameter("imageId");

        try (Connection con = ConnectDB.getConnection()) {

            String sql = "SELECT image FROM admindata WHERE id = ?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(imageId));
            
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                byte[] imgData = result.getBytes("image");
                response.setContentType("image/jpeg");
                OutputStream output = response.getOutputStream();
                output.write(imgData);
                output.flush();
                output.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



