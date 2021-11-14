package com.bpm.workflow.Helpers;

import com.bpm.workflow.dto.Project;
import org.camunda.bpm.engine.delegate.DelegateExecution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TaskHelper {

    public  Project getProject(DelegateExecution delegateExecution){
        HashMap<String,String> projectMap = (HashMap<String, String>) delegateExecution.getVariable("project");
        Set<String> keys =  projectMap.keySet();
        ArrayList<String> values=new ArrayList<>();
        for (String key : keys) {
            values.add(projectMap.get(key));
        }
        return new Project(values.get(0),values.get(1),values.get(2));
    }



}
