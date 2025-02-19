package com.jhcs.mockito.testDoubles.spy;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if (book.getPrice() > 450) {
            return;
        } bookRepository.save(book);

    }
}
