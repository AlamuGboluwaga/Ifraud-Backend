package com.sotofit.Ifraud;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IfraudApplication {

	public static void main(String[] args) {
		//Configuration of the dotenv-java
		Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().load();

		dotenv.entries().forEach((DotenvEntry entry) -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(IfraudApplication.class, args);
        System.out.println("Database is running on PORT 7070 ");
	}
}
