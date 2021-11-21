package com.bpm.workflow;


import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class Application {

  private final static Logger LOGGER = LoggerFactory.getLogger(Application.class.getName());

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
    LOGGER.info("Application started");
  }

}
