<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/viewAdmin.css">
<link rel="stylesheet" href="css/homecss.css" >
<link rel="stylesheet" href="css/empMng.css">
<script src="JavaScript/homejs.js"></script>
<script src="JavaScript/empMngjs.js"></script>

<title>view All Employee</title>

</head>
<body>
 
 <div class="header-bar">
        Baby Land - E Store Management Interface
 </div>
 
 <%@ include file="sidepane.jsp" %>
 
    <div class="main-content">

 <h1 id="main-title" style="text-align: center;">Baby Land - E Store Management Board</h1>
	
<!-- Search bar -->
<form action="SearchAdminServlet" method="get" class="search-form">
    <input type="text" name="query" placeholder="Search Admin by Name/Email...">
    <input type="submit" value="Search">
</form>

<!-- Display search results -->
<div id="searchResults">
    <c:forEach items="${search_results}" var="result">
        <div class="modal-backdrop">
            <div class="card">
                <div class="card-content">
                    <span class="card-title">${result.name}</span>
                    <img src="ImageDisplayServlet?imageId=${result.id}" alt="Admin Image" class="admin-image"/>
                   <p>Id: ${result.id} </p>
                   <p>Category: ${result.getcategory()}</p>
                    <p>Email: ${result.email}</p>
                    <p>Username: ${result.username}</p>
                    <p>Phone: ${result.phone}</p>
                    <button class="close-modal">Close</button>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
	
		<c:forEach var="adm" items="${admin_data}">
    <div class="admin-card">
    
      <img src="ImageDisplayServlet?imageId=${adm.id}" alt="Admin Image" class="admin-image"/>
        
        <h3>${adm.name}</h3>
        <p>Id : ${adm.id }</p>
        <p>Category: ${adm.category} </p>
        <p>Email: ${adm.email}</p>
        <p>Username: ${adm.username}</p>
        <p>Phone: ${adm.phone}</p>

     <button onclick="openModal({id: '${adm.id}',name: '${adm.name}' , email: '${adm.email}', username: '${adm.username}', phone: '${adm.phone}' , category: '${adm.category}'})">
        Update</button>
        <form action="DeleteAdminServlet" method="post" style="display:inline;">
            <input type="hidden" name="adminId" value="${adm.id}">
            <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this admin?');">
        </form>
    </div>
</c:forEach>

   </div> 


<!--  Modal -->
<div id="myModal" class="modal">
  <div class="modal-content">
    <span class="close">&times;</span>
    <form id="updateForm" action="UpdateAdminServlet" method="post">
      <!-- Input fields for update operation, e.g., -->
                <input type="hidden" id="adminId" name="adminId">
      Name:     <input type="text" id="newName" name="newName"><br>
      Category: <input type="text" id="newCategory" name="newCategory"><br>
      Username: <input type="text" id="newUsername" name="newUsername">
      Email:    <input type="text" id="newEmail" name="newEmail"><br>
      Phone:    <input type="text" id="newPhone" name="newPhone"><br>
      
      <input type="submit" value="Update">
    </form>
    
  </div>
</div>


<script>
  // Get the modal
  var modal = document.getElementById('myModal');

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];

  // When the user clicks the button, open the modal 
  document.addEventListener("click", function(event) {
    if(event.target.getAttribute("data-admin-id")) {
      modal.style.display = "block";
    }
  });

  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }

  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
  function openModal(admin) {
	    // Filling modal input fields with data
	    document.getElementById('adminId').value = admin.id;
	    document.getElementById('newName').value = admin.name;
	    document.getElementById('newEmail').value = admin.email;
	    document.getElementById('newPhone').value = admin.phone;
	    document.getElementById('newUsername').value = admin.username;
	    document.getElementById('newCategory').value = admin.category;

	    
	    // Display the modal
	    modal.style.display = "block";
	}

</script>


		

 
</body>
</html>