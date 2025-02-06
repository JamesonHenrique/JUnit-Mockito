package com.jhcs.mockito.exceptionHandling;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBooks()
            throws
            SQLException {
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());

    }

    @Test
    public void testTotalPriceOfBooks1()
            throws
            SQLException {
        when(bookRepository.findAllBooks()).thenThrow(new SQLException("Base de dados não disponivel"));
        assertThrows(DatabaseReadException.class, () -> bookService.getTotalPriceOfBooks());

    }
    @Test
    public void testAddBook()
            throws
            SQLException {
        Book book1 = new Book(null, "The First Java", 500, LocalDate.now());
        doThrow(SQLException.class).when(bookRepository).save(book1);
        assertThrows(DatabaseWriteException.class, () -> bookService.addBook(book1));

    }

}
