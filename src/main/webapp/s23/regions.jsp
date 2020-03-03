<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<sql:query dataSource="jdbc/me" var="regions">select * from regions</sql:query>
<title>HR Regions</title>
</head>
<body>
    <h1>HR Regions by tag</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="cur" items="${regions.rows}">
            <tr>
                <td>${cur.REGION_ID}</td>
                <td>${cur.REGION_NAME}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>