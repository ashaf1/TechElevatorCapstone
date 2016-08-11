<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Pothole Tracker</title>
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <c:url var="cssHref" value="/site.css" />
		<link rel="stylesheet" type="text/css" href="${cssHref}">
		
		<script type="text/javascript">
			$(document).ready(function() {
				
				$("#logoutLink").click(function(event){
					$("#logoutForm").submit();
				});
				
				var pathname = window.location.pathname;
				$("nav a[href='"+pathname+"']").parent().addClass("active");
				
			});
			
			
		</script>

	</head>
	<body>
		<header>
			<c:url var="homePageHref" value="/" />
			<c:url var="imgSrc" value="/img/potholeLogo2.jpg" />
			<a href="${homePageHref}"><img src="${imgSrc}" class="img-responsive logo" /></a>
		</header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<c:url var="homePageHref" value="/" />
					<li><a href="${homePageHref}">Home</a></li>
					<c:if test="${not empty currentUser}">
						<c:url var="dashboardHref" value="/users/${currentUser}" />
						<li><a href="${dashboardHref}">My Account</a></li>
						<c:url var="viewReportsHref" value="/users/${currentUser}/reports" />
						<li><a href="${viewReportsHref}">View Reports</a></li>
						<c:if test="${user.role == 'Administrator'}">
							<c:url var="newUserHref" value="/users/new" />
							<li><a href="${newUserHref}">Create New User</a></li>
						</c:if>
					</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty currentUser}">
							<c:url var="loginHref" value="/login" />
							<li><a href="${loginHref}">Log In</a></li>
						</c:when>
						<c:otherwise>
							<c:url var="logoutAction" value="/logout" />
							<form id="logoutForm" action="${logoutAction}" method="POST">
								<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
							</form>
							<li><a id="logoutLink" href="#">Log Out</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
		<c:if test="${not empty currentUser}">
			<p id="currentUser">Current User: ${user.userName}</p>
		</c:if>		
		<div class="container">