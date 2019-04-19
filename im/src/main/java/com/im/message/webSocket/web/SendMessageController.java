package com.im.message.webSocket.web;


import com.common.web.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JialinLiu
 * @date 2019/4/19 0019 13:47
 */
@RestController
@RequestMapping("api/send")
public class SendMessageController {
    private final static String MAIL_DOMAIN = "http://SPRING-BOOT-ADMING-MAIL";
    @Autowired
    RestClient restClient;

    @PostMapping("hello")
    public void hello() {
        Map<String, Object> params = new HashMap<>(2);
        params.put("hello", "hello");
        Object o = restClient.getForJsonResult(MAIL_DOMAIN + "/api/mail/hello", params).getData();
    }
}
