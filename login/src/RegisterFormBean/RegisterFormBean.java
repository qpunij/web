package RegisterFormBean;

import java.util.HashMap;
import java.util.Map;

public class RegisterFormBean {
    private String name;
    private String password;
    private String password2;
    private String email;
    private Map<String, String> errors = new HashMap<String, String>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean validate() {
        boolean flag = true;
        if (name == null || name.trim().equals("")) {
            errors.put("name", "请输入姓名");
            flag = false;
        }
        if (password == null || password.trim().equals("")) {
            errors.put("password", "请输入密码");
            flag = false;
        } else if (password.length() < 12 || password.length() > 16) {
            errors.put("password", "密码长度为12-16位");
        }
        if ((password != null) && !password2.trim().equals(password)) {
            errors.put("password2", "两次密码不一致");
            flag = false;

        }
        if (email == null || email.trim().equals("")) {
            errors.put("email", "请输入邮箱");
            flag = false;
        } else if (!email.matches("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+")) {
            errors.put("email", "请输入邮箱");
            flag = false;
        }
        return flag;
    }

/**
 * 设置错误信息的方法
 * @param err 错误标识符，作为键
 * @param errMsg 错误信息，作为值
 */
    public void setErrorMsg(String err, String errMsg) {
    // 检查错误标识符和错误信息是否不为空
        if (err != null && errMsg != null) {
        // 将错误标识符和错误信息存入errors映射中
            errors.put(err, errMsg);
        }
    }
}