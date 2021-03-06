package com.bpm.workflow.camundaServiceTask;

import com.bpm.workflow.Helpers.TaskHelper;
import com.bpm.workflow.models.Project;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Component
public class ValidateProjectDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(AddProjectDelegate.class.getName());

    private static final LocalDate deadline = LocalDate.of(2021, 12, 30);


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Project project = TaskHelper.getProject(delegateExecution);
        LOGGER.info(String.format("Validating project %s", project.getName()));
        LocalDate currentDate = LocalDate.now();
        Random random = new Random();
        if (currentDate.isBefore(deadline) && random.nextBoolean()) {
            LOGGER.info(String.format("Project %s is valid", project.getName()));
            delegateExecution.setVariable("isValidated", true);
        } else {
            LOGGER.info(String.format("Project %s is not valid", project.getName()));
            delegateExecution.setVariable("isValidated", false);
        }
    }
}
