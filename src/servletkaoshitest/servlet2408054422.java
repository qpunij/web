package servletkaoshitest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/2408054422servlet")
public class servlet2408054422 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String name = "何兴";
        String id = "2408054422";
String uri = request.getRequestURI();
String url = request.getRequestURL().toString();
String servletPath = request.getServletPath();
        System.out.println("我的名字学号控制台");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String testdate = sdf.format(new Date());
        System.out.println(testdate);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out .println("<head><title>我的信息</title>");

        out.println("</head>");
        out.println("<body>");
        out.println("<p>"+testdate+"</p>");
        out.println("<h1>"+id+"&nbsp"+name+"</h1>");
        out.println("<h1>"+url+"</h1>"+"<br/>"+uri+"<br/>"+"<h2>"+servletPath+"</h2>");
        out.println("</body>");
        out.println("</html>");
    }

}
