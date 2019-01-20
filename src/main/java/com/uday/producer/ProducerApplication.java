package com.uday.producer;

import com.uday.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

    @Autowired
    private ProducerService producerService;

	public static void main(String[] args) {

		SpringApplication.run(ProducerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        producerService.publishMessage("Message published at "+ LocalDateTime.now());
    }
}

