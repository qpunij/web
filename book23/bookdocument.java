package book23;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import book23.Simulateservlet;//同一个包
import book23.bookbody;//同一个包
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@WebServlet("/bookdocument")
public class bookdocument  extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response .setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
       out.println("人名:");

       Map<String,bookbody> map =Simulateservlet.getall();
for (Map.Entry< String,bookbody> entry:map.entrySet()){
    bookbody book = entry.getValue();//是值，就是new bookbody()
    out.println("<a href= 'bookdetail?id="+book.getId()+" '>"+book.getName()+"</a><br>");

}
out.println("<hr>");
out.println("我访问过的人：<br>");
    Cookie cookie = cookies.cookiename("lastname", request);//获取cookie当前页面的
String [] ids = cookie.getValue().split("\\#");//分割字符串，存进数组
        List<String> idlist = new ArrayList<>();//创建list对象
for( String id:ids) {//遍历数组每次获取一个id，拿一个数
    idlist.add(id);
    if (idlist.size() > 2) {
        idlist.remove(0);//删除第一个

    }
}
for(String id:idlist) {
    out.println(Simulateservlet.getall().get(id).getName() + "<br>");//循环答应
}


        out.flush();//刷新缓冲区
        out.close();//输出流关闭
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
