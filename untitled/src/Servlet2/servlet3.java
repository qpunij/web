package Servlet2;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/hello0")
public class servlet3 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.execute(request, response);
        this.log("get方法");

    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.execute(request, response);
        this.log("post方法");
    }
    public void forward(){


    }
    private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException ,ServletException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");




    String pw = request.getParameter("pwd");
    String nam = request.getParameter("name");
    String uri = request.getRequestURI();
    String method = request.getMethod();
        if(nam ==null||pw ==null||nam.isEmpty()||pw.isEmpty())

    {
        PrintWriter out = response.getWriter();//表单获取数据传参
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>登录</title></head><body>");
        out.println("<h1>get登录界面</h1>");
        out.println("<form action='"+uri+"' method='post'>");
        out.println("<p>用户名:</p><input type='text' name='name'><br/>");
        out.println("<p>密码:</p><input type='password' name='pwd'><br/>");
        out.println("<button type='submit'>登陆</button>");
        out.println("</form>");
        out.println("</body></html>");
    } else

    {
        request.setAttribute("user",nam);
        request.getRequestDispatcher("/23hello").forward(request,response);//转发进servlet1，
    }
}
    }


