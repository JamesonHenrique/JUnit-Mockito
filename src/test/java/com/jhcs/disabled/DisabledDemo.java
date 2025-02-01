package com.jhcs.disabled;

import com.jhcs.bookstore.model.Book;
import com.jhcs.bookstore.service.BookService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisabledDemo {
    @Test
    @Disabled("Teste desabilitado para resolver bugs")
    public void assertEqualsWithNoMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertEquals("Head First Java", book.getTitle());
    }
    @Test
    public void assertEqualsWithMessage() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertEquals("Head First Java", book.getTitle(), "O livro não corresponde ao valor esperado");
    }
    @Test
    public void assertEqualsWithMessageSupplier() {
        BookService bookService = new BookService();
        Book headFirstJavaBook = new Book("1", "Head First Java", "O'Reilly");
        Book headFirstDesignBook = new Book("2", "Head First Design", "O'Reilly");
        bookService.addBook(headFirstJavaBook); bookService.addBook(headFirstDesignBook);
        Book book = bookService.getBookById("1"); assertEquals("Head First Java", book.getTitle(),() -> "O livro não corresponde ao valor esperado");
    }
}
