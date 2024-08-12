<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Timeout information</title>
<link rel="icon" href="data:image/x-icon;,">
<link rel="stylesheet" href="/jees/css/simple.css">
</head>
<body>
    <header>
        <h1>Timeout information</h1>
        <nav>
            <a href="/jees/index.html">Home</a>
        </nav>
    </header>

    <h2>The timeout on this session is set to: ${timeout}</h2>
</body>
</html>