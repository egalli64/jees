<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Null Pointer</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
<link rel="stylesheet" type="text/css" href="/jes/css/simple.css">
</head>
<body>
    <h1>
        Buy Vinyls from the <i>Null Pointer</i> band
    </h1>

    <h2>Order an album</h2>
    <form action="nullOrder">
        <select name="id">
            <option value="1">Zero</option>
            <option value="2">Second</option>
            <option value="3">Trees</option>
            <option value="4">Forks</option>
        </select>
        <label>Quantity: <input name="quantity" type="number" value="1"></label>
        <button>Get</button>
    </form>

    <c:if test="${total ne null and total ne 0}">
        <p>You have ${total} of our vinyls in order. Thank you!</p>
        <h2>Send the order</h2>
        <form action="buyNull">
            <label>Coupon <input name="coupon"></label>
            <button>Buy</button>
        </form>
    </c:if>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>