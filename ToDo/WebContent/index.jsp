<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="./header.jsp"/>

	<div class= "panle panel-primary col-sm-6 col-sm-offset-3">
		<div class ="panel-heading">
			<h1 align = center> New ToDo? </h1>		
		</div>	
		<div class="panel-body">
			<form role="form" action="ToDoList" method = "post">
				<div class="form-group">
					<label for="title">Title:</label> 
					<input  type="text" name="title" ><br>
					<label for="title">Due Date:</label> 
					<input  type="text" name="duedate" ><br>
					<label for="title">Priority (1-10):</label> 
					<input  type="text" name="priority" ><br>
					<label for="description">Description:</label>
					<textarea name= "description" class="form-control" rows="5" placeholder= "What ToDo?"></textarea>
					</div> 
					<div class = "form-group"> 
					<input type="submit" value="submit" id="submit">
				</div>  
			</form>			
		</div>
	</div>

</body>
</html>