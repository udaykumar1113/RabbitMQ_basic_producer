package com.uday.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishMessage(String message){
        System.out.println("Inside publish message before sending message");
        rabbitTemplate.convertAndSend("com.uday.producerEventsQueue",message);
        System.out.println("Inside publish message after sending message");
    }
}
