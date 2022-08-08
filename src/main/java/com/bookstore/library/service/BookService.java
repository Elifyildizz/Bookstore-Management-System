package com.bookstore.library.service;

import com.bookstore.library.model.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    String deleteBookById(long id);

    Book getBookById(long id);

    List<Book> getAllBooks();
}
