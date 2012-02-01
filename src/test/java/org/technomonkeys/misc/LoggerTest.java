package org.technomonkeys.misc;

import org.apache.log4j.Logger;

import org.junit.Test;

public class LoggerTest {
	
	@Test
	public void testLogging() {
		Logger logger = Logger.getLogger(LoggerTest.class);
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
	}
}
