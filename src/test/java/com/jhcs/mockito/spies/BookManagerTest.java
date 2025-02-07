package com.jhcs.mockito.spies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {
    @InjectMocks
    private BookManager bookManager;
    @Spy
    private BookService bookService;

    @Test
    public void testMockitoSpy() {

        Book book = new Book("1", "The First Java", 500, LocalDate.now()); doReturn(book).when(bookService)
                .findBook("1");
//		when(bookService.findBook("1234")).thenReturn(book);
        int actualDiscount = bookManager.applyDiscountOnBook("1", 10); assertEquals(450, actualDiscount);

    }
}
