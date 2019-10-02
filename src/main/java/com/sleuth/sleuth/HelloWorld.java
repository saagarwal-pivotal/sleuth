package com.sleuth.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

@Autowired
        SleuthService service;

    Logger log = LoggerFactory.getLogger(this.getClass());



    @RequestMapping("/hello")

    public String hello(){

        log.info("gtee");
        try {
            service.doSomeWorkSameSpan("jjjjjjjjjjjjj");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "Hello ";
    }
}
