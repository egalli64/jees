<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Null Pointer</title>
</head>
<body>
	<h1>
		Buy Vinyls from the <i>Null Pointer</i> band
	</h1>

	<form action="/mdwa/s11/buyNull">
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

	<form action="/mdwa/s11/buyNull">
		<p>
			<%
				Integer total = (Integer) request.getAttribute("total");
				if (total != null && total != 0) {
					out.print("You have already ordered " + total + " our vinyls. Thank you!");
				}
			%>
		</p>
		<button>Buy</button>
	</form>
</body>
</html>