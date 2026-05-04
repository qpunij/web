package Servlet00;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/redirect5")
public class redirect extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
       StringBuffer url = request.getRequestURL();
        PrintWriter out = response.getWriter();
        Enumeration en = request.getParameterNames();
out .println(url);
            while (en.hasMoreElements()) {
                String name = (String) en.nextElement();
                String value = request.getParameter(name);
if(value.isEmpty()) {

    response.sendRedirect("redirect.html");
return;
}
else{

    out.println(name+"=" + value + "<br/>");
}
            }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
