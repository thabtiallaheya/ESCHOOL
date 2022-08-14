package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@EntityScan( basePackages = {"tn.esprit.entity"} )
@ComponentScan("tn.esprit")
//@EnableSwagger2
@EnableScheduling
@SpringBootApplication
@EnableAspectJAutoProxy
public class ESchoolBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESchoolBackEndApplication.class, args);
	}

}
