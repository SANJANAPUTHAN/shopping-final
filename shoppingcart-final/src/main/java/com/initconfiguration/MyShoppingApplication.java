package com.initconfiguration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = {"com"})
public class MyShoppingApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx = SpringApplication.run(MyShoppingApplication.class, args);		
	}
}
