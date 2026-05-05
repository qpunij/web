<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: qpunij
  Date: 2026/4/27
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Servlet2.javabean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Servlet2.VoteBean" %>
<%@ page import="java.util.Map" %>
<html>
<head>
    <title>编程语言投票</title>
    <style>
        body { font-family: Arial; max-width: 600px; margin: 50px auto; }
        .option { margin: 10px 0; padding: 10px; background: #f0f0f0; }
        input[type="radio"] { margin-right: 10px; }
        button { padding: 10px 20px; background: #4CAF50; color: white; border: none; cursor: pointer; }
        button:hover { background: #45a049; }
    </style>
</head>
<body>
    <h1>🗳️ 最受欢迎的编程语言投票</h1>

    <form method="post">
        <div class="option">
            <input type="radio" name="language" value="Java" id="java">
            <label for="java">Java</label>
        </div>
        <div class="option">
            <input type="radio" name="language" value="Python" id="python">
            <label for="python">Python</label>
        </div>
        <div class="option">
            <input type="radio" name="language" value="JavaScript" id="js">
            <label for="js">JavaScript</label>
        </div>
        <div class="option">
            <input type="radio" name="language" value="C++" id="cpp">
            <label for="cpp">C++</label>
        </div>

        <button type="submit">提交投票</button>
    </form>

    <hr>

    <%-- 处理投票并显示结果 --%>
    <jsp:useBean id="voteBean" class="Servlet2.VoteBean" scope="application"/>
    <jsp:setProperty name="voteBean" property="*" />
    <% if("reset".equals(request.getParameter("action"))) {
        voteBean.reset();


    }%>
    <%
        String selectedLanguage = request.getParameter("language");
        if (selectedLanguage != null && !selectedLanguage.isEmpty()) {

            out.println("<p style='color:green;'>✅ 投票成功！你投给了: " + selectedLanguage + "</p>");
        }
    %>

    <h2>📊 当前投票结果：</h2>
    <%
        int total = voteBean.getTotalVotes();
    %>
    <p>总票数: <%= total %></p>

    <%
        for (Map.Entry<String, Integer> entry : voteBean.getallVotes().entrySet()) {
            double percentage = voteBean.getPercentage(entry.getKey());
    %>
        <div class="option">
            <strong><%= entry.getKey() %></strong>:
            <%= entry.getValue() %> 票
            (<%= String.format("%.1f", percentage) %>%)
            <div style="background:#ddd;height:20px;width:<%= percentage %>%;"></div>
        </div>
    <%
        }
    %>

    <br>
    <a href="xyz.jsp?action=reset">重新投票</a>
</body>
</html>

<% %>

