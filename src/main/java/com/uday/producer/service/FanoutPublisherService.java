package com.uday.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.producer.entity.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FanoutPublisherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishToFanoutExchange() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        for(int i=1;i<=5;i++){
            String employeeJson=objectMapper
                    .writeValueAsString(new Employee("EMP_"+i,"Employee "+i));
            rabbitTemplate.convertAndSend("x.hr","",employeeJson);
            System.out.println("Published message to Fanout excange "+employeeJson);
        }
    }
}
