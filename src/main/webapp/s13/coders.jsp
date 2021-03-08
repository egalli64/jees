<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Coders</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" type="text/css" href="/jes/css/simple.css">
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
        <c:forEach var="coder" items="${coders}">
            <tr>
                <td>${coder.id}</td>
                <td>${coder.firstName}</td>
                <td>${coder.lastName}</td>
                <td>${coder.hireDate}</td>
                <td>${coder.salary}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>