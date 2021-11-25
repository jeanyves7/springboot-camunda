package com.bpm.workflow.services;

import com.bpm.workflow.dto.MailDTO;

import java.io.IOException;


public interface ISendMailService {

    void sendMail(MailDTO mail) throws IOException;

}
