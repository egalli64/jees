<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Null Pointer</title>
<link rel="icon" type="image/x-icon" href="/mdwa/favicon.ico">
</head>
<body>
    <h1>
        The <i>Null Pointer</i> band
    </h1>
    <c:if test="${total != null and total != 0}">
        <p>You have bought ${total} vinyls. Thank you!</p>
    </c:if>
    <p>
        Back <a href="/mdwa/index.html">home</a>
    </p>
</body>
</html>