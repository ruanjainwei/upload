package com.shsxt.send;


import org.springframework.scheduling.annotation.Scheduled;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * created by Savage
 * 2019/7/5 current system date
 *
 * 发送电子邮件
 */
public class SendMail {
    @Scheduled(cron = "0/3 * * * * ? ")
    public void send() throws MessagingException, UnsupportedEncodingException {
        // 定义邮箱服务器配置
        Properties props=new Properties();
        // 163 邮件服务器地址
        props.put("mail.smtp.host", "smtp.163.com");
        // 163 邮件服务器端口
        props.put("mail.smtp.port", "25");
        // 163 邮件服务器认证属性
        props.put("mail.smtp.auth", "true");

        //2.设置session
        Session session=Session.getInstance(props,
                new MyAuthenticator("ruan15058331596@163.com","zhangrui123"));

        //3.发送消息
        Message message=new MimeMessage(session);
        // 设置发送人地址
        message.setFrom(new InternetAddress("ruan15058331596@163.com"));
        //目标用户邮箱地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("ruan15058331596@163.com"));
        message.setSentDate(new Date());// 设置发送日期
        message.setSubject("猜猜我是谁");//设置主题
        message.setText("我学习java");// 设置文本内容

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart bodyPart = new MimeBodyPart();
        FileDataSource fds=new FileDataSource(new File("E:\\class\\mycode\\spring07Email\\target\\psbGXEKDN02.jpg"));
        // 设置附件
        bodyPart.setDataHandler(new DataHandler(fds));
        // 设置文件名
        bodyPart.setFileName(MimeUtility.encodeText("爆照片了"));
        multipart.addBodyPart(bodyPart);
        //带附件结束
        //4.发送邮件
        Transport.send(message);// 发送
    }
}
