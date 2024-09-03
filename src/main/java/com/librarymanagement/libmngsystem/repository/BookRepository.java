package com.librarymanagement.libmngsystem.repository;

import com.librarymanagement.libmngsystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select b from Book b where b.isbn = :isbn")
    Optional<Book> findByIsbn(@Param("isbn") String isbn);
}