package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.Repositories.ProjectsRepository;
import com.bpm.workflow.dto.MailDTO;
import com.bpm.workflow.dto.Project;
import com.bpm.workflow.services.SendMailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class sendApprovedProjects implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(sendApprovedProjects.class.getName());
    private final String Approved_Message = "Congratulations!,\n your project has been approved please wait to get more info for the next step\n\n Best Regards,\nFyp Committee";
    private final SendMailService sendMailService;



    @Autowired
    private ProjectsRepository projectsRepository;

    public sendApprovedProjects(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Beginning to send the approved projects ");
        List<Project> projectsApproved = this.projectsRepository.findAllProjectsToSend();
        int i=0;
        while (i<projectsApproved.size()){
            MailDTO mail= TaskHelper.buildMailTosend(projectsApproved.get(i).getEmail(),"Porposal Approved!",this.Approved_Message);
            this.sendMailService.sendMail(mail);
            this.projectsRepository.updateNotificationStatus(mail.getRecipient());
           i++;
        }
        LOGGER.info("All email for approved projects are sent ");
    }
}
