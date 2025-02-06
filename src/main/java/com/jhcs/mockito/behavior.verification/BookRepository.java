package com.jhcs.mockito.behavior.verification;

import java.util.List;

public interface BookRepository {

    void save(Book book);

    Book findBookByBookId(String bookId);
}
