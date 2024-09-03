package com.librarymanagement.libmngsystem.service.imp;

import com.librarymanagement.libmngsystem.dao.BookDAO;
import com.librarymanagement.libmngsystem.dto.BookDTO;
import com.librarymanagement.libmngsystem.exception.ResourceNotFoundException;
import com.librarymanagement.libmngsystem.mapper.BookMapper;
import com.librarymanagement.libmngsystem.entity.Book;
import com.librarymanagement.libmngsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookDAO bookDAO;
    private final BookMapper bookMapper;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "books", key = "#id")
    public BookDTO findBookById(Long id) {
        log.debug("Retrieving book with id {}", id);
        return bookDAO.findById(id).map(bookMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Book with id: " + id + " not found."));
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "books", key = "#isbn")
    public BookDTO findBookByIsbn(String isbn) {
        log.debug("Retrieving book with isbn {}", isbn);
        return bookDAO.findByIsbn(isbn).map(bookMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Book with isbn: " + isbn + " not found."));
    }

    @Override
    @Transactional
    @CachePut(value = "books", key = "#bookDTO.id")
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book createdBook = bookDAO.save(book);
        return bookMapper.toDto(createdBook);
    }

    @Override
    @Transactional
    @CachePut(value = "books", key = "#id")
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        if (!bookDAO.existsById(id)) {
            log.error("Failed to update book as not found with id {}", id);
            throw new ResourceNotFoundException("Book with id: " + id + " not found.");
        }
        Book book = bookMapper.toEntity(bookDTO);
        book.setId(id);
        Book updatedBook = bookDAO.save(book);
        return bookMapper.toDto(updatedBook);
    }

    @Override
    @Transactional
    @CacheEvict(value = "books", key = "#id")
    public void deleteBook(Long id) {
        if(!bookDAO.existsById(id)) {
            log.error("Failed to delete book with id {}", id);
            throw new ResourceNotFoundException("Book with id: " + id + " not found.");
        }
        bookDAO.deleteById(id);
    }
}