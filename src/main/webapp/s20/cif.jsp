<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSTL core if</title>
</head>
<body>
    <h1>This JSP expects x or y as parameter</h1>
    <c:if test="${param.x != null}">
        <p>Parameter x is ${param.x}</p>
    </c:if>
    <c:if test="${param.y != null}">
        <p>Parameter y is ${param.y}</p>
    </c:if>
</body>
</html>