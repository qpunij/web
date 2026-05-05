package Servlet2;

import java.util.HashMap;
import java.util.Map;

public class VoteBean {
    private String language;
    private Map<String,Integer>votes=new HashMap<>();
public VoteBean(){
    votes.put("Java",0);
    votes.put("C++",0);
    votes.put("Python",0);
    votes.put("JavaScript",0);
}
public String getLanguage(){
    return language;
}
 public  void setLanguage(String language){
    this.language = language;//把取得的language赋值给language你在 JSP 页面里就可以通过 <jsp:getProperty name="voteBean" property="language"/> 或者 voteBean.getLanguage() 拿到用户刚才到底选了谁。
    if( language!=null&&!language.isEmpty()&&votes.containsKey(language)){
        int currentVotes= votes.get(language);
        votes.put(language,currentVotes+1);
    }
 }
    public  int getTotalVotes(){
   int totalVotes=0;
   for(int count:votes.values()){//votes.values()返回一个包含所有值的集合map里面所有的
       totalVotes+=count;
   }
   return totalVotes;
    }
    public Map<String, Integer> getallVotes() {
    return votes;
    }
    public double getPercentage(String option){
    int totalVotes=getTotalVotes();
    if(totalVotes==0)return 0.0;
    return (double)votes.getOrDefault(option,0)/totalVotes*100;//getOrDefault(option,0)防止null报错，用户输入的东西不在map如果不在就给0


    }
    public void reset(){
    votes.put("Java",0);
    votes.put("C++",0);
    votes.put("Python",0);
    votes.put("JavaScript",0);
    }
}
