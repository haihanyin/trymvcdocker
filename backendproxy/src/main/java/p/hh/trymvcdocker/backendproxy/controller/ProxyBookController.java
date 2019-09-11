package p.hh.trymvcdocker.backendproxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyBookController {

    private RestTemplate restTemplate;

    @Autowired
    public ProxyBookController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Book getBook(@PathVariable long id) {
        ResponseEntity<Book> bookEntity = restTemplate.getForEntity("http://localhost:8080/book/" + id, Book.class);
        Book book = bookEntity.getBody();
        if (book != null) {
            book.decorateName();
        }
        return book;
    }

}
