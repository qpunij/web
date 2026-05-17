<%--
  Created by IntelliJ IDEA.
  User: qpunij
  Date: 2026/5/17
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int l = 6;
  for(int i=0;i<=6;i++){
      for(int k=l;k>0;k--) {
          out.print("&nbsp;&nbsp;");
      }
      l--;
      for(int j=0;j<=i;j++) {

     out.print("<span style='font-size:24px;'>*</span>");

      }

      out.println("<br/>");
  }
%>
</body>
</html>
