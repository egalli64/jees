<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attribute in application scope</title>
</head>
<body>
    <h1>The web app started at ${applicationScope.start}</h1>
    <a href="<c:url value='/' />">Back home</a>
</body>
</html>