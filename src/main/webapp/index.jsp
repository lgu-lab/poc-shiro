<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello world</h1>
<p>
See <a href="http://shiro.apache.org/webapp-tutorial.html">Securing Web Applications with Apache Shiro</a><br>
and <a href="http://shiro.apache.org/web.html#Web-taglibrary">Shiro Tag Lib</a><br>
</p>
<p>
LOGIN : <a href="login.jsp">login.jsp</a><br>
LOGOUT : <a href="logout">logout</a><br>

</p>
Shiro TagLib : <br> 
Shiro 'Guest' if gest = <shiro:guest>Guest</shiro:guest> <br> 
Shiro 'User' if user = <shiro:user>User</shiro:user> <br> 
Shiro principal = <shiro:principal/> <br>
Shiro principal property 'login' = <shiro:principal property="login" defaultValue="No login"/> <br>
</body>
</html>