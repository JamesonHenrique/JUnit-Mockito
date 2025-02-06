package com.jhcs.mockito.stubbing;

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

    public int calculateTotalCost(List<String> bookIds) {
        int total = 0;
        for(String bookId : bookIds){
            Book book = bookRepository.findBookByBookId(bookId);
            total = total + book.getPrice();
        }
        return total;
    }
}
