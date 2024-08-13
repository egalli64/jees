<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet & JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSTL loops</title>
<%@include file="/m2/include/link.html"%>
</head>
<body>
    <h1>JSTL loops</h1>
    <%@include file="/m2/include/backHome.html"%>

    <h2>Plain forEach on a Java Bean collection</h2>
    <p>The beans are: ${users}</p>
    <table>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.id}</td>
            </tr>
        </c:forEach>
    </table>
    <hr>

    <h2>Plain forEach on a double array</h2>
    <c:forEach var="value" items="${values}">
        <p>${value}</p>
    </c:forEach>
    <hr>

    <h2>A more complicated forEach on the same double array</h2>
    <c:forEach var="value" items="${values}" begin="0" end="11" step="3" varStatus="status">
        <p>
            ${status.count}: ${value}
            <c:if test="${status.first}">(first element in the chosen interval)</c:if>
            <c:if test="${status.last}">(last element in the chosen interval)</c:if>
            <c:if test="${not(status.first or status.last)}">(index is ${status.index})</c:if>
        </p>
    </c:forEach>
    <hr>

    <h2>For each token in a CSV string</h2>
    <p>The input string is: ${names}</p>
    <ol>
        <c:forTokens var="token" items="${names}" delims=",">
            <li>${token}</li>
        </c:forTokens>
    </ol>
</body>
</html>