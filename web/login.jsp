<%--
  Created by IntelliJ IDEA.
  User: qpunij
  Date: 2026/5/9
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <style>
       h3{
         margin-left: 200px ;
       }
       #outer{
           width:750px;
       }
      span{
         color:#fff3cd;
      }
      div{
          height: 20px;
          margin-bottom: 10px;
      }
      .ch{
          width: 80px;
          text-align: right;
          float: left;
      }
      .ip{
          width:500px;
          float: left;
      }
      .ip>input{
          margin-right:20px;
      }
      #bt{
         margin-left:50px ;
      }
      #bt>input{
          margin-right:40px;
      }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/ControllerServlet" method="post">
    <h3>您的注册登录</h3>
   <div id="outer">
       <div>
           <div class ="ch">名字：</div>
           <div class ="ip">
               <input type="text"name="name"value="${formBean.name}"/>
               <span>${formBean.errors.name}</span>
               </div>
       </div>
       <div>
           <div class ="ch">密码：</div>
           <div class ="ip">
               <input type="password"name="password"/>
               <span>${formBean.errors.password}</span>
               </div>
           </div>
       <div>
           <div class ="ch">确认密码：</div>
           <div class ="ip">
               <input type="password"name="password2"/>
               <span>${formBean.errors.password2}</span>
               </div>
       </div>
       <div>
           <div class ="ch">邮箱：</div>
           <div class ="ip">
               <input type="text"name="email"value="${formBean.email}"/>
               <span>${formBean.errors.email}</span>
               </div>
       </div>
       <div id="bt">
           <input type="reset" value="重置"/>
           <input type="submit" value="注册"/>
           </div>
   </div>
</form>
</body>
</html>
