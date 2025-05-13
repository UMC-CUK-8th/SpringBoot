package Concurrency_Project.Hello_Concurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HelloConcurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloConcurrencyApplication.class, args);
	}

}
