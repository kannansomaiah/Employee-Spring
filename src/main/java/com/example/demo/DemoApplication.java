package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/employee").allowedOrigins("http://localhost:4200");
            }
        };
    }

	@Override
	public void run(String... args) throws Exception {

		Employee emp1 = new Employee("Kannan", "Somaiah", "kannansomaiah@hotmail.com");
		Employee emp2 = new Employee("John", "Paul", "john.paul@gmail.com");

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
	}
}
