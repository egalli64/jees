<%-- 
    Introduction to Jakarta Enterprise Edition - JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<%@include file="/m2/include/link.html"%>
<title>From servlet to JSP</title>
</head>

<body>
    <h1>Hello!</h1>
    <%@include file="/m2/include/backHome.html"%>
    <%-- JSP-EL to access the set attribute in the request --%>
    <p>The user name contains these letters: ${set}</p>
</body>

</html>