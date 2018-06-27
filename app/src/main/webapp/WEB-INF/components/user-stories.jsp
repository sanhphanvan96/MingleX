<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="item" items="${statuses}">
	<div class="row first-row">
		<div class="col-sm-2 status-user-img">
			<a href="#"> <c:choose>
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
			<h3 class="title">
				<a href="/profile?id=${item.user.id}">${item.user.username}</a>
			</h3>
			<p class="text-muted">
				<span class="glyphicon glyphicon-time"></span> ${item.updated_at}
			</p>
			<p>${item.description}</p>
		</div>
	</div>
	<hr>
</c:forEach>