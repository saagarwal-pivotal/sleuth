package com.sleuth.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SleuthService service;

    @RequestMapping("/hello")
    public String hello() {
        log.info("<<<<< Inside hello >>>>>>>>>>>>>>>>>");
        try {
            service.doSomeWorkSameSpan("param1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello";
    }
}
