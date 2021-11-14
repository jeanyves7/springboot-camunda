package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.Repositories.ProjectsRepository;
import com.bpm.workflow.dto.Mail;
import com.bpm.workflow.dto.Project;
import com.bpm.workflow.services.SendMailService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

@Component
public class AddProjectDelegate implements JavaDelegate {

    private  final SendMailService service;
    private final Logger LOGGER = LoggerFactory.getLogger(AddProjectDelegate.class.getName());
    private  final TaskHelper taskHelper=new  TaskHelper();


    @Autowired
    private  ProjectsRepository projectsRepository;

    public AddProjectDelegate(SendMailService service) {
        this.service = service;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("received project of ");

        Project project= taskHelper.getProject(delegateExecution);
        this.projectsRepository.save(project);

        Mail mail=new Mail(project.getEmail(),"Project Deposition","Your project has been deposed");
        Random rand=new Random();
        if(rand.nextBoolean()){
            LOGGER.info("yay it passed ");
            service.sendMail(mail);
            delegateExecution.setVariable("isAdded",true);
        }else{
            LOGGER.info("Ntakna ");
            delegateExecution.setVariable("isAdded",false);
        }

//        if (this.projectsRepository.save(new Project())!=null) {
//            delegateExecution.setVariable("isAdded", true);
//        } else {
//            delegateExecution.setVariable("isAdded", false);
//        }
    }
}
