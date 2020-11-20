package com.msh.www.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的类
 * @author dn26
 */
@Component
public class EmailService {

    @Resource
    private JavaMailSender javaMailSender;

    @Value("${mail.form}")
    private String form;


    @Async
    public void sendMail(String to,String message){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        try {
            helper.setFrom("尚马教育<m15695209510@163.com>");
            helper.setTo(to);
            helper.setSubject("新员工信息");
            helper.setText(message,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
