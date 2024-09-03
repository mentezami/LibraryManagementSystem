package com.librarymanagement.libmngsystem.service.imp;

import com.librarymanagement.libmngsystem.dto.BookDTO;
import com.librarymanagement.libmngsystem.service.AsyncBookService;
import com.librarymanagement.libmngsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncBookServiceImpl implements AsyncBookService {

    private final BookService bookService;

    @Override
    @Async
    public CompletableFuture<BookDTO> getBookByIdAsync(Long id) {
        return CompletableFuture.supplyAsync(() -> bookService.findBookById(id));
    }
}