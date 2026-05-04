package buy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

@WebServlet("/buycar")
public class buycar extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);//获取session
        if(session==null) {
        out.println("还未购买");
        }
        List<bookmethod> list = (List<bookmethod>) session.getAttribute("list");
        if (list != null) {
            out.println("你购买的书："+"<br>");
            for ( bookmethod bookid : list) {
                out.println(bookid.getName());
                out.println("<br>");
            }
        }
    }
}
