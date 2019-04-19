package com.mail.web;

import com.mail.model.dto.MailHtmlDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author JialinLiu
 * @date 2018/10/22 0022 10:36
 */
@RestController
@RequestMapping("api/mail")
public class MailController {
    private static Logger logger = LoggerFactory.getLogger(MailController.class);

    @ApiOperation(value = "邮件", tags = "发送HTML邮件")
    @PostMapping("send/HtmlMail")
    public void sendHtmlMail(MailHtmlDto mailHtmlDto) {

    }

//    private final static String MAIL_DOMAIN = "http://SPRING-BOOT-ADMING-MAIL";
//    @Autowired
//    RestClient restClient;

    @PostMapping("hello")
    public void hello(@RequestBody Map<String, Object> params, HttpServletRequest request) {
        System.out.println(params);
        System.out.println(params.size());
//        Map<String, Object> params = new HashMap<>(2);
//        params.put("hello", "hello");
//        Object o = restClient.getForJsonResult(MAIL_DOMAIN + "api/send/hello", params).getData();
    }
}
