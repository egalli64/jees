<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy Null Pointer</title>
</head>
<body>
	<h1>
		The <i>Null Pointer</i> band
	</h1>
	<p>
		<%
			Integer total = (Integer) request.getAttribute("total");
			if (total != null && total != 0) {
				out.print("You have bought " + total + " vinyls. Thank you!");
			}
		%>
	</p>
</body>
</html>