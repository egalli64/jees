<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="dd.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello JavaBeans</title>
</head>
<body>
    <h1>Hello!</h1>

    <!-- JavaBean accessed through scriptlet -->
    <div>
        <!-- calling toString() implicitly -->
        <span>User is <%=request.getAttribute("user")%></span>
    </div>
    <div>
        <%
            User usr = (User) request.getAttribute("user");
        %>
        User is <span><%=usr.getName()%>, <%=usr.getId()%></span>
    </div>

    <!-- JavaBean accessed through standard action -->
    <jsp:useBean id="user" class="dd.User" scope="request">
        <jsp:setProperty name="user" property="name" value="Bob" />
        <jsp:setProperty name="user" property="id" value="42" />
    </jsp:useBean>

    <div>
        User by Standard Action is
        <jsp:getProperty name="user" property="name" />,
        <jsp:getProperty name="user" property="id" />
    </div>
</body>
</html>