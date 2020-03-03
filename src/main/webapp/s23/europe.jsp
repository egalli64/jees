<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<sql:query dataSource="jdbc/me" var="countries">select country_id, country_name from countries c natural join regions r where r.region_id = 1 order by 1</sql:query>
<title>HR Regions</title>
</head>
<body>
    <h1>HR European Countries</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="cur" items="${countries.rows}">
            <tr>
                <td>${cur.COUNTRY_ID}</td>
                <td>${cur.COUNTRY_NAME}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>