package com.jhcs.junit.assertions.assertNotEquals;

import com.jhcs.junit.bookstore.model.Book;
import com.jhcs.junit.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AssertNotEqualsDemo {
    @Test
    public void assertNotEqualsWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertNotEquals("Head First Design", book.getTitle());
    }
    @Test
    public void assertNotEqualsWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertNotEquals("Head First Design", book.getTitle(), "O livro corresponde ao valor esperado");
    }
    @Test
    public void assertNotEqualsWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertNotEquals("Head First Design", book.getTitle(),() -> "O livro corresponde ao valor esperado");
    }
}
