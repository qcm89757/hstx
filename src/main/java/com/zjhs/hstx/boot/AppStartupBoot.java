package com.zjhs.hstx.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qiancm
 * @description 启动时做一些检查
 */
@Component
@Order(8)
public class AppStartupBoot implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppStartupBoot.class);

    @Value("${server.port}")
    private String port;

    @Override
    public void run(String... strings) {
        logger.info("==========================================================================");
        logger.info(String.format("惠商天下后端接口 -请访问：http://localhost:%s/swagger-ui.html", port));
        logger.info("==========================================================================");
    }
}
