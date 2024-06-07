package miu.edu.cs.asd.pageabletodemo;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.pageabletodemo.dto.BookRequestDto;
import miu.edu.cs.asd.pageabletodemo.model.Book;
import miu.edu.cs.asd.pageabletodemo.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class PageabletodemoApplication implements CommandLineRunner {
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(PageabletodemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BookRequestDto bookRequestDto = new BookRequestDto("1234A", "new book", LocalDate.of(1990,2,10),  BigDecimal.valueOf(2000.00));
        BookRequestDto bookRequestDto1 = new BookRequestDto("1234B", "new book2", LocalDate.of(2000,5,10),  BigDecimal.valueOf(1000.00));
        BookRequestDto bookRequestDto2 = new BookRequestDto("1234C", "new book3", LocalDate.of(1999,10,10), BigDecimal.valueOf(5000.00));
        BookRequestDto bookRequestDto3 = new BookRequestDto("1234E", "new book4", LocalDate.of(1989,10,10), BigDecimal.valueOf(8000.00));
        BookRequestDto bookRequestDto4 = new BookRequestDto("1234D", "new book5", LocalDate.of(2023,4,30), BigDecimal.valueOf(2000.00));
        BookRequestDto bookRequestDto5 = new BookRequestDto("1234F", "new book6", LocalDate.of(2022,5,22), BigDecimal.valueOf(10000.00));


        List<BookRequestDto> bookRequestDtoList = Arrays.asList(
                bookRequestDto, bookRequestDto1, bookRequestDto2, bookRequestDto3, bookRequestDto4, bookRequestDto5);

        System.out.println(
                bookService.addAllBooks(bookRequestDtoList) + " books saved"
        );

        bookService.findAllBooks(1,3, "DESC","title")
                .forEach(System.out::println);


    }
}
