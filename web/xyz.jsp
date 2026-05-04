<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: qpunij
  Date: 2026/4/27
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Servlet2.javabean" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
<form action="Servlet2/login.jsp" method="post">
<input type="text" name="username" value="">
<input type="password" name="password" value="">
    <input type="submit" value="提交">提交
</form>
<%-- 加减--%>
<jsp:useBean id="myBean" class="Servlet2.javabean" scope="page"/>
<jsp:setProperty name="myBean" property="*"/>
<jsp:getProperty name="myBean" property="password"/>
<jsp:getProperty name="myBean" property="username"/>
</body>
</html>
<% int a = 10;
    int b = 20;
    Random c = new Random();%>
<%=a+b%>
<%= c.nextInt(100)%>