package com.librarymanagement.libmngsystem.mapper;

import com.librarymanagement.libmngsystem.dto.BookDTO;
import com.librarymanagement.libmngsystem.entity.Book;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T21:21:20-0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDTO toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDTO bookDTO = new BookDTO();

        bookDTO.setId( book.getId() );
        bookDTO.setIsbn( book.getIsbn() );
        bookDTO.setTitle( book.getTitle() );
        bookDTO.setAuthor( book.getAuthor() );
        bookDTO.setPublisher( book.getPublisher() );
        bookDTO.setPublicationYear( book.getPublicationYear() );
        bookDTO.setGenre( book.getGenre() );
        bookDTO.setNumberOfCopies( book.getNumberOfCopies() );

        return bookDTO;
    }

    @Override
    public Book toEntity(BookDTO bookDTO) {
        if ( bookDTO == null ) {
            return null;
        }

        Book book = new Book();

        book.setId( bookDTO.getId() );
        book.setIsbn( bookDTO.getIsbn() );
        book.setTitle( bookDTO.getTitle() );
        book.setAuthor( bookDTO.getAuthor() );
        book.setPublisher( bookDTO.getPublisher() );
        book.setPublicationYear( bookDTO.getPublicationYear() );
        book.setGenre( bookDTO.getGenre() );
        book.setNumberOfCopies( bookDTO.getNumberOfCopies() );

        return book;
    }
}
