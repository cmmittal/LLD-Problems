package main.java.service;

import main.java.entity.LogLevel;

public abstract class Logger {

    public Logger next;
    public LoggerConfig loggerConfig;
    public LogLevel logLevel;

    public Logger(LoggerConfig config, LogLevel level){
        this.loggerConfig = config;
        this.logLevel = level;
    }

    public static Logger link(Logger start, Logger... list){
        Logger head = start;

        for (Logger logger : list) {
            head.next = logger;
            head = head.next;
        }

        return start;
    }

    public abstract boolean log(String content);

    public boolean execNext(String content){
        if (next == null) {
            return true;
        }

        return next.log(content);
    }
}
