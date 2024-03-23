package com.wqa.exam;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.wqa.exam"})
@EntityScan(basePackages = "com.wqa.exam")
@OpenAPIDefinition(info = @Info(title = "Evaluacion Tecnica API", version = "2.0", description = "Evaluacion Tecnica- Information"))
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

}
