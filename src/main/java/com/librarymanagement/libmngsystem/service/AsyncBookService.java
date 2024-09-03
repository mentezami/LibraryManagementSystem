package com.librarymanagement.libmngsystem.service;

import com.librarymanagement.libmngsystem.dto.BookDTO;
import java.util.concurrent.CompletableFuture;

public interface AsyncBookService {
    CompletableFuture<BookDTO> getBookByIdAsync(Long id);
}