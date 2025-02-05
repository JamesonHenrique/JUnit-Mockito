package com.jhcs.junit.assertions.assertNotNull;

import com.jhcs.junit.bookstore.model.Book;
import com.jhcs.junit.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class AssertNotNullDemo {
    @Test
    public void assertNotNullWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1");
        assertNotNull(book);
    }
    @Test
    public void assertNotNullWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1");
        assertNotNull(book, "O livro é nulo");

    }
    @Test
    public void assertNotNullWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1");
        assertNotNull(book, () -> "O livro é nulo");

    }

}
