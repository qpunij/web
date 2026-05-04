//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Servlet00;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/23hello")
public class servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
String username = (String)request.getAttribute("user"); //配合servlet3的转发
out.println(username);
        out.println("<html><body>");
        out.println("<h1>servlet4 - GET请求</h1>");
        out.println("<button style='display:block; margin:0 auto;font-size:100px 'onclick=\"an()\">刷新牛逼的验证码</button><br/>");

        out.println("<script>");
        out.println("function an(){ document.getElementById('captcha').src='servlet4?t='+new Date().getTime(); }");//时间戳
        out.println("</script>");
        //调用servlet4来生成验证码
        out.println("<img id='captcha' src='servlet4' />");
        out.println("</body></html>");
    }
}