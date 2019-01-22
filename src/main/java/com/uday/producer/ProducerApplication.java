package com.uday.producer;

import com.uday.producer.service.DirectPublisherService;
import com.uday.producer.service.EmployeeEventGenerator;
import com.uday.producer.service.FanoutPublisherService;
import com.uday.producer.service.ProducerService;
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
    DirectPublisherService directPublisherService;

	public static void main(String[] args) {

		SpringApplication.run(ProducerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        directPublisherService.publishDirectMessages();
    }
}

