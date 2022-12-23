<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coders</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" href="/jees/css/simple.css">
</head>
<body>
    <header>
        <h1>Coders</h1>
        <nav>
            <a href="/jees/index.html">Home</a>
        </nav>
    </header>

    <table>
        <tr>
            <th>id</th>
            <th>first name</th>
            <th>last name</th>
            <th>hired</th>
            <th>salary</th>
        </tr>
        <c:forEach var="coder" items="${coders}">
            <tr>
                <td>${coder.id}</td>
                <td>${coder.firstName}</td>
                <td>${coder.lastName}</td>
                <td>${coder.hired}</td>
                <td>${coder.salary}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>