package com.metrics;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan

public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
	new SpringApplicationBuilder(Application.class).profiles("prometheus").run(args);
	//	new SpringApplicationBuilder(Application.class).profiles("prometheus").run(args);

	}
}
