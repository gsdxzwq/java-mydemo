package com.zhaowq.zookeeper.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @ClassName: Startup
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhaowq
 * @date 2015年12月30日下午3:10:20
 *
 */
public class Startup {
    private static Logger logger = LoggerFactory.getLogger(Startup.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ctx.start();
        logger.isDebugEnabled();
        while (true) {
            logger.info("info.....");
            logger.debug("error...");
            try {
                logger.info("sleep.....");
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                logger.error("InterruptedException", e);
            }
        }
    }
}
