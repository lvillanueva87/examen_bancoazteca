package com.jvillanueva.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@ComponentScan(basePackages= {"com.jvillanueva.controller", "com.jvillanueva.config"})
public class MainBoot
{
	
	public MainBoot(){}

	public static void main(String[] args)
	{
		SpringApplication.run(MainBoot.class, args);
	}

}
