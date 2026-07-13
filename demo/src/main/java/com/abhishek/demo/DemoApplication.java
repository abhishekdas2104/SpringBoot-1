package com.abhishek.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Student student = new Student(45, "Abhi");

		System.out.println(student.getAge());
		System.out.println(student.getName());
	}
}
