package com.jhcs.mockito.testDoubles.dummy;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyTest {
    @Test
    public void demoDummy() {
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
    BookService bookService = new BookService(bookRepository, emailService);
        bookService.addBook(new Book("1", "Head First Java", 250, LocalDate.now()));
        bookService.addBook(new Book("2", "Head First Spring", 270, LocalDate.now()));
        assertEquals(2, bookService.findNumberOfBooks());
    }
}
