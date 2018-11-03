package com.patrickstar.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackBasic {
	public static void main(String[] args) {
        Logger logger =  LoggerFactory.getLogger(LogbackBasic.class);
        logger.info("Hello World");
        logger.warn("Warn Test");
        logger.debug("Debug Test");
        
        logger.debug(LogbackBasic.class.getName());
        
        try {
        	int a = 1/0;
        } catch (Exception e) {
        	logger.error(LogbackBasic.class.getSimpleName(), e);
        }
        
        System.out.println("Done");
	}
}
