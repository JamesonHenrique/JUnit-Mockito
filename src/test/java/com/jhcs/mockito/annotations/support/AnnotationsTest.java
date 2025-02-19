package com.jhcs.mockito.annotations.support;

import com.jhcs.mockito.testDoubles.stub.Book;
import com.jhcs.mockito.testDoubles.stub.BookRepository;
import com.jhcs.mockito.testDoubles.stub.BookService;
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
public class AnnotationsTest {
    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;


    @Test
    public void demoCreateMocksUsingAnnotations() {


        Book book1 = new Book("1", "Head First Java", 500, LocalDate.now());
        Book book2 = new Book("2", "Head First Spring", 450, LocalDate.now()); List<Book> newBooks = new ArrayList<>();
        newBooks.add(book1); newBooks.add(book2); when(bookRepository.findNewBooks(7)).thenReturn(newBooks);
        List<Book> newBooksWithAppliedDiscount = bookService.getNewBooksWithAppliedDiscount(10, 7);

        assertEquals(2, newBooksWithAppliedDiscount.size()); assertEquals(450, newBooksWithAppliedDiscount.get(0)
                .getPrice()); assertEquals(405, newBooksWithAppliedDiscount.get(1)
                .getPrice());

    }
}
