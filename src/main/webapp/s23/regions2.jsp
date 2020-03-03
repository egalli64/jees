<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>HR Regions</title>
</head>
<body>
    <h1>HR Regions</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="region" items="${regions}">
            <tr>
                <td>${region.id}</td>
                <td>${region.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>