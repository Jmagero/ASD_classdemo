package miu.edu.demo;

import lombok.RequiredArgsConstructor;
import miu.edu.demo.model.Address;
import miu.edu.demo.model.Author;
import miu.edu.demo.model.Book;
import miu.edu.demo.model.Publisher;
import miu.edu.demo.service.BookService;
import miu.edu.demo.service.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {
    private final PublisherService publisherService;
    private final BookService bookService;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Publisher publisher = new Publisher();
//        publisher.setPublisherName("Apres");
//        Address address = new Address("2002 N C St", "Fairfeild", "IA");
//        publisher.setAddress(address);
//        System.out.println("Publisher name: " + publisherService.addPublisher(publisher).get() + " is saved");

        Book book = new Book();
        book.setTitle("Spring");
        book.setIsbn("1223B");
        List<Author> authors = List.of(
                new Author("John", "Doe"),
                new Author("Jane", "Doe")
        );
        book.setAuthors(authors);
        System.out.println(bookService.addBook(book).get().getTitle()+ " is saved");

    }
}
