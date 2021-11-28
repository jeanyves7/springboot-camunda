package com.bpm.workflow.controllers;


import com.bpm.workflow.Repositories.ProjectsRepository;
import com.bpm.workflow.dto.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camunda")
public class RestControllers {

    @Autowired
    ProjectsRepository projectsRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(RestControllers.class.getName());
    @GetMapping
    public String getTreeById() {
        return "hello from camunda";
    }

    // Simple authentication service
    @GetMapping("logIn")
    public Boolean CheckLogIn(@RequestParam("userName")String userName,@RequestParam("userPassword")String userPass){
        LOGGER.info(String.format("Received request to check credentials for user: %s",userName));
        // its a POC we wont implement an authentication service for now
        return userName.toLowerCase().contentEquals("admin") && (userPass.toLowerCase().contentEquals("admin"));
    }

    @GetMapping("projects")
    public List<Project> GetAllProjects(){
        LOGGER.info("Getting the list of all the projects");
        return this.projectsRepository.findAll();
    }

}
