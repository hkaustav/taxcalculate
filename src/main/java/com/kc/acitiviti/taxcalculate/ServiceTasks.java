package com.kc.acitiviti.taxcalculate;

import org.activiti.api.process.runtime.connector.Connector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ServiceTasks {

    @Bean
    public Connector processTaxTask() {
        return integrationContext -> {
            Map inBoundVariables = integrationContext.getInBoundVariables();
            System.out.println("Calculating tax...");
            Double income = Double.parseDouble(inBoundVariables.get("income").toString());
            Double taxRate = Double.parseDouble(inBoundVariables.get("taxRate").toString());

            if (income != null && taxRate != null) {
                Double tax = income * taxRate;
                System.out.println("Calculated tax: " + tax);
                integrationContext.addOutBoundVariable("amount", tax);
            }
            return integrationContext;
        };
    }

    @Bean
    public Connector sendEmailTask() {
        return integrationContext -> {
            Map inBoundVariables = integrationContext.getInBoundVariables();
            System.out.println("Mail Sent");
            return integrationContext;
        };
    }
}
