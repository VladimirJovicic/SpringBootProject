package Meal_project.Meal_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class MealsApplication extends SpringBootServletInitializer{
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MealsApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(MealsApplication.class, args);
		
		System.out.println("TEST TEST TEST TEST");

		
	}
}
