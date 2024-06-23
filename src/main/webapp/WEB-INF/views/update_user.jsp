<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<link rel="stylesheet"  href='<c:url value="/resources/css/test.css"/>'>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="test.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Course Registration</title>
</head>

<body>

    <div id="testheader">
        <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="MNU001.html"><h3>Student Registration</h3></a>
        </div>  
        <div class="col-md-6">
            <p>User: USR001 Harry</p>
            <p>Current Date : YY.MM.DD </p>
        </div>  
        <div class="col-md-1" >
            <input type="button" class="btn-basic" id="lgnout-button" value="Log Out" onclick="location.href='LGN001.html'">
        </div>        
    </div>
</div>

</div>
    
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
            
            <div class="dropdown-container">
          <a href="BUD003.html">Course Registration </a>
          <a href="STU001.html">Student Registration </a>
          <a href="STU003.html">Student Search </a>
        </div>
        <a href="USR003.html">Users Management</a>
      </div>
      <div class="main_contents">
    <div id="sub_content">
        <form action="/student/update" method="post" modelAttribute="users">
      
        <!-- JSTL forEach loop -->
            <c:forEach var="course" items="${courseList}">
                <a href="${course.url}">${course.name}</a>
            </c:forEach>

            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Registration</h2>
            
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label path='username' class="col-md-2 col-form-label">UserName</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" id="username" path='username' name="username"></input>
                </div>
            </div>
            
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label path='email' class="col-md-2 col-form-label">Email</label>
                <div class="col-md-4">
                    <input type="email" class="form-control" id="email" path='email' name="email"></input>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label path='Passowrd' class="col-md-2 col-form-label">Passowrd</label>
                <div class="col-md-4">
                    <input type="password" class="form-control" id="name" path='password' name="password"/>
                </div>
            </div>
           
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label path='userRole' class="col-md-2 col-form-label" >User Role</label>
                <div class="col-md-4">
                    <select class="form-select" aria-label="Education" id="userRole" name="userrole">
                        <option value="admin">Admin</option>
                        <option value="user">User</option>
    
    
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-4"></div>
    
                <div class="col-md-6">
                
                <button style="text-decoration: none">Add</button>
                   
    
          
    
            </div>
            </form>
    </div>
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script>
             Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict 
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>
</body>

</html>

    
