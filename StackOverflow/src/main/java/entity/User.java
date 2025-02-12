package main.java.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    static AtomicInteger counter = new AtomicInteger(0);
    int id;
    public String userName;
    public List<Question> questions;
    public List<Answer> answers;
    public List<Comment> comments;
    public int reputation;

    public User(String userName, List<Question> questions, List<Answer> answers, List<Comment> comments,
            int reputation) {
        this.id = counter.incrementAndGet();
        this.userName = userName;
        this.questions = questions;
        this.answers = answers;
        this.comments = comments;
        this.reputation = reputation;
    }

    
}
