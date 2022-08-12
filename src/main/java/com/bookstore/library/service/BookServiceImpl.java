package com.bookstore.library.service;

import com.bookstore.library.model.Book;
import com.bookstore.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {

        List<Book> newList = bookRepository.findAll();
        for (Book book1 : newList) {
            if (book.getBookName().equals(book1.getBookName())) {
                throw new RuntimeException("This book is already in library");
            }
        }
        this.bookRepository.save(book);
        return book;

    }

    @Override
    public String deleteBookById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            this.bookRepository.deleteById(optionalBook.get().getId());
        } else {
            throw new RuntimeException("Book not found for id : " + id);
        }
        return null;
    }

    @Override
    public Book getBookById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
        } else {
            throw new RuntimeException("Book not found for id : " + id);
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
