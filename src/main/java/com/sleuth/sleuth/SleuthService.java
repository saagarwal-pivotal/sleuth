package com.sleuth.sleuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SleuthService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @NewSpan
    public void doSomeWorkSameSpan(@SpanTag("testTag") String name) throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("Doing some work" + name);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");

        // Not setting these headers will make down stream create new span and trace ids.
        headers.add("X-B3-TraceId", MDC.get("X-B3-TraceId"));
        headers.add("X-B3-SpanId", MDC.get("X-B3-SpanId"));

        logger.info(">>>>>>>>>>>>>>>>>> Print the trace Id from MDC >>>>>>>>>" + MDC.get("X-B3-TraceId"));
        logger.info(">>>>>>>>>>>>>>>>>> Print the span Id from MDC >>>>>>>>>" + MDC.get("X-B3-SpanId"));
        ResponseEntity<String> entity = getRestTemplate().exchange(
                "http://localhost:8081/hi", HttpMethod.GET, new HttpEntity<Object>(headers),
                String.class);
    }
}
