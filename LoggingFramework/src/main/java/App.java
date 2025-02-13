package main.java;
import main.java.entity.LogLevel;
import main.java.entity.OutputType;
import main.java.service.DebugLogger;
import main.java.service.InfoLogger;
import main.java.service.Logger;
import main.java.service.LoggerConfig;
import main.java.service.WarnLogger;

public class App {
    public static void main(String[] args) throws Exception {
        LoggerConfig config = new LoggerConfig(LogLevel.DEBUG, OutputType.CONSOLE);

        Logger logger = Logger.link(
            new DebugLogger(config),
            new InfoLogger(config),
            new WarnLogger(config)
        );

        System.out.println("Logging with DEBUG Level :");
        logger.log("This is a Debug Log.");

        System.out.println("\n");

        System.out.println("Logging with Info Log");
        config.setLogLevel(LogLevel.INFO);

        logger.log("This is Info Log");

        System.out.println("\n");

        System.out.println("Logging with Warn Log");
        config.setLogLevel(LogLevel.WARNING);

        logger.log("This is Warn Log");
    }
}
