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
		<form>
			<div class="mt-3">
				<label for="username">User name:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter username">
			</div>
			<div class="mb3">
				<label for="password">Password:</label> <input type="text"
					class="form-control" id="password" placeholder="Enter password">
			</div>
		</form>

		<button id="btn-login" class="btn btn-secondary">로그인</button>
	</div>
	<script src="/js/login.js"></script>
	<%@ include file="../layout/footer.jsp"%>
</body>
</html>





