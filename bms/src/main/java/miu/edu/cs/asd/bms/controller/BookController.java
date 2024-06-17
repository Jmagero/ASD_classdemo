package miu.edu.cs.asd.bms.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.asd.bms.model.Book;
import miu.edu.cs.asd.bms.model.UserForm;
import miu.edu.cs.asd.bms.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public String getBooks(@ModelAttribute UserForm userForm, Model model) {
        model.addAttribute("username", userForm.getUsername());
        model.addAttribute("email", userForm.getUsername());
        List<Book> bookList =  bookService.getBooks(userForm.getUsername());
        model.addAttribute("books", bookList);
        return "book_page";
    }

    @GetMapping("/create")
    public String addBook() {
        return "create_book";
    }
    @PostMapping
    public String addNewBook(@ModelAttribute Book  book) {
        bookService.addBook(book);
        return "redirect:/books";
    }
}
