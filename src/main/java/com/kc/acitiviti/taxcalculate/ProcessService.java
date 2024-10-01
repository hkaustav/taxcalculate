package com.kc.acitiviti.taxcalculate;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProcessService {

    @Autowired
    private RuntimeService runtimeService;

    public ProcessInstance startProcess(String income) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("income", income);
        variables.put("taxRate", ".3");

        return runtimeService.startProcessInstanceByKey("taxCalculateAdvanced", variables);
    }
}

