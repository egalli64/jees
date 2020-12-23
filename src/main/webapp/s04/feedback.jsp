<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Feedback</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
</head>
<body>
    <p>
        The passed parameters are: <%= request.getAttribute("result") %>
    </p>

    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>