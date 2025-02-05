package com.jhcs.mockito.testDoubles.spy;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SpyTest {
    @Test
    public void demoSpy() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);
        Book book1 = new Book("1", "The First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "The First Spring", 450, LocalDate.now()); bookService.addBook(book1);
        bookService.addBook(book2);

        assertEquals(1, bookRepositorySpy.timesCalled());

    }

    @Test
    public void demoSpyWithMockito() {
        BookRepository bookRepository = spy(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book1 = new Book("1", "The First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "The First " + "Spring", 450, LocalDate.now()); bookService.addBook(book1);
        bookService.addBook(book2); bookService.addBook(book1); verify(bookRepository, times(1)).save(book2);
    }
}
