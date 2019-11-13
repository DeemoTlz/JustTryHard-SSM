package com.qjh.crud.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.slf4j.LoggerFactory;

public class LogTest {

    @Test
    public void testLog() {

        System.out.println("=====================其他库jar包 LOG4J 输出日志==========================");
        Logger logger = LogManager.getLogger(LogTest.class);
        logger.fatal("FATAL LOG");
        logger.error("ERROR LOG");
        logger.warn("WARN LOG");
        logger.info("INFO LOG");
        logger.debug("DEBUG LOG");
        logger.trace("TRANCE LOG");

        System.out.println("=====================本地程序 SLF4J 输出日志==========================");
        org.slf4j.Logger logger2 = LoggerFactory.getLogger(LogTest.class);
        logger2.error("ERROR LOG");
        logger2.warn("WARN LOG");
        logger2.info("INFO LOG");
        logger2.debug("DEBUG LOG");
        logger2.trace("TRANCE LOG");
    }
}
