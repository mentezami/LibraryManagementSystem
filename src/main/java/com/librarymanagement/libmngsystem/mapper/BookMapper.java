package com.librarymanagement.libmngsystem.mapper;

import com.librarymanagement.libmngsystem.dto.BookDTO;
import com.librarymanagement.libmngsystem.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "publisher", target = "publisher")
    @Mapping(source = "publicationYear", target = "publicationYear")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "numberOfCopies", target = "numberOfCopies")
    BookDTO toDto(Book book);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "publisher", target = "publisher")
    @Mapping(source = "publicationYear", target = "publicationYear")
    @Mapping(source = "genre", target = "genre")
    @Mapping(source = "numberOfCopies", target = "numberOfCopies")
    Book toEntity(BookDTO bookDTO);
}