package buy;

import java.io.Serializable;

public class bookmethod implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String name;
    private String content;

    public bookmethod(String id, String name, String content) {//构造函数
        this.id = id;
        this.name = name;
        this.content = content;
    }
    public bookmethod() {//无参构造函数
    }
}
