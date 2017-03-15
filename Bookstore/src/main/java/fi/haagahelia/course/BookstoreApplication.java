package fi.haagahelia.course;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.course.domain.*;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("Save a few books");
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "1232323-21", 1929));
			repository.save(new Book("Geogre Orwell", "Animal Farm", "2212343-5", 1945));	
			
			log.info("Fetching all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
