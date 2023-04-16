<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<form action="/auth/securitylogin" method="post">
			<div class="mb-3">
				<label for="username">
				<spring:message code="user.login.form.username"/>:</label> 
				<input type="text" class="form-control" name="username" placeholder="Enter username" value="test">
			</div>
			<div class="mb-3">
				<label for="password">
				<spring:message code="user.login.form.password"/>:</label> 
				<input type="text" class="form-control" name="password" placeholder="Enter password" value="test123">
			</div>
		

			<button id="btn-login" class="btn btn-secondary">로그인</button>
		</form>	
	</div>
	
<%@ include file="../layout/footer.jsp"%>
</body>
</html>





