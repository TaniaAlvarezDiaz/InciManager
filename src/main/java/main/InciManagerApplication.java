package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"util", "controllers", "services", "repositories", "model", "apacheKafka"})
public class InciManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InciManagerApplication.class, args);
	}
}
