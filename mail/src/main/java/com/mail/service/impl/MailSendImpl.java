package com.mail.service.impl;

import com.mail.model.dto.MailHtmlDto;
import com.mail.service.MailSend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author JialinLiu
 * @date 2018/10/22 0022 18:31
 */
@Service
public class MailSendImpl implements MailSend {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender mailSender;

    /**
     * @param mailHtmlDto 邮件参数实体
     * @author JialinLiu
     * @date 2018/10/22 0022 18:13
     */
    @Override
    public void sendHtmlMail(MailHtmlDto mailHtmlDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(mailHtmlDto.getFrom());
        helper.setTo(mailHtmlDto.getTo());
        helper.setSubject(mailHtmlDto.getSubject());
        helper.setText(mailHtmlDto.getText(), true);
        mailSender.send(message);
    }
}
