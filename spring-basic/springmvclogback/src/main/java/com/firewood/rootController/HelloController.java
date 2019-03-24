package com.firewood.rootController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/")
    public String home() {
        logger.info("hello - info");
        logger.warn("hello - warn");
        logger.debug("hello - debug");
        logger.error("hello - error");
        return "home";
    }
}
