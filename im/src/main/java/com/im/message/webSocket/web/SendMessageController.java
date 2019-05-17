package com.im.message.webSocket.web;


import com.common.web.client.RestClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JialinLiu
 * @date 2019/4/19 0019 13:47
 */
@RestController
@RequestMapping("api/send")
public class SendMessageController {
    private final static String MAIL_DOMAIN = "http://SPRING-BOOT-ADMIN-MAIL";
    @Autowired
    RestClient restClient;
//    @Autowired
    // RestTemplate restTemplate;

    @PostMapping("hello")
    @HystrixCommand(fallbackMethod = "defaulGetReprotByCityId")
    public String hello() {
        Map<String, Object> params = new HashMap<>(1);
        params.put("hello", "hello");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map> requestEntity = new HttpEntity<>(params, headers);
        restClient.exchange(MAIL_DOMAIN + "/api/mail/hello", HttpMethod.POST, requestEntity, String.class);
        return "success";
    }

    public String defaulGetReprotByCityId() {
        return "降级";
    }
}
