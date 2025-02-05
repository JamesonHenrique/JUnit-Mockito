package com.jhcs.mockito.testDoubles.mock;


import com.jhcs.mockito.testDoubles.spy.Book;
import com.jhcs.mockito.testDoubles.spy.BookService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockTest {
    @Test
    public void demoMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);
        Book book1 = new com.jhcs.mockito.testDoubles.spy.Book("1", "The First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "The First Spring", 450, LocalDate.now()); bookService.addBook(book1);
        bookService.addBook(book2); bookService.addBook(book1);
        bookRepositoryMock.verify(book2,1);
    }
}
