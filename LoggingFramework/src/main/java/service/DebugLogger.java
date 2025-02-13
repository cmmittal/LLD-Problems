package main.java.service;

import main.java.entity.LogLevel;

public class DebugLogger extends Logger{

    public DebugLogger(LoggerConfig config){
        super(config, LogLevel.DEBUG);
    }

    public boolean log(String content){
        if (loggerConfig.getLogLevel().ordinal() <= logLevel.ordinal()) {
            System.out.println("DEBUG : " + content);
        }

        return execNext(content);
    }
}
