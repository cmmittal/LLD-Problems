package main.java.service;

import main.java.entity.LogLevel;
import main.java.entity.OutputType;

public class LoggerConfig {
    
    private LogLevel logLevel;
    private OutputType outputType;

    public LoggerConfig(LogLevel logLevel, OutputType outputType){
        this.logLevel = logLevel;
        this.outputType = outputType;
    }

    public void setLogLevel(LogLevel logLevel){
        this.logLevel = logLevel;
    }

    public LogLevel getLogLevel(){
        return this.logLevel;
    }

    public void setOutputType(OutputType outputType){
        this.outputType = outputType;
    }

    public OutputType getOutputType(){
        return this.outputType;
    }
}
