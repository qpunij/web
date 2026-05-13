<%--
  Created by IntelliJ IDEA.
  User: qpunij
  Date: 2026/5/10
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
      #main{
          width:500px;
          height:auto;
      }
      #main div {
          width:200px;
          height:auto;
      }
      ul{
         padding-top:1px;
          padding-left:1px;
          list-style: none;

      }
    </style>
</head>
<body>
<%
   if(session.getAttribute("userBean")==null){
       %>
<jsp:forward page="login.jsp"/>
<%
    return;
    }
%>
<jsp:useBean id="userBean" class="UserBean.UserBean" scope="session"/>
<div id="main">
    <div id="welcome">恭喜你登录成功</div>

    <hr/>
        <div>你的信息</div>
        <div>
           <ul>
               <li>您的姓名：${userBean.name}</li>
               <li>您的邮箱：${userBean.email}</li>
           </ul>
        </div>
    </div>


</div>


</body>
</html>
