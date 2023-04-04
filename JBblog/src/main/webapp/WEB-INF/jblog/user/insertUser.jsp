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
    <div class="mb-3">
      <label for="uname">Username:</label>
      <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    
    <div class="mb-3">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    
    <div class="mb-3">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
    </div>
  </form>
  
  <button id="btn-save" class="btn btn-secondary">회원가입</button>
</div>

<%@ include file="../layout/footer.jsp" %>

</body>
</html>
