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
		

			<button id="btn-login" class="btn btn-secondary"><spring:message code="user.login.form.login_btn"/></button>
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=b5dd97ec2a4414036b0b0252cf3d9687&redirect_uri=http://localhost:8092/oauth/kakao&response_type=code">
			<img height="38px" src="/image/kakao_login_btn.png"></a>
		</form>	
	</div>
	
<%@ include file="../layout/footer.jsp"%>
</body>
</html>





