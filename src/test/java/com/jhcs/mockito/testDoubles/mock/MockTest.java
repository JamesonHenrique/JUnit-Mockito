package com.jhcs.mockito.testDoubles.mock;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockTest {
    @Test
    public void demoMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1", "The First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "The First Spring", 450, LocalDate.now()); bookService.addBook(book1);
        bookService.addBook(book2); bookService.addBook(book1);
        bookRepositoryMock.verify(book2,1);
    }
    @Test
    public void demoMockWithMockito() {
        BookRepository bookRepository  = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        Book book1 = new Book("1", "The First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "The First Spring", 450, LocalDate.now()); bookService.addBook(book1);
        bookService.addBook(book2); bookService.addBook(book1);
        verify(bookRepository, times(1)).save(book2);
    }
}
