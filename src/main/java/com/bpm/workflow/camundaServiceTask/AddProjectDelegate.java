package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.Repositories.ProjectsRepository;

import com.bpm.workflow.dto.Project;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AddProjectDelegate implements JavaDelegate {


    private final Logger LOGGER = LoggerFactory.getLogger(AddProjectDelegate.class.getName());


    @Autowired
    private ProjectsRepository projectsRepository;


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Project project = TaskHelper.getProject(delegateExecution);
        LOGGER.info(String.format("Received project of %s", project.getName()));
        if (TaskHelper.ValidateParameters(project)) {
            LOGGER.info("Project parameters are valid proceeding to project validation ");
            this.projectsRepository.save(project);
            delegateExecution.setVariable("isAdded", true);


        } else {
            LOGGER.info("Project parameters are not valid");
            delegateExecution.setVariable("isAdded", false);
        }


    }
}
