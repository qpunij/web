<%--
  Created by IntelliJ IDEA.
  User: qpunij
  Date: 2026/4/14
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.net.URLEncoder" %>
<html>
<head>
    <meta http-equiv="refresh" content="4">
    <title>文件下载</title>
</head>
<body>
<span id="random"></span>
<a href="${pageContext.request.contextPath}/servlet5?fileName=0938.gif_wh860.gif">点击下载文件</a>
<a href="${pageContext.request.contextPath}/servlet5?fileName=<%= URLEncoder.encode("navicat_113741-永久激活版.rar", "UTF-8")%>">点击下载压缩包</a>
<script>
    document.getElementById("random").innerHTML = Math.floor(Math.random()*100);//随机数
</script>
<%           %>
<%=%>
</body>
</html>
