package main.java.service;

import main.java.entity.LogLevel;

public class InfoLogger extends Logger{

    public InfoLogger(LoggerConfig config){
        super(config, LogLevel.INFO);
    }

    public boolean log(String content){
        if (loggerConfig.getLogLevel().ordinal() <= logLevel.ordinal()) {
            System.out.println("INFO: " + content);   
        }

        return execNext(content);
    }
}
