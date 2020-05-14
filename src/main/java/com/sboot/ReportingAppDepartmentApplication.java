package com.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import com.sboot.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses=UserRepository.class)
@ComponentScan(basePackages= {"com.sboot"})
public class ReportingAppDepartmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReportingAppDepartmentApplication.class, args);
	}

	
	
	/*
	 * @Bean public javax.validation.Validator localValidatorFactoryBean() { return
	 * new LocalValidatorFactoryBean(); }
	 * 
	 * 
	 * @Bean public MethodValidationPostProcessor methodValidationPostProcessor() {
	 * return new MethodValidationPostProcessor(); }
	 */
}
