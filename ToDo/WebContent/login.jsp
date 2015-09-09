<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="./header.jsp"/>

<div class="jumbotron" align = "center">
  <h1> Welcome to ToDo</h1>      
  <p>ToDo is an organized way to keep track of daily tasks. Give it a try!</p>
  <p> Please login or create an account.</p>
</div>

<%@ taglib prefix = "c" uri= "http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty error}">
	<p> ${error} </p>
</c:if>

<c:if test="${not empty loggedout}">
	<p> ${loggedout} </p>
</c:if>

<div align="center">
<form action="Login" method="post">
<label >Username: </label>
<input  type="text" name="username" ><br>
<label >Password: </label>
<input  type="password" name="password" ><br>
<input class="btn btn-info" type="submit" value="Login" id="submit"><br>
<a href="createaccount.jsp" class="btn btn-info" role="button">Create Account</a>
</form>
</div>

</body>
</html>