package com.jhcs.mockito.testDoubles.mock;

import com.jhcs.mockito.testDoubles.mock.Book;
import com.jhcs.mockito.testDoubles.mock.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookRepositoryMock implements BookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public void verify(Book book, int times){
        assertEquals(times, saveCalled);
        assertEquals(book, lastAddedBook);
    }

}