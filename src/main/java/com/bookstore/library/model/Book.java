package com.bookstore.library.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //autoincrement
    private long id;

    @Column(name = "book_name", nullable = false, length = 100)
    private String bookName;

    @Column(name = "author_name", length = 100)
    private String authorName;

    @Column(name = "book_page", nullable = false, length = 6)
    private int bookPage;

    @Column(name = "book_summary", length = 10000)
    private String bookSummary;

    @Column(name = "book_photo", length = 10000)
    private String bookPhoto;

    public Book() {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookPage = bookPage;
        this.bookSummary = bookSummary;
        this.bookPhoto = bookPhoto;
    }

    public long getId() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookPage() {
        return bookPage;
    }

    public void setBookPage(int bookPage) {
        this.bookPage = bookPage;
    }

    public String getBookSummary() {
        return bookSummary;
    }

    public void setBookSummary(String bookSummary) {
        this.bookSummary = bookSummary;
    }

    public String getBookPhoto() {
        return bookPhoto;
    }

    public void setBookPhoto(String bookPhoto) {
        this.bookPhoto = bookPhoto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(bookName, other.bookName);
    }
}
