package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.dto.Project;
import com.bpm.workflow.services.SendMailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendProposalRejection implements JavaDelegate {

    private final TaskHelper taskHelper=new TaskHelper();
    private  final SendMailService service;
    private final Logger LOGGER = LoggerFactory.getLogger(SendProposalRejection.class.getName());

    public SendProposalRejection(SendMailService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Project project=taskHelper.getProject(delegateExecution);

    }
}
