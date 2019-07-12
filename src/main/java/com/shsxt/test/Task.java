package com.shsxt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * created by Savage
 * 2019/7/5 current system date
 */
public class Task {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("发送成功");
    }
}
