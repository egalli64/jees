<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello EL</title>
</head>
<body>
    <h1>Hello!</h1>
    <p>Request parameter x: ${param.x}</p>
    <p>Request parameter y[1]: ${paramValues.y[1]}</p>
    <p>Header host name: ${header.host}</p>
</body>
</html>