<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MingleX - New Status</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
	<!-- Custom styles -->
	<link href="css/style.css" rel="stylesheet">
    <link href="css/style_login.css" rel="stylesheet">
	<link href="css/util.css" rel="stylesheet">
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-50">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default panel-login" style="margin-bottom: 0;">
					<div class="panel-heading">
						<h3 class="panel-title">New Status</h3>
					</div>
					<div class="panel-body">
						<form:form action="/status/add-status" method="POST"
							modelAttribute="status">
							<div class="form-group">
								<label>Description</label>
								<form:input path="description" cssClass="form-control" />
								<form:errors path="description" cssClass="error" />
							</div>
							<div class="form-group form-acions text-right">
								<input type="reset" class="btn btn-default" value="Reset">
								<input type="submit" class="btn btn-primary" value="Submit">
							</div>
						</form:form>
					</div>
			</div>
		</div>
	</div>
			</div>
		</div>
		<footer>Copyright &copy; KSV - mgm security partners' interns</footer>
	</div>
	
</body>
</html>