package Servlet2;

import java.util.HashMap;
import java.util.Map;

public class VoteBean {
    private String language;
    private Map<String, Integer> votes = new HashMap<>();

    public VoteBean() {
        // 初始化投票选项和票数
        votes.put("Java", 0);
        votes.put("Python", 0);
        votes.put("JavaScript", 0);
        votes.put("C++", 0);
    }
    public void setLanguage(String language) {
        votes.put(language,votes.get(language)+1);
        this.language = language;
    }
    public  String getLanguage(String language) {
        return language;
    }
    public  String addVote(String language) {

    }
    public int getTotalVotes() {
        int total = 0;
        for( ){

        }
    }
}
