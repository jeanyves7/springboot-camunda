package com.bpm.workflow.config;
//
//import javax.servlet.Filter;
//import org.camunda.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
//import org.camunda.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CamundaSecurityFilter {
//
//  @Bean
//  public FilterRegistrationBean processEngineAuthenticationFilter() {
//    FilterRegistrationBean registration = new FilterRegistrationBean();
//    registration.setName("camunda-auth");
//    registration.setFilter(new ProcessEngineAuthenticationFilter());
//    registration.addInitParameter("authentication-provider", HttpBasicAuthenticationProvider.class.getName());
//    registration.addUrlPatterns("/*");
//    return registration;
//  }
//
//  @Bean
//  public Filter getProcessEngineAuthenticationFilter() {
//    return new ProcessEngineAuthenticationFilter();
//  }
//}
//
