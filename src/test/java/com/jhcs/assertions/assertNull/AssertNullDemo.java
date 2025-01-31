package com.jhcs.assertions.assertNull;

import com.jhcs.bookstore.model.Book;
import com.jhcs.bookstore.service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertNullDemo {
    @Test
    public void assertTrueWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1");
        assertNull(book);

    }
    @Test
    public void assertTrueWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("3");
        assertNull(book, "O livro não é nulo");

    }
    @Test
    public void assertTrueWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook);
        bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("3");
        assertNull(book, () -> "O livro não é nulo");

    }

}
