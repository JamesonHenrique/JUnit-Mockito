package com.jhcs.mockito.testDoubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {
    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> newBooks = new ArrayList<>();
        Book book1 =    new Book("1", "The First Java",500, LocalDate.now());
        Book book2 =   new Book("2", "The First Spring", 450, LocalDate.now());
        newBooks.add(book1);
        newBooks.add(book2);
        return
           newBooks;
    }
}
