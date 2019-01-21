package com.uday.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmployeeEventGenerator {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void generateEmployees() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        for(int i=1;i<=5;i++){
            String employeeJson=objectMapper
                    .writeValueAsString(new Employee("EMP_"+i,"Employee "+i,
                            LocalDateTime.now()));
            rabbitTemplate.convertAndSend("com.uday.producerEventsQueue",employeeJson);
        }
    }
}
