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

    <!-- explicit match between parameter and bean property -->
    <jsp:useBean id="user" class="dd.User">
        <jsp:setProperty name="user" property="name" param="name" />
        <jsp:setProperty name="user" property="id" param="id" />
    </jsp:useBean>

    <div>
        User is
        <jsp:getProperty name="user" property="name" />,
        <jsp:getProperty name="user" property="id" />
    </div>

    <!-- implicit match between parameter and bean property -->
    <jsp:useBean id="u2" class="dd.User">
        <jsp:setProperty name="u2" property="name" />
        <jsp:setProperty name="u2" property="id" />
    </jsp:useBean>

    <div>
        User (2) is
        <jsp:getProperty name="u2" property="name" />,
        <jsp:getProperty name="u2" property="id" />
    </div>

    <!-- implicit deduction of match between parameter and bean property -->
    <jsp:useBean id="u3" class="dd.User">
        <jsp:setProperty name="u3" property="*" />
    </jsp:useBean>

    <div>
        User (3) is
        <jsp:getProperty name="u3" property="name" />,
        <jsp:getProperty name="u3" property="id" />
    </div>
</body>
</html>