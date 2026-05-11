package ControllerServlet;

import RegisterFormBean.RegisterFormBean;
import UserBean.UserBean;
import  DBUtil.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException {
      this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException {
       response.setContentType("text/html;charset = UTF-8");
       request.setCharacterEncoding("UTF-8");
       String name =request.getParameter("name");
       String password = request.getParameter("password");
       String password2 = request.getParameter("password2");
       String email = request.getParameter("email");
       RegisterFormBean formBean = new RegisterFormBean();
       formBean.setName(name);
       formBean.setPassword(password);
       formBean.setPassword2(password2);
       formBean.setEmail(email);
       if(!formBean.validate()){
request.setAttribute("formBean",formBean);
request.getRequestDispatcher("/login.jsp").forward(request, response);
return;
       }
       UserBean userBean = new UserBean();
       userBean.setName(name);
       userBean.setPassword(password);
       userBean.setEmail(email);
       boolean b = DBUtil.getInstance().intsertUser(userBean);
       if(!b){
request.setAttribute("DBMes","你注册的用户存在");
request.setAttribute("formBean",formBean);
request.getRequestDispatcher("/login.jsp").forward(request,response);
return;
       }
       response.getWriter().print("注册成功，3秒跳转");
       request.getSession().setAttribute("userBean",userBean);
       response.setHeader("refresh","3;url=loginSuccess.jsp");
    }
}
