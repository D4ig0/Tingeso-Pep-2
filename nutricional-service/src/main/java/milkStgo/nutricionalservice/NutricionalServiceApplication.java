package milkStgo.nutricionalservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NutricionalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NutricionalServiceApplication.class, args);
	}

}
