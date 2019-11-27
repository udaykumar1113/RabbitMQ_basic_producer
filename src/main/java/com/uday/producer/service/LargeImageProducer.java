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
public class LargeImageProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;
    List<String> types=new ArrayList<>();
    List<String> sources=new ArrayList<>();
    public void generateLargeImage() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        types.add("jpg");types.add("png");types.add("svg");types.add("mobile");types.add("long");
        types.add("abc.large.svg");types.add("abc.abc.svg");
        sources.add("mobile");sources.add("web");
        for(int i=0;i<1;i++){
            rabbitTemplate.convertAndSend("x.mypicture",types.get(i%5),
                    objectMapper.writeValueAsString(new Picture("picture_"+i+"."+types.get(i%3),sources.get(i%2),
                            types.get(i%3), ThreadLocalRandom.current().nextLong(9001,10000))));
            System.out.println("Generated large image "+(i+1));
        }
    }
}
