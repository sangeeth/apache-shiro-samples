<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
   <title>Home</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
</head>
<body>
    <h1>RBAC using Apache Shiro</h1>
    
    <div id="container">
       <div id="bar">
           <span>Welcome ${username} !</span>
           <span class="right"><a href="${pageContext.request.contextPath}/logout">Logout</a></span>
       </div>
	   <c:if test="${not empty errorMessage}">
	      <div id="messageBar">
	        <b class="error">${errorMessage}</b>
	      </div>
	   </c:if>
	   <div id="content">
	    <table>
	       <thead>
	           <tr>
	               <th>
	                  Method
	               </th>
	               <th>
	                  Required Permissions
	               </th>
	               <th>
	                  Operation
	               </th>
	           </tr>
	       </thead>
	       <tbody>
	           <tr>
	               <td><code>getUsers</code></td>
	               <td><code>user-roles:*</code></td>
	               <td>
	                   <form name="getusers" method="post">
				         <input type="hidden" name="method" value="getUsers"/>
				         <input type="submit" value="Get users">
				       </form>
	
	   	               <c:if test="${not empty users}">
	   			          <div>${users}</div>
				       </c:if> 
	               </td>      
	           </tr>
	           
	           <tr>
					<td><code>getRoles</code></td>
					<td><code>user-roles:*</code></td>
					<td>
					    <form name="getroles" method="post">
					         <input type="hidden" name="method" value="getRoles"/>
					         <input type="submit" value="Get roles">
					    </form>
				         <c:if test="${not empty roles}">
				            <div>${roles}</div>
				         </c:if>
					</td>           
	           </tr>
	           
	           <tr>
	                <td><code>getSystemTime</code></td>
	                <td><code>system:read:time</code></td>
	                <td>
	                    <form name="getsystemtime" method="post">
					         <input type="hidden" name="method" value="getSystemTime"/>
					         <input type="submit" value="Get System Time">
					    </form>
			            <c:if test="${not empty systemTime}">
			                <div>${systemTime}</div>
			            </c:if> 
	                </td>
	           </tr>
	
	           <tr>
	                <td><code>sum</code></td>
	                <td><code>calculator:add</code></td>
	                <td>
					    <form name="sum" method="post">
					         <input type="hidden" name="method" value="sum"/>
					         <input type="text" name="a" value="100" class="number"/>
					         +
					         <input type="text" name="b" value="200" class="number"/>
					         <input type="submit" value="=">
					         <input type="text" name="result" value="${sum}" readonly="readonly"  class="number"/>
					         
					    </form>
	                </td>
	           </tr>
	
	           <tr>
	                <td><code>diff</code></td>
	                <td><code>calculator:subtract</code></td>
	                <td>
					    <form name="diff" method="post">
					         <input type="hidden" name="method" value="diff"/>
					         <input type="text" name="a" value="500"  class="number"/>
					         - 
					         <input type="text" name="b" value="300"  class="number"/>
					         <input type="submit" value="=">
					         <input type="text" name="result" value="${diff}" readonly="readonly" class="number"/>
					    </form>
	                </td>
	           </tr>
	           
	           <tr>
	               <td><code>getHomeFiles</code></td>
	               <td><code>filesystem:read:home</code></td>
	               <td>
					    <form name="getHomeFiles" method="post">
					       <input type="hidden" name="method" value="getHomeFiles"/>
					       <input type="submit" value="List files in the home dir.">
					    </form>
			            <c:if test="${not empty homeFiles}">
			               <div>${homeFiles}</div>
			            </c:if> 
	               </td>               
	           </tr>
	
	           <tr>
	               <td><code>getGreetingMessage</code></td>
	               <td><code>none</code></td>
	               <td>
					    <form name="getGreetingMessage" method="post">
					         <input type="hidden" name="method" value="getGreetingMessage"/>
					         Name : <input type="text" name="name" value="Shiro"/>
					         <input type="submit" value="Submit">
					    </form>
					    
			            <c:if test="${not empty greetingMessage}">
			                <div>${greetingMessage}</div>
			            </c:if> 
	               </td>               
	           </tr>
	         </tbody>
	       </table>
	    </div>	   
    </div>
</body>
</html>