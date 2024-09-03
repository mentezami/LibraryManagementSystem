package com.librarymanagement.libmngsystem.dao;

import com.librarymanagement.libmngsystem.entity.Book;
import java.util.Optional;

public interface BookDAO {
    Optional<Book> findById(Long id);
    Optional<Book> findByIsbn(String isbn);
    Book save(Book book);
    void deleteById(Long id);
    boolean existsById(Long id);
}