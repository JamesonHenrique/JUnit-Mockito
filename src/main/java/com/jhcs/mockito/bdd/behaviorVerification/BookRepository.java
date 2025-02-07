package com.jhcs.mockito.bdd.behaviorVerification;

public interface BookRepository {

    void save(Book book);

    Book findBookByBookId(String bookId);
}
