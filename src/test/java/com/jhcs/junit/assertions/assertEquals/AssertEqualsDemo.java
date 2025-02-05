package com.jhcs.junit.assertions.assertEquals;

import com.jhcs.junit.bookstore.model.Book;
import com.jhcs.junit.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertEqualsDemo {
    @Test
    public void assertEqualsWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertEquals("Head First Java", book.getTitle());
    }
    @Test
    public void assertEqualsWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertEquals("Head First Java", book.getTitle(), "O livro não corresponde ao valor esperado");
    }
    @Test
    public void assertEqualsWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertEquals("Head First Java", book.getTitle(),() -> "O livro não corresponde ao valor esperado");
    }
}
