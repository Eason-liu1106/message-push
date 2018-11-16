package com.mail.service;

import com.mail.model.dto.MailHtmlDto;

import javax.mail.MessagingException;

/**
 * @author JialinLiu
 * @date 2018/10/22 0022 16:13
 */
public interface MailSend {
    /**
     *
     * @param mailHtmlDto 邮件参数实体
     * @author  JialinLiu
     * @date  2018/10/22 0022 18:13
     */
    void sendHtmlMail(MailHtmlDto mailHtmlDto) throws MessagingException;
}
