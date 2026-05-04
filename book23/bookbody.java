package book23;

import java.io.Serializable;

public class bookbody implements Serializable {//实现Serializable接口，序列化



        private String id;
        private String name;
        private String content;

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

    public bookbody() {
    }//构造函数

    public bookbody(String id ,String name ,String content) {
        this.name = name;
        this.id = id;
        this.content = content;
    }//构造函数

    @Override
    public String toString() {
        return "Bookbody{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }//重写toString()方法不知道啥用，好像没用到
}

