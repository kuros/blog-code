package in.kuros.blog.code.spring.security.basics.controller;

import in.kuros.blog.code.spring.security.basics.entity.Book;
import in.kuros.blog.code.spring.security.basics.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(path = "books")
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
