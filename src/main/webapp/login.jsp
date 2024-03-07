<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
  	<link rel="stylesheet" href="css/logincss.css">
</head>
<body>

  <div class="login-container">
        <div class="title">BabyLand - E Store Administrator Login</div>

        <div class="icon-container">
            <i class="fas fa-user-lock"></i>
        </div>

        <% if ("true".equals(request.getParameter("error"))) { %>
            <p class="error-message">Invalid username or password!</p>
        <% } %> 

        <form action="loginServlet" method="post">
            <label class="label" for="username">Username</label>
            <input type="text" name="uid" id="username" placeholder="Enter Username">

            <label class="label" for="password">Password</label>
            <input type="password" name="pass" id="password" placeholder="Enter Password">

            <input type="submit" name="submit" value="Login">
        </form>
        
        <div style="margin-top: 20px; text-align: center; font-size: 12px; color: #555;">
            Details: BabyLand Administrator Interface
        </div>
    </div>

</body>
</html>