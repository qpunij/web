package buy;
import buy.bookmethod;
import buy.simulation;
import buy.simulation;//

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
@WebServlet("/booklist")
public class booklist extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        Map<String, bookmethod> map = simulation.getall();
        for (Map.Entry<String, bookmethod> entry : map.entrySet()) {
            bookmethod book = entry.getValue();
            out.println(book.getName()+" &nbsp;&nbsp "+"<a href='buyedcar?id="+book.getId()+"'>购买</a><br>" );
        }
    }
}