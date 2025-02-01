package com.jhcs.exception;

import com.jhcs.bookstore.exception.BookNotFoundException;
import com.jhcs.bookstore.model.Book;
import com.jhcs.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AssertThrowsDemo {
    @Test
    public void assertThrowsWithNoMessage() {

        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);

        assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookByTitle("Head First Spring");
        });


    }
    @Test
    public void assertThrowsWithMessage() {

        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);

        assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookByTitle("Head First Spring");
        }, "Exceção diferente lançada!");


    }
    @Test
    public void assertThrowsWithMessageSupplier() {

        BookService bookService = new BookService();

        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);

        assertThrows(BookNotFoundException.class, () -> {
            bookService.getBookByTitle("Head First Spring");
        }, () ->"Exceção diferente lançada!");


    }
}
