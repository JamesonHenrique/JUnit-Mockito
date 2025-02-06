package com.jhcs.mockito.behavior.verification;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;
@Test
    public void testAddBook() {
        Book book1 = new Book(null, "The First Java", 500, LocalDate.now());
        bookService.addBook(book1);
        verify(bookRepository).save(book1);
}

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice() {
        BookRequest bookRequest = new BookRequest("The First Java", 500, LocalDate.now());
        Book book = new Book(null, "The First Java", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository, times(0)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice1() {
        BookRequest bookRequest = new BookRequest("The First Java", 600, LocalDate.now());
        Book book = new Book(null, "The First Java", 600, LocalDate.now());
        bookService.addBook(bookRequest);
        bookService.addBook(bookRequest);
        verify(bookRepository, times(2)).save(book);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice2() {
        BookRequest bookRequest = new BookRequest("The First Java", 500, LocalDate.now());
        Book book = new Book(null, "Mockito In Action", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository, never()).save(book);
    }
    @Test
    public void testUpdatePrice() {

        bookService.updatePrice(null, 600);
        verifyNoInteractions(bookRepository);
    }
}
