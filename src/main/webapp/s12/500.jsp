<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Error page</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
<link rel="stylesheet" type="text/css" href="/jes/css/simple.css">
</head>
<body>
    <h1>Internal error</h1>

    <div>
        <div>Exception: ${pageContext.exception["class"]}</div>
        <div>Message: ${pageContext.exception["message"]}</div>
    </div>

    <p>For more details, ask ${initParam.admin}</p>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>