package com.uday.producer;

import com.uday.producer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    TopicPublisherService topicPublisherService;

	public static void main(String[] args) {

		SpringApplication.run(ProducerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        topicPublisherService.generateMessagesForTopic();
    }
}

