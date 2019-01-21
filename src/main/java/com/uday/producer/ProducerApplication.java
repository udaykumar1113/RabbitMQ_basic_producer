package com.uday.producer;

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

@SpringBootApplication
@EnableScheduling
public class ProducerApplication implements CommandLineRunner {

    /*@Autowired
    private ProducerService producerService;*/
    //@Autowired
    //private EmployeeEventGenerator employeeEventGenerator;

    @Autowired
    private FanoutPublisherService fanoutPublisherService;

	public static void main(String[] args) {

		SpringApplication.run(ProducerApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //producerService.publishMessage("Message published at "+ LocalDateTime.now());
        //employeeEventGenerator.generateEmployees();
        fanoutPublisherService.publishToFanoutExchange();

    }
}

