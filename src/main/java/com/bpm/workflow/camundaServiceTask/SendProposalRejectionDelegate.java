package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.dto.Mail;
import com.bpm.workflow.dto.Project;
import com.bpm.workflow.services.SendMailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SendProposalRejectionDelegate implements JavaDelegate {

    private final SendMailService sendMailService;
    private final Logger LOGGER = LoggerFactory.getLogger(SendProposalRejectionDelegate.class.getName());

    public SendProposalRejectionDelegate(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Getting rejected project info: ");
        Project project = TaskHelper.getProject(delegateExecution);
        LOGGER.info(String.format("Project %s was rejected, proceeding to send rejection email to %s", project.getName(), project.getEmail()));
        Mail mail = new Mail(project.getEmail(), "", "");
        if ((boolean) delegateExecution.getVariable("isAdded")) {
            LOGGER.info(String.format("Project %s was rejected it wasn't valid", project.getName()));
            mail.setSubject("Project Validation Failure");
            mail.setMessage("Your project was rejected due to validation reasons \nyou can follow up with us by contacting us on +96103445566");
        } else {
            LOGGER.info(String.format("Project %s was rejected due to parameters validation", project.getName()));
            mail.setSubject("Project Invalid Parameters");
            mail.setMessage("Your project was rejected due to invalid parameters in the request please be more careful next time you submit a project");
        }
        sendMailService.sendMail(mail);
    }
}
