<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin homepage</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" href="/jees/css/simple.css">
</head>
<body>
    <h1>${initParam.admin}</h1>
    <nav>
        <a href="/jees/index.html">Home</a>
    </nav>
    
    <c:if test="${birthday}">
        <h2>Happy birthday!</h2>
    </c:if>
</body>
</html>