package Servlet00;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;

@WebServlet("/servlet5")
public class servlet5 extends HttpServlet {
//配合first.jsp的下载，中文压缩包
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String filename = request.getParameter("fileName");
        filename = URLDecoder.decode(filename, "UTF-8");//对请求解码
        String mimeType = this.getServletContext().getMimeType(filename);

        String filepath = this.getServletContext().getRealPath("/download/"+ filename);

        response.setContentType(mimeType);
        response.addHeader("Content-Length", "" + new File(filepath).length());
        String encodedFileName = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");//再编码，URLEncoder.encode(filename, "UTF-8")告诉浏览器用这个给我编码
        response.addHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);

        try (FileInputStream fis = new FileInputStream(filepath)){
    OutputStream os = response.getOutputStream();
    byte[] buffer = new byte[4096];//创建缓冲区
    int bytesRead;
    while ((bytesRead = fis.read(buffer)) != -1) {
        os.write(buffer, 0, bytesRead);
    }

}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
