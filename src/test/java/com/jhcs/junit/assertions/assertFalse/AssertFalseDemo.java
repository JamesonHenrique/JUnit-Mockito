package com.jhcs.junit.assertions.assertFalse;


import com.jhcs.junit.bookstore.model.Book;
import com.jhcs.junit.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AssertFalseDemo {
    @Test
    public void assertFalseWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertFalse(listOfBooks.isEmpty());
    }
    @Test
    public void assertFalseWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertFalse(listOfBooks.isEmpty(), "A lista de livros está vazia");
    }
    @Test
    public void assertFalseWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertFalse(listOfBooks.isEmpty(), () -> "A lista de livros está vazia");
    }
    @Test
    public void assertFalseWithBooleanSupplierAndNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertFalse(() -> listOfBooks.isEmpty());
    }
    @Test
    public void assertFalseWithBooleanSupplierAndMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertFalse(() -> listOfBooks.isEmpty(), "A lista de livros está vazia");
    }
    @Test
    public void assertFalseWithBooleanSupplierAndSupplierMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertFalse(() -> listOfBooks.isEmpty(), () -> "A lista de livros está vazia");
    }
}
