package com.bpm.workflow.controllers;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/camunda")
public class RestControllers {

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

}
