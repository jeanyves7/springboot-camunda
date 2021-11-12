package com.bpm.workflow;

import com.bpm.workflow.Repositories.ProjectsRepository;
import com.bpm.workflow.dto.Project;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

@Component
public class AddProjectDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(AddProjectDelegate.class.getName());
//    private final ProjectsRepository projectsRepository;
//
//    public AddProjectDelegate(ProjectsRepository projectsRepository) {
//        this.projectsRepository = projectsRepository;
//    }

    @Autowired
    private  ProjectsRepository projectsRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("received project of ");
        HashMap<String,String> projectMap = (HashMap<String, String>) delegateExecution.getVariable("project");
        Set<String> keys =  projectMap.keySet();
        ArrayList<String> values=new ArrayList<>();
        for (String key : keys) {
            values.add(projectMap.get(key));
        }
        delegateExecution.setVariable("isAdded", true);
        Project p=new Project(values.get(0),values.get(1));
        String name =p.getName();
        System.out.println(name);
        this.projectsRepository.save(p);

//        if (this.projectsRepository.save(new Project())!=null) {
//            delegateExecution.setVariable("isAdded", true);
//        } else {
//            delegateExecution.setVariable("isAdded", false);
//        }
    }
}
