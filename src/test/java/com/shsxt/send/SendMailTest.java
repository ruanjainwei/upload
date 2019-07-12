package com.shsxt.send;

import org.junit.Test;

import javax.mail.MessagingException;

import java.io.UnsupportedEncodingException;


/**
 * created by Savage
 * 2019/7/5 current system date
 */
public class SendMailTest {

    @Test
    public void send() throws UnsupportedEncodingException, MessagingException {
        new SendMail().send();
        System.out.println("发送成功");
    }
}