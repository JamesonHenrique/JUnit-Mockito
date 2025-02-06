package com.jhcs.mockito.stubbing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;
    @Test
    public void testCalculateTotalCostOfBooks() {
        List<String> booksIds = new ArrayList<>();
        booksIds.add("1");
        booksIds.add("2");
        Book book1 = new Book("1", "Head First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "Head First Spring", 450, LocalDate.now()); List<Book> newBooks = new ArrayList<>();

        when(bookRepository.findBookByBookId("1")).thenReturn(book1);
        when(bookRepository.findBookByBookId("2")).thenReturn(book2);
       int actualCost =  bookService.calculateTotalCost(booksIds);
       assertEquals(950, actualCost);

    }
}
