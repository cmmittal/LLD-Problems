package main.java.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Answer {

    static AtomicInteger counter = new AtomicInteger(0);
    public int id;
    String desc;
    public int votes;
    public List<Comment> comments;

    public Answer(String desc, int votes, List<Comment> comments) {
        this.id = counter.incrementAndGet();
        this.desc = desc;
        this.votes = votes;
        this.comments = comments;
    }

    
}
