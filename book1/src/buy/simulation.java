package buy;
import buy.bookmethod;
import java.util.HashMap;
import java.util.Map;

public class simulation {
    public static Map<String,bookmethod>map = new HashMap<>();
    static {
        map.put("1",new bookmethod( "1","水浒传","施耐庵"));
        map.put("2",new bookmethod("2", "三国演义", "罗贯中"));
        map.put("3",new bookmethod("3", "红楼梦", "曹雪芹"));
        map.put("4",new bookmethod("4", "西游记", "吴承恩"));
    }
    public static Map<String,bookmethod>getall(){
        return map;
    }
}
