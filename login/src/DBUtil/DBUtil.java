package DBUtil;

import UserBean.UserBean;

import java.util.HashMap;

public class DBUtil {
    private static DBUtil instance = new DBUtil();
    private HashMap<String , UserBean>users = new HashMap<String, UserBean>();
    private DBUtil (){
        UserBean user1 = new UserBean();
        user1.setName("jack");
        user1.setPassword("123456");
        user1.setEmail("jack@qq.com");
        users.put("jack",user1);
        UserBean user2 = new UserBean();
        user2.setName("tom");
        user2.setPassword("123456");
        user2.setEmail("tom@qq.com");
        users.put("tom",user2);
    }
    public static DBUtil getInstance(){
        return instance;
    }
    //从数据库那曲数据
    public UserBean getUser(String userName){
        UserBean user = (UserBean)users.get(userName);
        return user;
    }
    ///向数据库插入数据
    public boolean intsertUser(UserBean user){
        if(user==null){
            return false;
        }
        String userName = user.getName();
        if(users.get(userName)!=null){
            return false;
        }
        users.put(userName,user);
        return true;
    }
}
