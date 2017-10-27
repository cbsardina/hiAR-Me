package com.arproject.arproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Properties;

@SpringBootApplication
public class FinalProjectArApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FinalProjectArApplication.class, args);

		FileInputStream propFile = new FileInputStream("projectProperties.txt");
		Properties p = new Properties(System.getProperties());
		p.load(propFile);
		System.setProperties(p);
		System.getProperties().list(System.out);


	}
}
