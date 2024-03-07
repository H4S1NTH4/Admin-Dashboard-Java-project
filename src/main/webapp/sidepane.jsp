<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/sidepanecss.css" >
<script src="Javascript/homejs.js"></script>
</head>
<body>


<!-- Side Pane -->
<div id="sidePane" class="side-pane">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    
    <a href="homeServlet">Administrator Home</a>
    <a href="productMng.jsp">Product Management</a>
    <a href="#">All Orders</a>
    <a href="#">Deliveries</a>
     <a href="#">Customer Support</a>
    <a href="empMng.jsp"> Admin Management</a>
    <a href="logoutServlet">  Log Out</a>   
   
    <!-- Bottom Details -->
<div class="project-details">
<h5>
   
    Project By FantasticFour<br><br>
     IT22266828 . IT22149558<br>
     IT22884510 . IT22080394
	<br><br><br>
   -------------------------  
   </h5>
</div>
      
</div>

	

	<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776;</span>








</body>
</html>