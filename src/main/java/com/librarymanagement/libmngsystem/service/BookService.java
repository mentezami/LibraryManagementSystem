package com.librarymanagement.libmngsystem.service;

import com.librarymanagement.libmngsystem.dto.BookDTO;

public interface BookService {
    BookDTO findBookById(Long id);
    BookDTO findBookByIsbn(String isbn);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBook(Long id, BookDTO bookDTO);
    void deleteBook(Long id);
}