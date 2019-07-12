package com.shsxt.send;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * created by Savage
 * 2019/7/5 current system date
 */
public class MyAuthenticator extends Authenticator {

    private String username;
    private String userpwd;

    public MyAuthenticator(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username,userpwd);
    }
}
