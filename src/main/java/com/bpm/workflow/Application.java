package com.bpm.workflow;


import org.camunda.bpm.model.bpmn.builder.CamundaStartEventFormFieldBuilder;
import org.camunda.bpm.model.bpmn.impl.instance.camunda.CamundaPotentialStarterImpl;
import org.camunda.bpm.model.bpmn.instance.Process;
import org.camunda.bpm.model.bpmn.instance.StartEvent;
import org.camunda.bpm.model.bpmn.instance.camunda.CamundaExpression;
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
