<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/me?serverTimezone=Europe/Rome", "me", "password");
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from regions");
%>

<title>HR Regions</title>
</head>
<body>
    <h1>HR Regions by scriplet</h1>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <%
            while (rs.next()) {
                out.print("<tr><td>" + rs.getString("REGION_ID") + "</td>");
                out.print("<td>" + rs.getString("REGION_NAME") + "</td></tr>");
            }
        %>
    </table>
</body>
</html>