package com.uday.producer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uday.producer.entity.Picture;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DirectPublisherService {

    List<String> types=new ArrayList<>();
    List<String> sources=new ArrayList<>();

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void publishDirectMessages() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        types.add("jpg");types.add("png");types.add("svg");
        sources.add("mobile");sources.add("web");
        for(int i=0;i<10;i++){
            rabbitTemplate.convertAndSend("x.picture",types.get(i%3),
                    objectMapper.writeValueAsString(new Picture("picture_"+i+"."+types.get(i%3),sources.get(i%2),
                                types.get(i%3), ThreadLocalRandom.current().nextLong(1,10000))));
        }
    }
}
