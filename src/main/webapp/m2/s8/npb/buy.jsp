<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet nad JSP
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- user unknown, go to login --%>
<c:if test="${empty sessionScope.user}">
    <c:redirect url="home.jsp" />
</c:if>

<%-- only if user is logged, buy is available --%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>The NPB store</title>
<%@include file="/m2/include/link.html"%>
</head>
<body>
    <h1>Buy Vinyls from <i>The Null Pointer Band</i></h1>
    <nav>
        <a href="home.jsp">Store home</a>
    </nav>

    <h2>Your order</h2>
    <form action="order">
        <select name="id">
            <option value="1">Null</option>
            <option value="2">One second</option>
            <option value="3">Three trees</option>
            <option value="4">For four forks</option>
        </select>
        <label>Quantity: <input name="quantity" type="number" value="1"></label>
        <button>Get</button>
    </form>

    <%-- only if total is one or more, ordering is available --%>
    <c:if test="${total ne null and total ne 0}">
        <p>You have ${total} of our vinyls in order. Thank you!</p>
        <h2>Send the order</h2>
        <form action="buy">
            <label>Coupon <input name="coupon"></label>
            <button>Buy</button>
        </form>
    </c:if>
</body>
</html>