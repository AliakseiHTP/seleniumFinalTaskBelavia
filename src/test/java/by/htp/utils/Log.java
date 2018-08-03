package by.htp.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
	private static final Logger logger;
	
	static {
		logger = LogManager.getRootLogger();
	}
	
	public static void getLogInfo(String s){
        logger.info(s);
    }
	
	public static void getLogWarn(String s){
        logger.warn(s);
    }
	
	public static void getLogFatal(String s){
        logger.fatal(s);
    }
}
