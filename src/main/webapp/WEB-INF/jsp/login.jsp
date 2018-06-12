<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/css/style.css" rel="stylesheet" />
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
        rel="stylesheet">
<title>Login Page</title>
</head>
<body>
<div class="container">

    <form method="POST" action="login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
        </div>

    </form>

</div>
</body>
</html>