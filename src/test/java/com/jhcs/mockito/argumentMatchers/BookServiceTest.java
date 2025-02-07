package com.jhcs.mockito.argumentMatchers;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)

public class BookServiceTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;


    @Test
    public void testUpdatePrice() {
        Book book1 = new Book("1", "The First In Java", 600, LocalDate.now());
        Book book2 = new Book("1", "The First In Java", 500, LocalDate.now());
        when(bookRepository.findBookById(any(String.class))).thenReturn(book1); bookService.updatePrice("1", 500);
        verify(bookRepository).save(book2);
    }

    //@Test
    //public void testInvalidUseOfArgumentsMatchers() {
    //    Book book = new Book("1", "The First In Java", 600, LocalDate.now());
    //    when(bookRepository.findBookByTitleAndPublishedDate(eq("The First In Java"), any())).thenReturn(book);
    //    Book actualBook = bookService.getBookByTitleAndPublishedDate(eq("The First In Java"), any());
    //    assertEquals("The First In Java", actualBook.getTitle());
    //}

    @Test
    public void testSpecificUseOfArgumentsMatchers() {
        Book book = new Book("1", "The First In Java", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(anyString(), anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("The First In Java", 600, true);
        assertEquals("The First In Java", actualBook.getTitle());
    }

    @Test
    public void testCollectionTypeArgumentMatchers() {
        List<Book> books = new ArrayList<>(); Book book = new Book("1", "The First In Java", 600, LocalDate.now());
        books.add(book); bookService.addBooks(books);
        verify(bookRepository).saveAll(anyList()); // anySet, anyMap, anyCollection
    }

    @Test
    public void testStringTypeArgumentMatchers() {
        Book book = new Book("1", "The First In Java", 600, LocalDate.now());
        when(bookRepository.findBookByTitleAndPriceAndIsDigital(contains("First"), anyInt(), anyBoolean())).thenReturn(book);
        Book actualBook = bookService.getBookByTitleAndPriceAndIsDigital("The First In Spring", 600, true);
        assertEquals("The First In Java", actualBook.getTitle());
    }


}
