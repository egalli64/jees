<%-- 
    Introduction to Jakarta Enterprise Edition - Servlet
    https://github.com/egalli64/jees
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty user}">
    <c:redirect url="/s06/home.jsp" />
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The NPB store</title>
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet" href="/jees/css/simple.css">
</head>
<body>
    <h1>Buy Vinyls from <i>The Null Pointer Band</i></h1>
    <nav>
        <a href="/jees/s06/home.html">home</a>
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