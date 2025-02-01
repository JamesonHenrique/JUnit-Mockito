package com.jhcs.assertions.assertIterableEquals;

import com.jhcs.bookstore.model.Book;
import com.jhcs.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class AssertIterableEqualsDemo {
    @Test
    public void assertIterableEqualsWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "O'Rei");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook); bookService.addBook(headFirstJavascriptBook);
        List<String> actualTitles = bookService.getBookTitlesByPublisher("O'Reilly");
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Design");
        assertIterableEquals(expectedTitles,actualTitles);
    }
    @Test
    public void assertIterableEqualsWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "O'Rei");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook); bookService.addBook(headFirstJavascriptBook);
        List<String> actualTitles = bookService.getBookTitlesByPublisher("O'Reilly");
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Design");
        assertIterableEquals(expectedTitles,actualTitles, "O titulo do livro não corresponde ao valor esperado");  }
    @Test
    public void assertIterableEqualsWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        Book headFirstJavascriptBook = new Book("3", "Head First Javascript", "O'Rei");

        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook); bookService.addBook(headFirstJavascriptBook);
        List<String> actualTitles = bookService.getBookTitlesByPublisher("O'Reilly");
        List<String> expectedTitles = new ArrayList<>();
        expectedTitles.add("Head First Java");
        expectedTitles.add("Head First Design");
        assertIterableEquals(expectedTitles,actualTitles, () -> "O titulo do livro não corresponde ao valor esperado");}
}
