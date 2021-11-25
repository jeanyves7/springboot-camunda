package com.bpm.workflow.services;

import com.bpm.workflow.dto.MailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

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
        Email from = new Email("mdptwitter20@hotmail.com");
        String subject = mailDTO.getSubject();
        Email to = new Email(mailDTO.getRecipient());
        Content content = new Content("text/plain", mailDTO.getMessage());
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid("SENDGRID_API_KEY");
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sg.api(request);
        LOGGER.info(String.format("Email sent to %s",mailDTO.getRecipient()));


//        SimpleMailMessage  msg = new SimpleMailMessage();
//        msg.setTo(mailDTO.getRecipient(), mailDTO.getRecipient());
//        mailDTO.setSubject(mailDTO.getSubject());
//        msg.setText(mailDTO.getMessage());
//        javaMailSender.send(msg);

    }



}
