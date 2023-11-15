package com.boaglio.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.boaglio")
@SpringBootApplication
public class JavaKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaKafkaApplication.class, args);
	}

}
