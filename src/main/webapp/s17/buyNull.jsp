<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Null Pointer</title>
<link rel="icon" type="image/x-icon" href="/jes/favicon.ico">
</head>
<body>
    <h1>
        Buy Vinyls from the <i>Null Pointer</i> band
    </h1>

    <form action="/jes/s17/buyNull">
        <select name="title">
            <option value="0">Zero</option>
            <option value="1">One</option>
            <option value="2">Two</option>
            <option value="3">Three</option>
            <option value="4">Four</option>
        </select>
        <label>Quantity: <input name="quantity" type="number"></label>
        <button>Get</button>
    </form>

    <c:if test="${total != null and total != 0}">
        <p>You have already ordered ${total} from our vinyls. Thank you!</p>
        <form action="/jes/s17/buyNull">
            <label>Coupon <input name="coupon"></label>
            <button>Buy</button>
        </form>
    </c:if>
    <p>
        Back <a href="/jes/index.html">home</a>
    </p>
</body>
</html>