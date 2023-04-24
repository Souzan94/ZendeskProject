package com.system.ZenDesk.Widget.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {


    @Autowired
  private   JavaMailSender javaMailSender;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public void SendMessage(String to, String subject, String message){
        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();

        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        logger.info(subject);
        logger.info(to);
        logger.info(message);
        javaMailSender.send(simpleMailMessage);

    }
}
