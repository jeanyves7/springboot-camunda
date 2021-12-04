package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.Repositories.ProjectsRepository;
import com.bpm.workflow.models.Project;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateApprovalStatusDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(UpdateApprovalStatusDelegate.class.getName());

    @Autowired
    ProjectsRepository projectsRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Project project= TaskHelper.getProject(delegateExecution);
        LOGGER.info(String.format("Updating status of  %s's project",project.getName()));
        projectsRepository.updateProjectApprovalStatus(project.getName(),true);
        LOGGER.info(String.format("Update done, project of %s is approved",project.getName()));
    }
}
