package com.bpm.workflow.Helpers;

import com.bpm.workflow.dto.MailDTO;
import com.bpm.workflow.dto.Project;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TaskHelper {

    public static Project getProject(DelegateExecution delegateExecution) {
        HashMap<String, String> projectMap = (HashMap<String, String>) delegateExecution.getVariable("project");
        Set<String> keys = projectMap.keySet();
        ArrayList<String> values = new ArrayList<>();
        for (String key : keys) {
            values.add(projectMap.get(key));
        }
        return new Project(values.get(0), values.get(1), values.get(2));
    }

    private static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    public static boolean ValidateParameters(Project project) {
        String name = project.getName();
        String description = project.getDescription();
        String email = project.getEmail();
        if (name.isEmpty() || description.isEmpty() || email.isEmpty()) {
            return false;
        }
        return isValidEmailAddress(email);
    }

    public static MailDTO buildMailTosend(String recepient, String subject, String message){
        return new MailDTO(recepient,recepient,message);
    }

}
