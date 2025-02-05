package com.jhcs.junit.assertions.assertTrue;

import com.jhcs.junit.bookstore.model.Book;
import com.jhcs.junit.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertTrueDemo {
    @Test
    public void assertTrueWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        // bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertTrue(listOfBooks.isEmpty());
    }
    @Test
    public void assertTrueWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        // bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertTrue(listOfBooks.isEmpty(), "A lista de livros não está vazia");
    }
    @Test
    public void assertTrueWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        // bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertTrue(listOfBooks.isEmpty(), () -> "A lista de livros não está vazia");
    }
    @Test
    public void assertTrueWithBooleanSupplierAndNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        // bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertTrue(() -> listOfBooks.isEmpty());
    }
    @Test
    public void assertTrueWithBooleanSupplierAndMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        // bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertTrue(() -> listOfBooks.isEmpty(), "A lista de livros não está vazia");
    }
    @Test
    public void assertTrueWithBooleanSupplierAndSupplierMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book(
                "1",
                "Head First Java",
                "O'Reilly"
        );
        // bookService.addBook(headFirstJavaBook);
        List<Book> listOfBooks = bookService.books();
        assertTrue(() -> listOfBooks.isEmpty(), () -> "A lista de livros não está vazia");
    }
}
