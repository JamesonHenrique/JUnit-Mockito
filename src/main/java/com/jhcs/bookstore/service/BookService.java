package com.jhcs.bookstore.service;

import com.jhcs.bookstore.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService {
    private List<Book> listOfBooks = new ArrayList<>();
    public void addBook(Book book) {
        listOfBooks.add(book);
    }
    public List<Book> books() {
        return Collections.unmodifiableList(listOfBooks);
    }
}
