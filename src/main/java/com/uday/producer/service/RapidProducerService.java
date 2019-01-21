package com.uday.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RapidProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 5000)
    public void bulkPublishMessages() throws InterruptedException {
        for(int i=1;;i++){
            Thread.sleep(5000);
            String message=i+ " message generated at "+ LocalDateTime.now();
            System.out.println(message);
            rabbitTemplate.convertAndSend("com.uday.rapidProducerEventsQueue",
                    message);
        }
    }
}
