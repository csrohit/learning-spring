package io.csrohit.jpasearchpageable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
public class JpaSearchPageableApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSearchPageableApplication.class, args);

	}

	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.OAS_30)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("io.csrohit"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails(){
		return new ApiInfo(
				"DB search project by Rohit",
				"Sample API for demonstrating swagger with jwt auth",
				"1.0",
				"Free to use",
				new Contact("Rohit Nimkar", "github.com/csrohit", "rohit.nimkar@outlook.com"),
				"No Liscence",
				"no liscence url",
				Collections.emptyList()

		);
	}


}
