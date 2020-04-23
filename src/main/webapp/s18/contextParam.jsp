<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Context parameter</title>
</head>
<body>
    <h1>Questions? Ask ${admin}</h1>

    <h1>Ask ${initParam["admin"]}!</h1>

    <h1>Ask ${initParam.admin}!</h1>

    <a href="..">Back home</a>
</body>
</html>