<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL for each</title>
</head>
<body>
    <p>Users:</p>
    <table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.id}</td>
        </tr>
    </c:forEach>
    </table>
    <hr>
    <p>Values</p>
    <c:forEach var="value" items="${values}" begin="0" end="11" step="3" varStatus="status">
        <p>
            ${status.count}: ${value}
            <c:if test="${status.first}">(first element)</c:if>
            <c:if test="${status.last}">(last element)</c:if>
            <c:if test="${not(status.first or status.last)}">(index is ${status.index})</c:if>
        </p>
    </c:forEach>
    <hr />
    <p>Names</p>
    <c:forTokens var="token" items="${names}" delims=",">
        <p>${token}</p>
    </c:forTokens>
</body>
</html>