package com.bookstore.library.controller;

import com.bookstore.library.model.Book;
import com.bookstore.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
// enables to access from webstorm
@RestController
@RequestMapping(path = "api/v1/books")
//instead of going to localhost:8080
public class BookController {

    private final BookService bookService;

    @Autowired
    //enables you to inject the object dependency implicitly
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/getAllBooks")
    //handle the HTTP GET requests matched with given URI expression.
    //URI = URN(Uniform Resource Name) + URL(Uniform Resource Locator)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById((id));
    }

    @PostMapping("/saveBook")
    //handle the HTTP POST requests matched with given URI expression.
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") long id) {
        return bookService.deleteBookById(id);
    }
}
