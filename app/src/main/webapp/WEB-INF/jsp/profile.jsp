<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>MingleX - Find The One For You</title>
	<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<!-- Custom styles -->
	<link href="css/style.css" rel="stylesheet">
    <link href="css/style_profile.css" rel="stylesheet">
</head>

<body>
    <div class="flex-container" style="padding-top: 53px;">
        
        <!-- Navbar -->
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="/profile" class="navbar-brand" style="padding: 0;">
                        <img class="logo" src="images/logo-minglex-bg.png">
                    </a>
                </div>
                <ul class="nav navbar-nav">
                <li class="active"><a href="/profile">Profile</a></li>
                <li><a href="#">Match</a></li>
                <li><a href="/explore">Explore</a></li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>

            </div>
        </nav>

        <!-- Sidebar -->
        <div class="w3-sidebar alice-blue w3-bar-block" style="width:auto">
            <div class="user-profile">
                <c:choose>
                    <c:when test="${curUser.gender == 'male'}">
                        <img src="images/pp-male.jpg" class="rounded-circle profile-img">
                    </c:when>
                    <c:when test="${curUser.gender == 'female'}">
                        <img src="images/pp-female.jpg" class="rounded-circle profile-img">
                    </c:when>
                    <c:otherwise>
                        <img src="images/pp-whitehat.jpg" class="rounded-circle profile-img">
                    </c:otherwise>
                </c:choose>
                <div class="detail-info">
                    <div class="info-item">
                        <h6>Username</h6>
                        <p>${curUser.username}</p>
                    </div>

                    <div class="info-item">
                        <h6>Gender</h6>
                        <p>${curUser.gender}</p>
                    </div>

                    <div class="info-item">
                        <h6>Looking for</h6>
                        <p>men</p>
                    </div>
                    
                </div>
                <a href="#">Change your password</a>
            </div>
            
            </div>
        </div>

        <!-- Page Content -->
        <div class="container" style="margin-left: 295px; padding: 25px 50px;">
            <!-- Set status -->
            <form:form action="/status/add-status" method="POST"
                modelAttribute="status">
                <div class="form-group row">
                    <div class="col-md-12 field">
                        <form:textarea path="description" cols="30" rows="5" placeholder="Hello ${curUser.username}, share your message here..." cssClass="form-control"/>
                    </div>
                </div>
                <div class="form-group row text-right">
                    <div class="col-md-12 field">
                        <input type="submit" id="submit" class="btn btn-primary" value="Post">
                    </div>
                </div>
            </form:form>

            <!-- User story -->
            <c:forEach var="item" items="${statuses}">
                <div class="row first-row">
                    <div class="col-sm-2 status-user-img">
                        <a href="#">
                            <c:choose>
                                <c:when test="${item.user.gender == 'male'}">
                                    <img src="images/pp-male.jpg" class="rounded-circle">
                                </c:when>
                                <c:when test="${item.user.gender == 'female'}">
                                    <img src="images/pp-female.jpg" class="rounded-circle">
                                </c:when>
                                <c:otherwise>
                                    <img src="images/pp-whitehat.jpg" class="rounded-circle">
                                </c:otherwise>
                            </c:choose>
                        </a>
                    </div>
                    <div class="col-sm-10">
                        <h3 class="title"><a href="#">${item.user.username}</a></h3>
                        <p class="text-muted"><span class="glyphicon glyphicon-time"></span> ${item.updated_at}</p>
                        <p>${item.description}</p> 
                    </div>
                </div>
                <hr>
            </c:forEach>

        <footer>Copyright &copy; KSV - mgm security partners' interns</footer>
    </div>

</body>