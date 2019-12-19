<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error page</title>
</head>
<body>
    <h1>Internal error</h1>

    <div>
        <div>Exception: ${pageContext.exception["class"]}</div>
        <div>Message: ${pageContext.exception["message"]}</div>
    </div>
    
    <p>For more details, ask ${initParam.admin}</p>

    <a href="/mdwat/">The mdwat home page</a>
</body>
</html>