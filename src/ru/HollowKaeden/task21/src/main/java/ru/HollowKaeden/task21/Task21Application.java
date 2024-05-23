package ru.HollowKaeden.task21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Task21Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Task21Application.class, args);
	}
}