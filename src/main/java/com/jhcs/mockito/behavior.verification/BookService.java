package com.jhcs.mockito.behavior.verification;



import java.util.List;

public class BookService {
    private BookRepository bookRepository;


    public void addBook(Book book) {

         bookRepository.save(book);

    }
    public void addBook(BookRequest bookRequest) {
        if(bookRequest.getPrice() <= 500){
            return;
        }
        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedDate(bookRequest.getPublishedDate());
        bookRepository.save(book);
    }
    public void updatePrice(String bookId, int updatedPrice) {
        if(bookId == null) {
            return;
        }
        Book book = bookRepository.findBookByBookId(bookId);
        book.setPrice(updatedPrice);
        bookRepository.save(book);
    }

}
