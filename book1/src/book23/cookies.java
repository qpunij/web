package book23;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class cookies {
    public static Cookie cookiename(String name, HttpServletRequest  request) {
        Cookie cookie = null;
            Cookie [] cookies = request.getCookies();
            if(cookies!= null){
                for(int i = 0;i<cookies.length;i++){
                    if(name.equalsIgnoreCase(cookies[i].getName())){
cookie = cookies[i];
                    }

                }

            }
            return cookie;
    }
}