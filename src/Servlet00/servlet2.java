package Servlet00;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
//获取的webxml参数
public class servlet2  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       String name = this.getServletName();
       String value = this.getInitParameter("for");//key
        ServletContext context = this.getServletConfig().getServletContext();
        String value1 = context.getInitParameter("app");
        out.println("我的app"+value1+"<br/>");
       out.println("我的ser名字"+name+"<br/>");
       out.println("我的value"+value+"");
    }

//dopost的enumeration方法，获取所有参数
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Enumeration en = this.getServletConfig().getInitParameterNames();
        while(en.hasMoreElements()) {
            String name = (String)en.nextElement();//获取key
            String value = this. getServletConfig().getInitParameter(name);
            out.println("我的key"+name+"<br/>");
            out. println("我的value"+value+"<br/><hr>");
        }
    }



}
