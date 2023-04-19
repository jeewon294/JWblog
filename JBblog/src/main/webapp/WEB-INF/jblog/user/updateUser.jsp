<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

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

<br>
<div class="container mt-3">
  <form>
  	<input type="hidden" id="id" value="${principal.user.id}">
    <div class="mb-3">
      <label for="username">Username:</label>
      <input type="text" class="form-control" id="username" value="${principal.user.username}">
    </div>
    
    <c:if test="${principal.user.oauth != 'JBLOG'}">
    <div class="mb-3">
      <label for="password">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password">
    </div>
    </c:if>
    
    <div class="mb-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" value="${principal.user.email}">
    </div>
  </form>
  
  <button id="btn-update" class="btn btn-secondary">회원 정보 수정</button>
</div>
<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>

</body>
</html>
