package com.jhcs.junit.assertions.assertTimeoutPreemptively;

import com.jhcs.junit.bookstore.model.Book;
import com.jhcs.junit.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

public class AssertTimeoutPreemptivelyDemo {
    @Test
    public void assertTimeoutPreemptivelyWithNoMessage() {
        BookService bookService = new BookService();

        for (int i = 1; i <= 1000; i++) {
            bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Wrox"));
        });

        assertEquals(1000, actualTitles.size());

    }

    @Test
    public void assertTimeoutPreemptivelyWithMessage() {
        BookService bookService = new BookService();

        for (int i = 1; i <= 1000; i++) {
            bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Wrox"));
        }, "Problemas de desempenho com o método getBookTitlesByPublisher() !");

        assertEquals(1000, actualTitles.size());

    }

    @Test
    public void assertTimeoutPreemptivelyWithMessageSupplier() {
        BookService bookService = new BookService();

        for (int i = 1; i <= 1000; i++) {
            bookService.addBook(new Book(String.valueOf(i), "Head First Java", "Wrox"));
        }

        List<String> actualTitles = new ArrayList<>();

        assertTimeoutPreemptively(Duration.ofMillis(1), () -> {
            actualTitles.addAll(bookService.getBookTitlesByPublisher("Wrox"));
        }, () -> "Problemas de desempenho com o método getBookTitlesByPublisher() !");

        assertEquals(1000, actualTitles.size());

    }
}
