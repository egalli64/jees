<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello EL</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jees/css/simple.css">
</head>
<body>
    <h1>Hello!</h1>
    <p>Request parameter x: ${param.x}</p>
    <p>Request parameter y[1]: ${paramValues.y[1]}</p>
    <p>Header host name: ${header.host}</p>
    <p>
        Back <a href="/jees/index.html">home</a>
    </p>
</body>
</html>