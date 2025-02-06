package com.jhcs.mockito.exceptionHandling;


import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            throw new DatabaseReadException("Não é possivel ler livros do banco de dados - " + e.getMessage());
        }
        int totalPrice = 0;
        for(Book book : books) {
            totalPrice += book.getPrice();
        }
        return totalPrice;
    }
    public void addBook(Book book)
            throws
            SQLException {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            throw new DatabaseWriteException("Não é possivel salvar livro no banco de dados - " + e.getMessage());
        }
    }
}
