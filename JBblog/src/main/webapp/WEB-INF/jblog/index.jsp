<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./layout/header.jsp" %>
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

	<div class="container mt-3">
	<c:if test="${!empty postList}">
		<div class="card">
		<c:forEach var="post" items="${postList.content}">
			<div class="card-body">
				<h4 class="card-title">${post.title}</h4>
				<a href="/post/${post.id}" class="btn btn-secondary">상세보기</a> 
			</div>
		</c:forEach>
		</div>
		<!-- 페이지 네이션 처리 -->
		<br>                
		<ul class="pagination justify-content-center">
		    <li class="page-item <c:if test="${postList.first}">disabled</c:if>">
		    <a class="page-link" href="?page=${postList.number -1}">이전페이지</a>
		    </li>
		    <li class="page-item <c:if test="${postList.last}">disabled</c:if>">
		    <a class="page-link" href="?page=${postList.number +1}">다음페이지</a>
		    </li>
		  </ul>
 	</c:if>
	</div>

<%@ include file="./layout/footer.jsp" %>
</body>
</html>
	


