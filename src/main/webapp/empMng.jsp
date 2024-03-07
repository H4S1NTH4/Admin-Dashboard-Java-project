<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/homecss.css" >
<script src="JavaScript/homejs.js"></script>
<script src="JavaScript/empMngjs.js"></script>

</head>
<body>
 <div class="header-bar">
        Baby Land - E Store Management Interface
 </div>
 <br>
<h1 style="text-align: center;">Employee Management Interface</h1>


<%@ include file="sidepane.jsp" %>

    <div class="main-content">



<a href="AllAdminServlet">
    <button>View All Employees</button>
</a>
<br>

<a href="addAdmin.jsp">
    <button>Add Employee</button>
</a>

<!-- 
<form action="AllAdminServlet" method="get">
    <input type="submit" value="View All Employees"/>
</form>
-->


   </div>


</body>
</html>


