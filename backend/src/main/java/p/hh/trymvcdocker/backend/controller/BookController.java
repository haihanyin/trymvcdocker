package p.hh.trymvcdocker.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import p.hh.trymvcdocker.backend.domain.Book;
import p.hh.trymvcdocker.backend.service.BookService;

import java.util.List;


@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Book getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }

    @GetMapping(value = "/book/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @PostMapping(value = "/book/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Book addBook(@RequestParam String name) {
        return bookService.addBook(name);
    }
}
