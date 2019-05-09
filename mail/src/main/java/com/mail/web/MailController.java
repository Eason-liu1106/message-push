package com.mail.web;

import com.mail.model.dto.MailHtmlDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author JialinLiu
 * @date 2018/10/22 0022 10:36
 */
@RestController
@RequestMapping("api/mail")
public class MailController {
    private static Logger logger = LoggerFactory.getLogger(MailController.class);

    // @ApiOperation(value = "邮件", tags = "发送HTML邮件")
    @PostMapping("send/HtmlMail")
    public void sendHtmlMail(MailHtmlDto mailHtmlDto) {

    }

    private final static String MAIL_DOMAIN = "http://SPRING-BOOT-ADMING-MAIL";
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("hello")
    @HystrixCommand
    public void hello(@RequestBody Map<String, Object> params, HttpServletRequest request) throws Exception {
        System.out.println(params + "8001");
        System.out.println(params.size());
        restTemplate.getForObject(MAIL_DOMAIN + "api/send/hello", String.class, params);
        throw new Exception("错误");
        //Map<String, Object> params = new HashMap<>(2);
//        params.put("hello", "hello");
    }

    public String defaulGetReprotByCityId() {
        return "降级";
    }
}
