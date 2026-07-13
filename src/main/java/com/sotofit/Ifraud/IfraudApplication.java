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
	//	@Bean
	//	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
	//		return runner -> {
	//			createStudent(studentDAO);
	//		};
	//	}

	//	private void createStudent(StudentDAO studentDAO) {
	//		// Create the Student object
	//		System.out.println("Creating new student object");
	//		Student student = new Student(
	//			"Alamu",
	//			"Gboluwaga",
	//			"alamugboluwaga402@gmail.com",
	//			"08034936022",
	//			"No4 adeyemo street",
	//			LocalDate.of(1985, 11, 11),
	//			LocalDateTime.now(),
	//			LocalDateTime.now()
	//		);
	//
	//		//save htr stude nt object
	//		studentDAO.save(student);
	//
	//		//display id of the saved student
	//		System.out.println("Student saved with id: " + student.getId());
	//	}
}
