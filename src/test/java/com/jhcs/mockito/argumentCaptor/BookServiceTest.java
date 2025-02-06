package com.jhcs.mockito.argumentCaptor;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;
    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;

    @Test
    public void testSaveBook() {
        BookRequest bookRequest = new BookRequest("The First Java", 500, LocalDate.now());
        bookService.addBook(bookRequest);
        verify(bookRepository).save(bookArgumentCaptor.capture()); Book capturedBook = bookArgumentCaptor.getValue();
        assertEquals("The First Java", capturedBook.getTitle());
    }

}
