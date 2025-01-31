package com.jhcs.assertions.assertArrayEquals;

import com.jhcs.bookstore.model.Book;
import com.jhcs.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class AssertArrayEqualsDemo {
    @Test
    public void assertArrayEqualsWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "O'Reilly");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook); bookService.addBook(headFirstJavascriptBook);
        String[] book = bookService.getBookIdsByPublisher("O'Reilly");
        assertArrayEquals(new String[]{"1", "2", "3"},book);
    }
    @Test
    public void assertArrayEqualsWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "O'Reilly");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook); bookService.addBook(headFirstJavascriptBook);
        String[] book = bookService.getBookIdsByPublisher("O'Reilly");
        assertArrayEquals(new String[]{"1", "2", "3"},book, "Os ids dos livros não correspondem ao valor esperado");
    }
    @Test
    public void assertArrayEqualsWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "O'Reilly");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook); bookService.addBook(headFirstJavascriptBook);
        String[] book = bookService.getBookIdsByPublisher("O'Reilly");
        assertArrayEquals(new String[]{"1", "2", "3"},book, () -> "Os ids dos livros não correspondem ao valor esperado");
    }
}
