package book23;
 //import book23.bookbody;同一个包直接引用，不用导入

import java.util.HashMap;
import java.util.Map;

public  class Simulateservlet {
    private static Map<String ,bookbody> map = new HashMap<String,bookbody>();//创建一个map集合
    static {//静态代码块，初始化数据，让后续多对象共用 数据
        map.put("1",new bookbody("1","张麻子","该刘子喜欢张麻子"));
        map.put("2",new bookbody("2","张子","刘子喜欢张麻子"));
        map.put("3",new bookbody("3","麻子","该刘子喜欢张麻"));
        map.put("4",new bookbody("4","张麻","该刘子喜欢麻子"));

    }
    public static Map<String, bookbody>getall(){
        return map;
    }
}


