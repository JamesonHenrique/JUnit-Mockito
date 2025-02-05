package com.jhcs.mockito.testDoubles.dummy;

import com.jhcs.mockito.testDoubles.dummy.Book;
import com.jhcs.mockito.testDoubles.dummy.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {
    Map<String,Book> bookStore = new HashMap<>();
    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
