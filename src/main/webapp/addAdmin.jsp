<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/homecss.css" >
<script src="JavaScript/homejs.js"></script>
</head>
<body>

<% if ("access-denied".equals(request.getParameter("error"))) { %>
    <div align="center">
        <p style="color: red;">Access Denied! You don't have permission to access the Administrator Home.</p>
    </div>
<% } %>
 


 <div class="header-bar">
 Baby Land - E Store Management Interface
  </div>

<%@ include file="sidepane.jsp" %>


   <div class="main-content">


<form action="addAdminServlet" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name" required><br>
    Email: <input type="text" name="email" required><br>
   	Username : <input type="text" name="username" required><br>
   	Password : <input type="text" name="password" required><br>
   	Phone: <input type="text" name="phone" required><br>   	
   	
   	Type: 
   	<select name="managerType" required>
   	    <option value="" selected disabled>Select a type</option>
   	    <option value="owner">Owner</option>
   	    <option value="product">.Product Manager</option>
   	    <option value="order">Order and Delivery Manger </option>
   	    <option value="crm">customer relationship manager</option>
   	    
   	    
   	</select><br>
   	
    Image: <input type="file" name="adminImage" /><br>
    <input type="submit" value="Add Admin">
</form>

</div>
</body>
</html>