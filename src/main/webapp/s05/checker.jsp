<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
</head>
<body>
    <h1>Hello!</h1>
    <p id="result">
        The user name contains these letters: ${set}
    </p>
    <%@include file="backHome.html"%>
</body>
</html>