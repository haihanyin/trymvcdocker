package p.hh.trymvcdocker.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import p.hh.trymvcdocker.backend.dao.BookRepository;
import p.hh.trymvcdocker.backend.domain.Book;

import java.util.List;

@Service
@Transactional
public class BookService {

    private BookRepository bookRepository;
    private static final Book UNKOWN_BOOK = new Book("unknown");

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(readOnly = true)
    public Book getBook(long id) {
        return bookRepository.findById(id).orElse(UNKOWN_BOOK);
    }

    @Transactional(readOnly = true)
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(String name) {
        return bookRepository.save(new Book(name));
    }
}
