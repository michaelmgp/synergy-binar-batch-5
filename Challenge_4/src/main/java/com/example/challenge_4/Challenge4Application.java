package com.example.challenge_4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Challenge4Application {

	public static void main(String[] args) {
		SpringApplication.run(Challenge4Application.class, args);

	}
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/**"))
//				.apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo")).build();
//	}
}
