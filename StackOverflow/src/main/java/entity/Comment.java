package main.java.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Comment {

    static AtomicInteger counter = new AtomicInteger(0);
    int id;
    String desc;
    
    public Comment(String desc) {
        this.id = counter.incrementAndGet();
        this.desc = desc;
    }
}
