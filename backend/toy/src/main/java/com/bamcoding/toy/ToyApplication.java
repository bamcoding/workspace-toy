package com.bamcoding.toy;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class ToyApplication {

	public static void main(String[] args) {

		SpringApplication.run(ToyApplication.class, args);
	}

}
