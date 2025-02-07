package com.jhcs.mockito.spies;


public class BookManager {
    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }
    public int applyDiscountOnBook(String bookId, int discount) {
        Book book = bookService.findBook(bookId);
        int discountedPrice = bookService.getAppliedDiscount(book, discount);
        return discountedPrice;
    }
}
