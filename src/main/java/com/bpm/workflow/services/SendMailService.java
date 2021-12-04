package com.bpm.workflow.services;

import com.bpm.workflow.models.MailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendMailService implements ISendMailService {


    private final JavaMailSender javaMailSender;
    private final Logger LOGGER = LoggerFactory.getLogger(SendMailService.class.getName());

    public SendMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(MailDTO mailDTO) throws IOException {

        LOGGER.info(String.format("Sending email to %s",mailDTO.getRecipient()));

        SimpleMailMessage  msg = new SimpleMailMessage();
        msg.setTo(mailDTO.getRecipient(), mailDTO.getRecipient());
        mailDTO.setSubject(mailDTO.getSubject());
        msg.setText(mailDTO.getMessage());
        javaMailSender.send(msg);

    }


}
