package book23;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import book23.Simulateservlet;//tongyibao
import book23.bookbody;//tongyibao
@WebServlet("/bookdetail")
public  class bookdetail extends HttpServlet {
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response .setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        bookbody book = Simulateservlet.getall().get(id);//根据docu传来的id获取数据
        if(book!=null){
            out.println("id:"+book.getId()+"</br>");
            out.println("name:"+book.getName()+"</br>");
            out.println("content:"+book.getContent()+"</br>");
            //添加cookie给document
            Cookie oldCookie = cookies.cookiename ( "lastname",request);//获取cookie之前的
            String cookieValue = id;


            if(oldCookie != null && !oldCookie.getValue().contains(id)){//改变value，拼接
                cookieValue = oldCookie.getValue() + "#" + id;
            }
            Cookie cookie = new Cookie("lastname", cookieValue);
            cookie.setPath("/");

            cookie.setMaxAge(12);
            response.addCookie(cookie);

        }

    }
}