package com.example.department;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;

@SpringBootApplication
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}
	
	
	
	
	
	// Bean to insert test data on startup
    @Bean
    CommandLineRunner initDatabase(DepartmentRepository departmentRepository) {
        return args -> {
            departmentRepository.save(Department.builder()
                    .name("Engineering")
                    .location("New York")
                    .head("Alice Johnson")
                    .build());

            departmentRepository.save(Department.builder()
                    .name("Marketing")
                    .location("London")
                    .head("Bob Smith")
                    .build());

            departmentRepository.save(Department.builder()
                    .name("Finance")
                    .location("Berlin")
                    .head("Clara Braun")
                    .build());
        };
	

}
}
