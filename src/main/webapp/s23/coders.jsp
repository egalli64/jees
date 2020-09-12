<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<sql:query dataSource="jdbc/me" var="coders">select * from coders</sql:query>
<title>Coders</title>
</head>
<body>
    <h1>Coders by JSTL (don't do this in production)</h1>
    <table>
        <tr>
            <th>id</th>
            <th>first name</th>
            <th>last name</th>
        </tr>
        <c:forEach var="cur" items="${coders.rows}">
            <tr>
                <td>${cur.CODER_ID}</td>
                <td>${cur.FIRST_NAME}</td>
                <td>${cur.LAST_NAME}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>