package buy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/buyedcar")
public class buyedcarservlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String BOOKID = request.getParameter("id");
        bookmethod bookid =simulation.getall().get(BOOKID);
        HttpSession session = request.getSession();//有就获取session没有就创建
       String sessionid = (String) session.getId();
       Cookie cookie = new Cookie("JSESESSIONID",sessionid);
       cookie.setMaxAge(60*60*24*7);
       cookie.setPath("");
       response.addCookie(cookie);
        List<bookmethod> list = (List<bookmethod>) session.getAttribute("list");
        if(list==null) {
list = new ArrayList<>();
        }
        list.add(bookid);
        session.setAttribute("list",list);
        String url = response.encodeRedirectURL(request.getContextPath());
        response.sendRedirect("buycar");
    }

}
