<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <title>Login</title>
</head>
<body>
    <c:if test="${errorMessage != null}">
       <b style="color: #FF0000">${errorMessage}</b>
    </c:if>
    <form name="login" method="post">
    	Username: <input name="username" value="" type="text"/>
    	Password: <input name="password" value="" type="password"/>
    	<input name="submit" value="Login" type="submit"/>
    </form>
</body>
</html>