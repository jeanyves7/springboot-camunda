package com.bpm.workflow.services;

import com.bpm.workflow.models.MailDTO;

import java.io.IOException;


public interface ISendMailService {

    void sendMail(MailDTO mail) throws IOException;

}
