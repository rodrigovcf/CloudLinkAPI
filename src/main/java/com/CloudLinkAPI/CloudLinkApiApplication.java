package com.CloudLinkAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import config.AzureStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(AzureStorageProperties.class)
public class CloudLinkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudLinkApiApplication.class, args);
	}

}
