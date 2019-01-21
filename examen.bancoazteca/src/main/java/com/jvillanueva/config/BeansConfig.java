package com.jvillanueva.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jvillanueva.utils.MongoDBFactory;

@Configuration
public class BeansConfig {
	
	@Bean
	public MongoDBFactory getMongoDBFactory()
	{
		return new MongoDBFactory();
	}

}
