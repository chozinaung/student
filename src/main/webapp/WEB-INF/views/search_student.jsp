<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
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
<link rel="stylesheet"  href='<c:url value="/resources/css/test.css"/>'>
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
    <!-- <div id="testsidebar">Hello World </div> -->
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
   <form class="row g-3 mt-3 ms-2">
      <form action="/student/search" method="post" modelAttribute="searchstudent">
        <div class="col-auto">
          <label for="staticEmail2" class="visually-hidden">studentID</label>
          <input type="text"  class="form-control" id="id" placeholder="Student ID" path="id" name="id">
        </div>
        <div class="col-auto">
          <label for="inputPassword2" class="visually-hidden">studentName</label>
          <input type="text" class="form-control" id="name" placeholder="Student Name" path="name" name="name">
        </div>
        <div class="col-auto">
            <label for="inputPassword2" class="visually-hidden">Course</label>
            <input type="text" class="form-control" id="course" placeholder="Course" path="course" name="course">
          </div>
                <div class="col-auto">
          <button type="submit" class="btn btn-success mb-3">Search</button>
        </div>
        <div class="col-auto">
          <button type="submit" class="btn btn-secondary mb-3">Reset</button>
        </div>      </form>
<div>
      <table class="table table-striped" id="stduentTable">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Student ID</th>
            <th scope="col">Name</th>
            <th scope="col">Course Name</th>
            <th scope="col">Details</th>
          </tr>
        </thead>
        
        <c:forEach var="student" items="${studentList}">
                <a href="${student.url}">${student.name}</a>
            </c:forEach>
        <tbody>
          <tr>
            <th scope="row">${student.id}</th>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.course}</td>
            
        </tbody>
      </table>
    </div>
    </div>
</div>
</div>
        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
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



