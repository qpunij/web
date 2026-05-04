package Servlet00;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/servlet4")
public class servlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Cache-Control", "max-age=100");//设置浏览器缓存，100秒内不更新验证码
        int width = 120;
        int height = 40;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
Random Colorrandom = new Random();
int r = Colorrandom.nextInt(256);
int t = Colorrandom.nextInt(256);
int b = Colorrandom.nextInt(256);
        g.setColor(new Color(r,t,b));//上色
        g.fillRect(0, 0, width, height);//画矩形

        String code = generateRandomCode(4);
        request.getSession().setAttribute("captcha", code);//给服务器存着，验证的时候使用比对用户输入，
        Random colorrandom = new Random();
        int a = colorrandom.nextInt(256-r);
        int f = colorrandom.nextInt(256- t);
        int c =   colorrandom.nextInt(256- b);
        g.setColor(  new Color( a,f,c));
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(code, 20, 28);

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            g.drawOval(x, y, 2, 2);
        }
        response.setContentType("image/jpeg");
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    private String generateRandomCode(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = getStringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));//取第几个字符
        }
        return sb.toString();

    }
//多余调用
    private static StringBuilder getStringBuilder() {
        StringBuilder sb = new StringBuilder();
        return sb;
    }
}