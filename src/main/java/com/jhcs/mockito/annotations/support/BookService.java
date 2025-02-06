package com.jhcs.mockito.annotations.support;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
   public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        for (Book book : newBooks) {
            int price = book.getPrice();
            int discountedPrice = price - (price * discountRate / 100);
            book.setPrice(discountedPrice);
        }
        return newBooks;
    }
}
