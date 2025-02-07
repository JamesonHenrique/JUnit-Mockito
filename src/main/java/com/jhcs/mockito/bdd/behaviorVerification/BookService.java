package com.jhcs.mockito.bdd.behaviorVerification;



import com.jhcs.mockito.behavior.verification.BookRequest;

public class BookService {
    private BookRepository bookRepository;



    public void updatePrice(String bookId, int updatedPrice) {

        Book book = bookRepository.findBookByBookId(bookId);

        book.setPrice(updatedPrice);
        bookRepository.save(book);
    }

}
