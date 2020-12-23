<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coders</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
</head>
<body>
    <h1>Coders</h1>
    <table>
        <tr>
            <th>id</th>
            <th>first name</th>
            <th>last name</th>
            <th>hire date</th>
            <th>salary</th>
        </tr>
        <c:forEach var="cur" items="${coders}">
            <tr>
                <td>${cur.id}</td>
                <td>${cur.firstName}</td>
                <td>${cur.lastName}</td>
                <td>${cur.hireDate}</td>
                <td>${cur.salary}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>