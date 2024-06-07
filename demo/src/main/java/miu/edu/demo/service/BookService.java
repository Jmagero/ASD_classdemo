package miu.edu.demo.service;

import miu.edu.demo.model.Book;
import org.springframework.beans.factory.ObjectProvider;

import java.util.Optional;

public interface BookService {
    Optional<Book> addBook(Book book);
    Optional<Book> updateBook(Book book);
    void deleteBook(Book book);
    Optional<Book> findBookByIsbn(String isbn);
}
