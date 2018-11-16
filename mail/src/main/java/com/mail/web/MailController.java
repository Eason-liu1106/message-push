package com.mail.web;

import com.mail.model.dto.MailHtmlDto;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void sendHtmlMial(MailHtmlDto mailHtmlDto){

    }
}
