package main.java.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Question {

    static AtomicInteger counter =  new AtomicInteger(0);
    public int id;
    public String desc;
    public int votes;
    public List<String> tags;
    public List<Comment> comments;
    public List<Answer> answers;

    public Question(String desc, int votes, List<String> tags, List<Comment> comments, List<Answer> answers) {
        this.id = counter.incrementAndGet();
        this.desc = desc;
        this.votes = votes;
        this.tags = tags;
        this.comments = comments;
        this.answers = answers;
    }

    
}
