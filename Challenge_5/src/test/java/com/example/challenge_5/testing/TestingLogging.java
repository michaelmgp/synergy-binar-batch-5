package com.example.challenge_5.testing;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestingLogging {

    private static Logger logger = LoggerFactory.getLogger(TestingLogging.class);

    @Test
    public  void testLogging(){
        logger.info("info logging level");
        logger.error("eror logging level");
        logger.warn("warning logging level");
        logger.debug("debug logging level");
        logger.trace("trace logging level");
    }
}
