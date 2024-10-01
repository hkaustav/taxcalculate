package com.kc.acitiviti.taxcalculate;

import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @GetMapping("/start/{income}")
    public String startProcess(@PathVariable String income) {
        ProcessInstance processInstance = processService.startProcess(income);
        return "Process started with ID: " + processInstance.getId();
    }

    @GetMapping("/health")
    public String initProcess() {
        return "Tax calculation service started";
    }
}

