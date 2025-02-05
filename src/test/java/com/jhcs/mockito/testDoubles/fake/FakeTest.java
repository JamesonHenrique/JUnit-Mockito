package com.jhcs.mockito.testDoubles.fake;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FakeTest {
    @Test
    public void testFake() {
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);
        bookService.addBook(new Book("1", "Head First Java", 250, LocalDate.now()));
        bookService.addBook(new Book("2", "Head First Spring", 270, LocalDate.now()));
        assertEquals(2, bookService.findNumberOfBooks());
    }
}
