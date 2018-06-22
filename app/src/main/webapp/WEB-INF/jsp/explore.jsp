<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MingleX - Find The One For You</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- Custom styles -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style_profile.css" rel="stylesheet">
</head>

<body>
	<div class="flex-container" style="padding-top: 53px;">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="/profile" class="navbar-brand" style="padding: 0;"> <img
					class="logo" src="images/logo-minglex-bg.png">
				</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/profile">Profile</a></li>
				<li><a href="/match">Match</a></li>
				<li class="active"><a href="/explore">Explore</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
		</nav>
		<div class="container" style="padding: 25px 50px;">
			<div class="row">
				<div class="col-md-9 col-md-offset-1">

					<c:forEach var="item" items="${statuses}">
						<div class="row">
							<div class="col-sm-4">
								<a href="#" class=""><img src="http://placehold.it/1280X720"
									class="img-responsive"></a>
							</div>
							<div class="col-sm-8">
								<h3 class="title">${item.id}</h3>
								<p>${item.description}</p>
								<p>${item.updated_at}</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<footer>Copyright &copy; KSV - mgm security partners' interns</footer>
	</div>
</body>