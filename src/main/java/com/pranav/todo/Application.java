package com.pranav.todo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //This annotation tells the compiler that this is a Spring Boot program
public class Application //This is the code you run to run the whole project
{
	public static void main (String [] args)
	{
		SpringApplication.run(Application.class,args);
	}

}
