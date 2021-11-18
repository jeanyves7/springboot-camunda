package com.bpm.workflow.services;

import com.bpm.workflow.dto.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService implements ISendMailService {


    private final JavaMailSender javaMailSender;
    private final Logger LOGGER = LoggerFactory.getLogger(SendMailService.class.getName());

    public SendMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) {

        LOGGER.info(String.format("Sending email to %s",mail.getRecipient()));
        SimpleMailMessage  msg = new SimpleMailMessage();
        msg.setTo(mail.getRecipient(), mail.getRecipient());
        mail.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());
        javaMailSender.send(msg);
        LOGGER.info(String.format("Email sent to %s",mail.getRecipient()));
    }



}
