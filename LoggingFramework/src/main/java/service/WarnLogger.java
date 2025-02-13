package main.java.service;

import main.java.entity.LogLevel;

public class WarnLogger extends Logger{

    public WarnLogger(LoggerConfig config){
        super(config, LogLevel.WARNING);
    }

    public boolean log(String content){
        if (loggerConfig.getLogLevel().ordinal() <= logLevel.ordinal()) {
            System.out.println("WARN : " + content);
        }

        return execNext(content);
    }
}
