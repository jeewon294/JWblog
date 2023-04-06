<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>jw.home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
<script src="/webjars/jquery/3.5.1/dist/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="/">Main</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
		data-bs-target="#mynavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="mynavbar">
		<c:if test="${sessionScope.principa == null}">
			<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="/auth/login">로그인</a></li>
			<li class="nav-item">
				<a class="nav-link" href="/auth/insertUser">회원가입</a></li>
			</ul>
		</c:if>
		<c:if test="${sessionScope.principal != null}">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/user/updateUser">회원상세</a></li>
				<li class="nav-item">
					<a class="nav-link" href="/post/insertPost">포스트 등록</a></li>
			</ul>
		</c:if>
			<form class="d-flex">
		        <input class="form-control me-2" type="text" placeholder="Search">
		        <button class="btn btn-primary" type="button">Search</button>
      		</form>
		</div>
	</div>
</nav>

</body>
</html>