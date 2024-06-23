<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet"  href='<c:url value="/resources/css/test.css"/>'>
<title> Student Registration LGN001 </title>
</head>
<body class="login-page-body"> 
  
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <p>Please check your data again.</p>
          </div>
        </div>
        <form:form class="login-form" action="login" method="post" modelAttribute="loginbean">
          <form:input type="username" placeholder="User name" path="username"/>
          <form:input type="password" placeholder="Password" path="password"/>
          <button>login</button>
          <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form:form>
      </div>
    </div>
</body>

</html>