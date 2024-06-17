package miu.edu.cs.asd.bms.service;

import miu.edu.cs.asd.bms.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    private static List<Book> books = Arrays.asList(
            new Book("Spring in Action", 2023),
            new Book ("Angular in Action", 1990),
            new Book("JavaScript", 1991)
    );
    public List<Book> getBooks(String username) {
        if(username != null && !username.isEmpty()){
            return books;
        }
        return List.of(books.get(0));
    }

    public void addBook(Book book) {
        books.add(book);
    }


}
