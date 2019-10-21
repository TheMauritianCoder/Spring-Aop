package services.ravi.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class AspectTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectTutorialApplication.class, args);
	}

}
