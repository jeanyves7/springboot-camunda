package com.bpm.workflow.services;


import com.bpm.workflow.dto.Mail;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailService implements ISendMailService {


    private final JavaMailSender javaMailSender;

    public SendMailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(Mail mail) {

        SimpleMailMessage  msg = new SimpleMailMessage();
        msg.setTo(mail.getRecipient(), mail.getRecipient());
        mail.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());

        javaMailSender.send(msg);
    }

}
