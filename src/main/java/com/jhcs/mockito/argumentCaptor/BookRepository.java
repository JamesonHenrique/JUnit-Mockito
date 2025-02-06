package com.jhcs.mockito.argumentCaptor;

public interface BookRepository {

    void save(Book book);

    Book findBookByBookId(String bookId);
}
