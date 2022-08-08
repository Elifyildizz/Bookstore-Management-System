package com.bookstore.library.repository;

import com.bookstore.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    //instead of connecting db from mysql it creates default db for us
}
