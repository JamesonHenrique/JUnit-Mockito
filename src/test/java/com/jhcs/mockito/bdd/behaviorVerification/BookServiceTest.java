package com.jhcs.mockito.bdd.behaviorVerification;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

//	@Spy
//	private BookRepository bookRepository;

    @Test
    public void testUpdatePrice2() {
        Book book = new Book("1", "The First Java", 500, LocalDate.now());
        when(bookRepository.findBookByBookId("1")).thenReturn(book);
        bookService.updatePrice("1", 500);
        verify(bookRepository).findBookByBookId("1");
        verify(bookRepository).save(book);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void test_Given_ABook_When_UpdatePriceIsCalledWithNewPrice_Then_BookPriceIsUpdated() {
        // Given - Arrange
        Book book = new Book("1", "The First Java ", 500, LocalDate.now());
        given(bookRepository.findBookByBookId("1")).willReturn(book);

        // When - Act
        bookService.updatePrice("1", 500);

        // Then - Assert/Verify
        then(bookRepository).should().save(book);
    }

}