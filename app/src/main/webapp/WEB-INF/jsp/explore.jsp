<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Explore">
    <div class="flex-container" style="padding-top: 53px;">
        
		<!-- Navbar -->
		<jsp:include page="/WEB-INF/components/navbar.jsp" />

        <!-- Page Content -->
        <div class="container">
            <!-- Set status -->
			<jsp:include page="/WEB-INF/components/set-status-form.jsp" />
            
            <!-- All user story -->
			<jsp:include page="/WEB-INF/components/user-stories.jsp" />
		</div>

    </div>
</t:wrapper>