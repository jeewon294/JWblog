<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<a class="navbar-brand" href="javascript:void(0)">Logo</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#mynavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mynavbar">
				<ul class="navbar-nav me-auto">
					<li class="nav-item"><a class="nav-link" href="/auth/login">로그인</a></li>
					<!-- 로그인 -->
					<li class="nav-item"><a class="nav-link"
						href="/auth/insertUser">회원가입</a></li>
					<!-- 회원가입 -->
					<li class="nav-item"><a class="nav-link"
						href="javascript:void(0)">Link</a></li>
				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="text" placeholder="Search">
					<button class="btn btn-primary" type="button">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="container mt-3">
		<div class="card">
			<div class="card-body">
				<h4 class="card-title">포스트 제목</h4>
				<a href="#" class="btn btn-secondary">상세보기</a> 
			</div>
		</div>
	</div>
	
	
	
	<br>
	<div class="mt-5 p-4 text-center">
		<p>Create by 이지원</p>
		<p>연락처: 010-2611-6795, 주소지: 신당동 409-23번지</p>
		<p>이메일: jeewon293@naver.com</p>
</div>

</body>
</html>


