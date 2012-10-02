<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <title>Home</title>
</head>
<body>
    <h1>
    Hello ${username} !
    </h1>
    
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>