<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/homecss.css" >
<link rel="stylesheet" href="css/homeOnly.css" >
<script src="JavaScript/homejs.js"></script>


</head>
<body>
<script>
    $(document).ready(function(){
        var path = window.location.pathname;  // Gets the pathname of the current URL
        $('#sidePane a[href="' + path + '"]').addClass('active'); // Sets the 'active' class to the corresponding link in the side pane
    });
</script>

    <div class="header-bar">
       Baby Land - E Store Management Interface
    </div>
    
<%@ include file="sidepane.jsp" %>

   
<h1 align="center" style="text-decoration: underline;">Key Performance Metrics..</h1>


<!-- Main content -->
    <div class="main-content">

	<div class="card">
        <div class="card-content">
            <span class="card-title">Total Products<br><br></span>
            <span class="card-value">${productCount}</span>
        </div>
    </div>
    <div class="card">
        <div class="card-content">
            <span class="card-title">Total Sales<br></span>
           <span class="card-value">${salescount}</span>
        </div>
    </div>
    
    <a href="AllAdminServlet">
    <div class="card" >
        <div class="card-content">
            <span class="card-title">Total Administrators <br><br></span>
            <span class="card-value">${adminCount}</span> <br><br>
             click to view
        </div>       
    </div>
       </a>  
    <div class="card">
        <div class="card-content">
            <span class="card-title">Total Users</span><br><br><br>
            <span class="card-value">${customerCount}</span>
        </div>
    </div>
    <div class="card">
        <div class="card-content">
            <span class="card-title">Total Inquiries</span><br><br><br>
            <span class="card-value">${inquiryCount}</span>
        </div>
    </div><br>
     <div class="longcard">
        <div class="card-content">
            <span class="card-title"> Ongoing Offers</span><br><br><br>
             <span class="card-subtitle">Seasonal Offers :</span>
          	 <span class="card-value">${inquiryCount}</span><br><br><br>
             <span class="card-subtitle">Clearance Sale :</span>
           	 <span class="card-value">${inquiryCount}</span>
        </div>
    </div>
    <div class="longcard">
        <div class="card-content">
            <span class="card-title"> Deliveries</span><br><br><br>
             <span class="card-subtitle">Completed Deleveries :</span>
          	 <span class="card-value">${inquiryCount}</span><br><br><br>
             <span class="card-subtitle">Pending Deliveries :</span>
           	 <span class="card-value">${inquiryCount}</span>
        </div>
    </div>
    <div class="longcard">
        <div class="card-content">
            <span class="card-title"> Orders</span><br><br><br>
             <span class="card-subtitle">Completed Orders : </span>
          	 <span class="card-value">${completedOrderCount}</span><br><br><br>
             <span class="card-subtitle">Pending Orders :</span>
           	 <span class="card-value">${pendingOrderCount}</span>
        </div>
    </div>
    
    <div class="longcard">
        <div class="card-content">
            <span class="card-title"> Refunds</span><br><br><br>
             <span class="card-subtitle">Ongoing Refunds :</span>
          	 <span class="card-value">${inquiryCount}</span><br><br><br>
             <span class="card-subtitle">Completed Refunds:</span>
           	 <span class="card-value">${inquiryCount}</span>
        </div>
    </div>
   


   </div>
</body>
</html>