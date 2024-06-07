package miu.edu.demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.demo.model.Book;
import miu.edu.demo.repository.BookRepository;
import miu.edu.demo.repository.PublisherRepository;
import miu.edu.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public Optional<Book> addBook(Book book) {
        return Optional.of( bookRepository.save(book));
    }

    @Override
    public Optional<Book> updateBook(Book book) {
        Optional<Book> book1 = bookRepository.findBookByIsbn(book.getIsbn());
        if(book1.isPresent()){
            book1.get().setTitle(book.getTitle());
            book1.get().setAuthors((book.getAuthors()));
            book1.get().setTitle(book.getTitle());
        }
        return Optional.of(bookRepository.save(book1.get()));
    }

    @Override
    public void deleteBook(Book book) {
       bookRepository.findBookByIsbn(book.getIsbn())
               .ifPresent(bookRepository::delete);
    }
    @Override
    public Optional<Book> findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }
}
