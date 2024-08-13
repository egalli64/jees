<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet & JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>EL Implicit Objects</title>
<%@include file="/m2/include/link.html"%>
</head>
<body>
    <h1>EL Implicit Objects</h1>
    <%@include file="/m2/include/backHome.html"%>

    <h2>The page context</h2>
    <p>Method used for the request: ${pageContext.request.method}</p>

    <h2>Accessing parameters</h2>
    <p>The parameter name: ${param.name}</p>
    <p>First color parameter: ${paramValues.colors[0] ne null ? paramValues.colors[0] : "N/A"}</p>
    <p>Second color parameter: ${paramValues.colors[1] ne null ? paramValues.colors[1] : "N/A"}</p>
    <%-- Same as above, using empty just to check null --%>
    <p>Third color parameter: ${empty paramValues.colors[2] ? "N/A" : paramValues.colors[2]}</p>

    <h2>Accessing an attribute straight from the request scope</h2>
    <p>The example attribute in the request scope: ${requestScope.example}</p>
</body>
</html>