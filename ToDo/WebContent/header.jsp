<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="login.jsp">ToDo</a>
		</div>

		<c:choose>
			<c:when test="${not empty user}">
				<div>
					<ul class="nav navbar-nav">
						<li><a href="index.jsp">Post To-Do!</a></li>
						<li><a href="SeeList">List</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout .</a></li>
					</ul>
					</div>
			</c:when>
			<c:otherwise>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp"><span
							class="glyphicon glyphicon-log-in"></span> Login .</a></li>
				</ul>
			</c:otherwise>
		</c:choose>

	</div>
</nav>